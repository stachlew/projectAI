import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {HttpSecService} from "../../_service/util/http-sec.service";
import {AppUrls} from "../../_service/util/app-urls";
import {AuthenticationService} from "../../_service/authentication/authentication.service";
import {Constants} from "../../_service/util/constants";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  usersCount: number;

  constructor(public router: Router, private httpSrv: HttpSecService, public auth: AuthenticationService) {

  }

  ngOnInit() {
    this.getUserCount();
  }

  goToRegister(){
    this.router.navigate(['register']);
  }

  goPersonsList(){
    this.router.navigate(['persons-list']);
  }

  goToTest(){
    this.router.navigate(['match-form-page']);
  }

  goEventCreate(){
    this.router.navigate(['speed-date-create']);
  }

  getUserCount(){
    this.httpSrv.getAndFetchData(AppUrls.UTILS_USER_COUNT_URL).subscribe(resp=>{
      this.usersCount = resp;
    });
  }

  isUser(){
    if(this.auth.isLoggedIn() && this.auth.userRole === Constants.USER_TYPE) {
      return true;
    }
  }

  isManager(){
    if(this.auth.isLoggedIn() && this.auth.userRole === Constants.MANAGER_TYPE) {
      return true;
    }
  }

  isAuth() {
    if(this.auth.isLoggedIn()) {
      return true;
    }
  }
}
