import {Component, Input, OnInit} from '@angular/core';
import {ChatManagerService} from "../chat-manager.service";
import {Conversation} from "../../../_model/conversation";

@Component({
  selector: 'app-chat-message',
  templateUrl: './chat-message.component.html',
  styleUrls: ['./chat-message.component.css']
})
export class ChatMessageComponent implements OnInit {

  private textMessage: string;
  private isEnterSending: boolean = true;

  constructor(private chatService: ChatManagerService) { }

  ngOnInit() {
  }

  sendNewMessage(){
    if(this.textMessage!=null && this.textMessage.trim().length>0){
      this.chatService.sendMessage(this.textMessage);
      this.textMessage = null;
    }
  }

  checkEnter(){
    if(this.isEnterSending){
      this.sendNewMessage();
    }
  }

}
