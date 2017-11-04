import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-person-details',
  templateUrl: './person-details.component.html',
  styleUrls: ['./person-details.component.css']
})
export class PersonDetailsComponent implements OnInit {

  constructor(private route: ActivatedRoute) { }

  personId: number;
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.initPersonDetails(params.personId);
    });
  }

  initPersonDetails(personId: number){
    this.personId = personId;
  }




}
