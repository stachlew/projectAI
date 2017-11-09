import { Component, OnInit } from '@angular/core';
import {Conversation} from "../../../_model/conversation";
import {ChatManagerService} from "../chat-manager.service";

@Component({
  selector: 'app-chat-contacts',
  templateUrl: './chat-contacts.component.html',
  styleUrls: ['./chat-contacts.component.css']
})
export class ChatContactsComponent implements OnInit {

  constructor(private chatService: ChatManagerService) { }

  ngOnInit() {
    this.getAllContacts();
  }

  private contacts: Conversation[] = [];

  getAllContacts(){
    this.chatService.getAllConversations().subscribe(resp=>{
      this.contacts = resp;
    });
  }

}
