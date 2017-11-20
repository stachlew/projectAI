import {Component, Input, OnInit} from '@angular/core';
import {Participant} from "../../../_model/participant";
import {AppUrls} from "../../../_service/util/app-urls";
import {Router} from "@angular/router";

@Component({
  selector: 'app-participant-slider',
  templateUrl: './participant-slider.component.html',
  styleUrls: ['./participant-slider.component.css']
})
export class ParticipantSliderComponent implements OnInit {

  userPhotoUrl: string = AppUrls.USER_IMAGE_URL;

  constructor(private router: Router) { }

  @Input('participants') participants: Participant[];


  ngOnInit() {
    console.log("ParticipantSliderComponent ngOnInit");
  }

  public addTest(){
    console.log("ParticipantSliderComponent addTest");
    this.participants.push(this.participants[0]);
  }

  goToPersonDetails(personId: number){
    this.router.navigate(['person-details/'+personId]);
  }

}
