import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {ChatManagerService} from "./chat-manager.service";
import {Conversation} from "../../_model/conversation";

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit, OnDestroy {

  constructor(public chatService: ChatManagerService) { }

  ngOnInit() {
    this.chatService.setChatComponentInited(true);
    this.chatService.unsetNewMessageFlag();
    this.chatService.startMessagesRefreshing();
  }

  ngOnDestroy(){
    this.chatService.setChatComponentInited(false);
    this.chatService.stopMessagesRefreshing();
    this.chatService.rememberOldMessagesState();
  }

}
