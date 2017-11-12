import {Injectable, OnInit} from '@angular/core';
import {AppUrls} from "../../_service/util/app-urls";
import {Observable} from "rxjs/Observable";
import {Conversation} from "../../_model/conversation";
import {PrivateMessage} from "../../_model/private-message";
import {HttpSecService} from "../../_service/util/http-sec.service";
import {Http} from "@angular/http";
import {isNullOrUndefined} from "util";
import {ChatRequest} from "../../_model/chat-request";
import has = Reflect.has;

@Injectable()
export class ChatManagerService implements OnInit{

  constructor(private http: Http, private httpSrv: HttpSecService) {
    this.handleConversationsRefreshLoop();
  }

  ngOnInit(){
  }

  public playNotifyAudio(){
    console.log("playNotifyAudio");
    let audio = new Audio();
    audio.src = "/assets/sounds/notify.wav";
    audio.load();
    audio.play();
  }



  conversationListSorted: Conversation[] = [];
  conversationOldList: Conversation[] = [];

  actualConversation: Conversation;
  actualMessageList: PrivateMessage[] = [];

  newMessageFlag: boolean = false;
  chatComponentInited: boolean = false;

  requestMessageLoop: boolean = true;
  requestConversationsLoop: boolean = true;

  public unsetMessages(){
    this.actualConversation = null;
    this.actualMessageList = null;
  }



  public setChatComponentInited(inited: boolean){
    this.chatComponentInited = inited;
  }

  rememberOldMessagesState(){
    this.conversationOldList = this.conversationListSorted;
  }

  handleMessageRefreshLoop() {
    if(this.requestMessageLoop){
      this.updateMessagesAfter();
      setTimeout(msg=>{
        this.handleMessageRefreshLoop();
      },5000);
    }
  }

  handleConversationsRefreshLoop() {
    if(this.requestConversationsLoop){
      this.updateAllConversations();
      setTimeout(conv=>{
        this.handleConversationsRefreshLoop();
      },5000);
    }
  }

  public startChatService(){
    console.log("startChatService");
    this.updateData();
    this.requestConversationsLoop = true;
    this.handleConversationsRefreshLoop();
  }

  public stopAndClearChatService(){
    this.requestConversationsLoop = false;
    this.conversationListSorted = null;
    this.actualConversation = null;
    this.actualMessageList = null;
  }

  public startMessagesRefreshing(){
    this.requestMessageLoop = true;
    this.handleMessageRefreshLoop();
  }

  public stopMessagesRefreshing(){
    this.requestMessageLoop = false;
  }

  public changeConversation(conversation: Conversation){
    this.actualConversation = conversation;
    this.getLastMessages(conversation.id).subscribe(resp=>{
      this.actualMessageList = resp;
    });
  }

  public updateData(){
    this.updateAllConversations();

    if(!isNullOrUndefined(this.actualConversation) && !isNullOrUndefined(this.actualMessageList) && this.actualMessageList.length>0){
      let lastMessageId = this.actualMessageList[this.actualMessageList.length-1].id;
      this.getMessagesAfter(this.actualConversation.id, lastMessageId).subscribe(resp=>{
        resp.forEach(msg=>{
          this.actualMessageList.push(msg);
        })
      });
    }else if(!isNullOrUndefined(this.actualConversation)) {
      this.getLastMessages(this.actualConversation.id).subscribe(resp=>{
        this.actualMessageList = resp;
      });
    }
  }

  public sendMessage(text: string){
    if(!isNullOrUndefined(this.actualConversation)){
      this.sendNewMessage(this.actualConversation, text).subscribe(resp=>{
        this.updateData();
      });
    }
  }

  public updateMessagesBefore() : Observable<any>{
    let lastId = this.getFirstMessageId();
    if(!isNullOrUndefined(lastId)){
      return this.getMessagesBefore(this.actualConversation.id,lastId).map(resp=>{
        resp.forEach(msg=>{
          this.actualMessageList.unshift(msg);
        });
      });
    }
  }

  public updateMessagesAfter(){
    let lastId = this.getLastMessageId();
    if(!isNullOrUndefined(lastId)) {
      this.getMessagesAfter(this.actualConversation.id,lastId).subscribe(resp => {
        resp.forEach(msg=>{
          this.actualMessageList.push(msg);
        });
      });
    }
  }

  public updateAllConversations() {
    this.getAllConversations().subscribe(resp=>{
      this.handleConversationUpdate(resp);
    });
  }

  public unsetNewMessageFlag(){
    this.newMessageFlag = false;
  }

  private handleConversationUpdate(newList: Conversation[]){
    this.conversationOldList = this.conversationListSorted;
    this.conversationListSorted = this.sortArray(newList);

    if(!this.newMessageFlag && !this.chatComponentInited && this.conversationOldList != null && this.conversationListSorted != null){
      this.newMessageFlag = this.checkForDifferences(this.conversationOldList, this.conversationListSorted);

      if(this.newMessageFlag){
        this.playNotifyAudio();
      }
    }
  }

  checkForDifferences(oldList: Conversation[], newList: Conversation[]) : boolean{
    if(oldList.length != newList.length){
      return true;
    }

    let hasDifference: boolean = false;
    newList.forEach(newElem => {
      oldList.forEach(oldElem =>{
        if(newElem.id == oldElem.id ){
          if(isNullOrUndefined(newElem.lastMessage) && isNullOrUndefined(oldElem.lastMessage)){
            //nic
          }
          else if(!isNullOrUndefined(newElem.lastMessage) && isNullOrUndefined(oldElem.lastMessage)){
            hasDifference = true;
          }
          else if(isNullOrUndefined(newElem.lastMessage) && !isNullOrUndefined(oldElem.lastMessage)){
            hasDifference = true;
          }
          else if(newElem.lastMessage.id != oldElem.lastMessage.id) {
            hasDifference = true;
          }
        }
      });
    });
    return hasDifference;
  }

  private isEmpty(list: any[]) : boolean {
    if(isNullOrUndefined(list) || list.length<=0){
      return true;
    }else {
      return false;
    }
  }

  private getAllConversations() : Observable<Conversation[]> {
    return this.httpSrv.getAndFetchData(AppUrls.GET_ALL_CONVERSATION_URL).map(resp => <any> resp);
  }

  private getFirstMessageId(){
    if(!isNullOrUndefined(this.actualMessageList) && this.actualMessageList.length>0){
      return this.actualMessageList[0].id;
    }
    return null;
  }

  private getLastMessageId(){
    if(!isNullOrUndefined(this.actualMessageList) && this.actualMessageList.length>0){
      return this.actualMessageList[this.actualMessageList.length-1].id;
    }
    return null;
  }

  private getLastMessages(conversationId: number) : Observable<PrivateMessage[]> {
    let body = new ChatRequest();
    body.conversationId = conversationId;
    return this.httpSrv.postAndFetchData(AppUrls.GET_LAST_MESSAGES_URL,body).map(resp => <any> resp);
  }

  private getMessagesBefore(conversationId: number, messageId: number) : Observable<any> {
    let body = new ChatRequest();
    body.conversationId = conversationId;
    body.messageId = messageId;
    return this.httpSrv.postAndFetchData(AppUrls.GET_MESSAGES_BEFORE_URL,body).map(resp => <any> resp);
  }

  private getMessagesAfter(conversationId: number, messageId: number) : Observable<PrivateMessage[]> {
    let body = new ChatRequest();
    body.conversationId = conversationId;
    body.messageId = messageId;
    return this.httpSrv.postAndFetchData(AppUrls.GET_MESSAGES_AFTER_URL,body).map(resp => <any> resp);
  }

  private sendNewMessage(conversation: Conversation, messageText: string) : Observable<PrivateMessage>{
    let body = new ChatRequest();
    body.conversation = conversation;
    body.messageText = messageText;
    return this.httpSrv.postAndFetchData(AppUrls.SEND_MESSAGE_URL,body).map(resp => <any> resp);
  }

  public createNewConversation(receiverId: number) : Observable<Conversation>{
    let body = receiverId;
    return this.httpSrv.postAndFetchData(AppUrls.CREATE_CONVERSATION_URL,body).map(resp => {
      this.changeConversation(resp);
      return <any> resp;
    });
  }

  public sortArray(array: Conversation[]): Conversation[]{
    let sorted: Conversation[] = array.sort((n1,n2) => {
      if(n1.lastMessage.id > n2.lastMessage.id){
        return -1;
      }
      else if(n1.lastMessage.id < n2.lastMessage.id){
        return 1;
      }
      else {
        return 0;
      }
    });
    return sorted;
  }
}

