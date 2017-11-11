import {Component, Input, OnInit} from '@angular/core';
import {Conversation} from "../../../_model/conversation";
import {ChatManagerService} from "../chat-manager.service";

@Component({
  selector: 'app-chat-contacts',
  templateUrl: './chat-contacts.component.html',
  styleUrls: ['./chat-contacts.component.css']
})
export class ChatContactsComponent implements OnInit{

  @Input('conversationList') contacts: Conversation[] = [];


  constructor(private chatService: ChatManagerService) {
  }

  ngOnInit(){
    this.chatService.updateData();
  }

  changeConversation(conversation: Conversation){
    this.chatService.changeConversation(conversation);
  }
}
