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

  constructor(private chatService: ChatManagerService) { }

  ngOnInit() {
  }

  private testMsg: number = 0;

  sendNewMessage(){
    this.chatService.sendMessage('TEST: '+this.testMsg++ +' '+ this.textMessage);
  }

}
