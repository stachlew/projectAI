import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-speed-date-details',
  templateUrl: './speed-date-details.component.html',
  styleUrls: ['./speed-date-details.component.css']
})
export class SpeedDateDetailsComponent implements OnInit {

  speedDateId: number;

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
    this.initDetails(params.speeddateId);
  });
  }

  initDetails(speedDateId: number){
    this.speedDateId = speedDateId;
  }

}
