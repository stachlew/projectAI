import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-speed-dates-managment-list',
  templateUrl: './speed-dates-managment-list.component.html',
  styleUrls: ['./speed-dates-managment-list.component.css']
})
export class SpeedDatesManagmentListComponent implements OnInit {

  events: any[] = [
    {
      id: 1,
      title: 'Zakochajmy Polskie - wydarzenie dla singlów',
      eventDate: new Date,
      createDate: new Date,
      visible: true,
      guests: 12,
      capacity: 36
    },
    {
      id: 1,
      title: 'Zakochajmy Niemców - wydarzenie dla singlów',
      eventDate: new Date,
      createDate: new Date,
      visible: true,
      guests: 33,
      capacity: 52
    },
    {
      id: 1,
      title: 'Zakochajmy Turkmeńczyków - wydarzenie dla singlów',
      eventDate: new Date,
      createDate: new Date,
      visible: true,
      guests: 10,
      capacity: 20
    },
    {
      id: 1,
      title: 'Zakochajmy zakochanych - wydarzenie dla zakochanych',
      eventDate: new Date,
      createDate: new Date,
      visible: true,
      guests: 22,
      capacity: 34
    }
  ];




  constructor(public router: Router) { }

  ngOnInit() {
  }

  goToEventDetails(id: number){
    this.router.navigate(['speed-date-managment/'+id]);
  }

}
