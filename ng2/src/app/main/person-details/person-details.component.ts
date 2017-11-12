import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ChatManagerService} from "../chat/chat-manager.service";

@Component({
  selector: 'app-person-details',
  templateUrl: './person-details.component.html',
  styleUrls: ['./person-details.component.css']
})
export class PersonDetailsComponent implements OnInit {

  constructor(private route: ActivatedRoute,private router: Router, private chatService: ChatManagerService) { }

  personId: number;
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.initPersonDetails(params.personId);
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




}
