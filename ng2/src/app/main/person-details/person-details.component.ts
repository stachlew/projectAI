import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ChatManagerService} from "../chat/chat-manager.service";
import {User} from "../../_model/user.model";
import {HttpSecService} from "../../_service/util/http-sec.service";
import {AppUrls} from "../../_service/util/app-urls";

@Component({
  selector: 'app-person-details',
  templateUrl: './person-details.component.html',
  styleUrls: ['./person-details.component.css']
})
export class PersonDetailsComponent implements OnInit {

  constructor(private route: ActivatedRoute,private router: Router, private chatService: ChatManagerService, private httpSrv: HttpSecService) { }

  userPhotoUrl: string = AppUrls.USER_IMAGE_URL;

  personId: number;
  details: User = new User;
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.initPersonDetails(params.personId);
      this.initDetails();
    });
  }

  private initPersonDetails(personId: number){
    this.personId = personId;
  }

  private startConversation(){
    this.chatService.createNewConversation(this.personId).subscribe(resp=>{
      this.router.navigate(['chat']);
    });
  }

  public initDetails(){
    this.httpSrv.getAndFetchData(AppUrls.GET_USER_DETAIL_URL + this.personId).subscribe(resp=>{
      this.details = resp;
    });
  }



}
