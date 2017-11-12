import {Component, Input, OnInit} from '@angular/core';
import {ChatManagerService} from "./chat-manager.service";
import {Conversation} from "../../_model/conversation";

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  constructor(public chatService: ChatManagerService) { }

  ngOnInit() {
  }

}
