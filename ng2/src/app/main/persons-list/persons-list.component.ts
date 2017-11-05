import { Component, OnInit } from '@angular/core';
import {PageEvent} from "@angular/material";
import {Router} from "@angular/router";
import {PersonListService} from "./person-list.service";

@Component({
  selector: 'app-persons-list',
  templateUrl: './persons-list.component.html',
  styleUrls: ['./persons-list.component.css']
})
export class PersonsListComponent implements OnInit {



  public regions: any = [
    {id: 1, name: 'Mazowieckie'},
    {id: 2, name: 'Pomorskie'},
    {id: 3, name: 'Małopolskie'},
    {id: 4, name: 'Opolskie'}
  ];

  public cities: any = [
    {id: 1, name: 'Warszawa'},
    {id: 2, name: 'Kraków'},
    {id: 3, name: 'Gdańsk'},
    {id: 4, name: 'Opole'}
  ];


  public persons: any = [];

  constructor(public router: Router, public personsService: PersonListService) { }

  ngOnInit() {
    this.persons = this.personsService.getPersons(1, 10);
  }

  goToPersonDetails(id: number){
    this.router.navigate(['person-details/'+id]);
  }

  private currentPageNo: number = 1;
  private pageSize: number = 10;
  private allElements: number = 25;

  changePage(pageNo: number){
    this.persons = this.personsService.getPersons(pageNo, this.pageSize);
  }

}
