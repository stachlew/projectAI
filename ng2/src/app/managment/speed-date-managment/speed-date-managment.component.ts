import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-speed-date-managment',
  templateUrl: './speed-date-managment.component.html',
  styleUrls: ['./speed-date-managment.component.css']
})
export class SpeedDateManagmentComponent implements OnInit {

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
