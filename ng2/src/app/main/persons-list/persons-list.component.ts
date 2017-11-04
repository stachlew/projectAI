import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-persons-list',
  templateUrl: './persons-list.component.html',
  styleUrls: ['./persons-list.component.css']
})
export class PersonsListComponent implements OnInit {

  myInput:string;
  myErrorStateMatcher:boolean;

  constructor() { }

  ngOnInit() {
  }

}
