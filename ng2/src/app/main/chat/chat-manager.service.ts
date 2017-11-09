import { Injectable } from '@angular/core';
import {AppUrls} from "../../_service/util/app-urls";
import {Observable} from "rxjs/Observable";
import {Conversation} from "../../_model/conversation";
import {PrivateMessage} from "../../_model/private-message";
import {HttpSecService} from "../../_service/util/http-sec.service";
import {Http} from "@angular/http";

@Injectable()
export class ChatManagerService {

  constructor(private http: Http, private httpSrv: HttpSecService) { }


  getAllConversations() : Observable<Conversation[]> {
    return this.httpSrv.getAndFetchData(AppUrls.GET_ALL_CONVERSATION_URL).map(resp => <any> resp);
  }

  getLastMessages(conversationId: number) : Observable<PrivateMessage[]> {
    let body = {
      'conversationId' : conversationId
    };
    return this.httpSrv.postAndFetchData(AppUrls.GET_LAST_MESSAGES_URL,body).map(resp => <any> resp);
  }

  getMessagesBefore(conversationId: number, messageId: number) : Observable<PrivateMessage[]> {
    let body = {
      'conversationId' : conversationId,
      'messageId' : messageId
    };
    return this.httpSrv.postAndFetchData(AppUrls.GET_MESSAGES_BEFORE_URL,body).map(resp => <any> resp);
  }

  getMessagesAfter(conversationId: number, messageId: number) : Observable<PrivateMessage[]> {
    let body = {
      'conversationId' : conversationId,
      'messageId' : messageId
    };
    return this.httpSrv.postAndFetchData(AppUrls.GET_MESSAGES_AFTER_URL,body).map(resp => <any> resp);
  }

  sendNewMessage(conversation: Conversation, message: string) : Observable<PrivateMessage>{
    let body = {
      'conversation' : conversation,
      'message' : message
    };
    return this.httpSrv.postAndFetchData(AppUrls.SEND_MESSAGE_URL,body).map(resp => <any> resp);
  }

  createNewConversation(receiverId: number) : Observable<PrivateMessage>{
    let body = {
      'receiverId' : receiverId
    };
    return this.httpSrv.postAndFetchData(AppUrls.CREATE_CONVERSATION_URL,body).map(resp => <any> resp);
  }
}
