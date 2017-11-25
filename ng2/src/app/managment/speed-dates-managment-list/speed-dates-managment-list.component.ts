import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {HttpSecService} from "../../_service/util/http-sec.service";
import {AppUrls} from "../../_service/util/app-urls";
import {SpeedDate} from "../../_model/speed-date";

@Component({
  selector: 'app-speed-dates-managment-list',
  templateUrl: './speed-dates-managment-list.component.html',
  styleUrls: ['./speed-dates-managment-list.component.css']
})
export class SpeedDatesManagmentListComponent implements OnInit {

  events: SpeedDate[] = [];

  constructor(public router: Router, private httpSrv: HttpSecService) { }

  // public countParticipants(participants: )

  ngOnInit() {
    this.getEventsData();
  }

  goToEventDetails(id: number){
    this.router.navigate(['speed-date-create/'+id]);
  }

  private getEventsData(){
    this.httpSrv.getAndFetchData(AppUrls.EVENTS_LIST_URL)
      .subscribe(resp=>{
        this.events = resp;
      });
  }

}
