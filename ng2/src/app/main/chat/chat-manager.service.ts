import {Injectable, OnInit} from '@angular/core';
import {AppUrls} from "../../_service/util/app-urls";
import {Observable} from "rxjs/Observable";
import {Conversation} from "../../_model/conversation";
import {PrivateMessage} from "../../_model/private-message";
import {HttpSecService} from "../../_service/util/http-sec.service";
import {Http} from "@angular/http";
import {isNullOrUndefined} from "util";
import {ChatRequest} from "../../_model/ChatRequest";

@Injectable()
export class ChatManagerService implements OnInit{

  constructor(private http: Http, private httpSrv: HttpSecService) {
    this.handleLoop();
  }

  ngOnInit(){

  }

  conversationList: Conversation[];
  actualConversation: Conversation;
  actualMessageList: PrivateMessage[];

  handleLoop(){
    console.log("TEST handleLoop");
    this.updateMessagesAfter();
    setTimeout(test=>{
      this.handleLoop();
    },5000);
  }



  public changeConversation(conversation: Conversation){
    this.actualConversation = conversation;
    this.getLastMessages(conversation.id).subscribe(resp=>{
      this.actualMessageList = resp;
    });
  }

  public updateData(){
    this.getAllConversations().subscribe(resp=>{
      this.conversationList = resp;
    });

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

  public updateMessagesBefore(){
    let lastId = this.getFirstMessageId();
    if(!isNullOrUndefined(lastId)){
      this.getMessagesBefore(this.actualConversation.id,lastId).subscribe(resp=>{
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
      this.conversationList = resp;
    });
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

  private getMessagesBefore(conversationId: number, messageId: number) : Observable<PrivateMessage[]> {
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

  private createNewConversation(receiverId: number) : Observable<PrivateMessage>{
    let body = receiverId;
    return this.httpSrv.postAndFetchData(AppUrls.CREATE_CONVERSATION_URL,body).map(resp => <any> resp);
  }
}
