import { Component } from '@angular/core';
import { AuthenticationService } from '../../_service/authentication/authentication.service';
import { Router } from '@angular/router';
import {ChatManagerService} from "../../main/chat/chat-manager.service";

@Component({
  selector: 'navigation-bar',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent {

  ngOnInit() {
  }

  constructor( public auth: AuthenticationService, public router: Router, public chatService: ChatManagerService) {
  }

  logout() {
    this.auth.doLogout();
    this.router.navigate(['login']);
  }

  isAuth() {
    if(this.auth.isLoggedIn()) {
      return true;
    }
  }

}
