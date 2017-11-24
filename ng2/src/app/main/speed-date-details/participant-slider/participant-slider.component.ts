import {Component, Input, OnInit} from '@angular/core';
import {AppUrls} from "../../../_service/util/app-urls";
import {Router} from "@angular/router";
import {User} from "../../../_model/user.model";

@Component({
  selector: 'app-participant-slider',
  templateUrl: './participant-slider.component.html',
  styleUrls: ['./participant-slider.component.css']
})
export class ParticipantSliderComponent implements OnInit {

  userPhotoUrl: string = AppUrls.USER_IMAGE_URL;

  constructor(private router: Router) { }

  @Input('participants') participants: User[];


  ngOnInit() {
  }

  goToPersonDetails(personId: number){
    this.router.navigate(['person-details/'+personId]);
  }

}
