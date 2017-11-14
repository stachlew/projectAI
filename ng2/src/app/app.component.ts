import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "./_service/authentication/authentication.service";
import {ChatManagerService} from "./main/chat/chat-manager.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  constructor(private auth: AuthenticationService, private chatManager: ChatManagerService){

  }

  ngOnInit(){
    if(this.auth.isLoggedIn()){
      this.chatManager.startChatService();
    }
  }
}
