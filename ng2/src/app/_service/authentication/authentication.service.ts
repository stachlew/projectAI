import { Injectable } from '@angular/core';
import { tokenNotExpired, AuthHttp } from 'angular2-jwt';
import 'rxjs/add/operator/map';
import { User } from '../../_model/user.model';
import { Constants } from "../util/constants";
import {UtilsService} from "../util/utils.service";
import {isNullOrUndefined} from "util";
import {AppUrls} from "../util/app-urls";

@Injectable()
export class AuthenticationService {
  public token: string;
  public username: string;
  public userRole: string;

  constructor(public http: AuthHttp, public util: UtilsService) {
    if(this.isLoggedIn()){
      this.token=localStorage.getItem('token');
      this.username=localStorage.getItem('username');
      this.userRole=localStorage.getItem('userRole');
    }
  }

  doLogin(credentials) {
    return this.http.post(AppUrls.APP_HOST+'/auth', credentials)
      .map(res => {
        const data = res.json();
        if (data) {
          localStorage.setItem('token', data.token);
          localStorage.setItem('user', JSON.stringify(data.user));
          localStorage.setItem('username', data.user.username);
          this.token=data.token;
          this.username=data.user.username;
          this.userRole=null;
          if(!isNullOrUndefined(data.user.authorities) && data.user.authorities.length>0){
            this.userRole = data.user.authorities[0].authority;
            localStorage.setItem('userRole', this.userRole);
          }
        }
      });
  }

  doLogout() {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    localStorage.removeItem('username');
    localStorage.removeItem('userRole');
    this.username=null;
    this.userRole=null;
    this.token=null;
  }

  isLoggedIn() {
    return tokenNotExpired('token');
  }

  getRoles() {
    const user: User = JSON.parse(localStorage.getItem('user'));
    return user.authorities;
  }


  isUser(): boolean{
    return (this.userRole === Constants.ROLE_USER);
  }

  isManager(): boolean{
      return (this.userRole === Constants.ROLE_MANAGER);
  }

}
