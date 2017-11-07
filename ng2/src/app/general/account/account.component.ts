import { Component, OnInit } from '@angular/core';
import {Http} from "@angular/http";
import {HttpSecService} from "../../_service/util/http-sec.service";
import {AppUrls} from "../../_service/util/app-urls";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  constructor(private http: Http, private httpService: HttpSecService) { }

  ngOnInit() {
  }

  action1(){
    return this.http.get(AppUrls.APP_HOST+'/api/action1',this.httpService.getConfig()).subscribe(resp=>{
        let data = resp;
        console.log('ODPOWIEDZ ACTION 1: '+data);
      },
      err=>{
        console.log('FAILED ACTION 1');
      });
  }

  action2(){
    return this.http.get(AppUrls.APP_HOST+'/api/action2',this.httpService.getConfig()).subscribe(resp=>{
        let data = resp;
        console.log('ODPOWIEDZ ACTION 2: '+data);
      },
      err=>{
        console.log('FAILED ACTION 2');
      });
  }

  action3(){
    return this.http.get(AppUrls.APP_HOST+'/api/action3',this.httpService.getConfig()).subscribe(resp=>{
        let data = resp;
        console.log('ODPOWIEDZ ACTION 3: '+data);
      },
      err=>{
        console.log('FAILED ACTION 3');
      });
  }
}
