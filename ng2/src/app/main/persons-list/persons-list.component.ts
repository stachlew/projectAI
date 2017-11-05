import { Component, OnInit } from '@angular/core';
import {PageEvent} from "@angular/material";

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

  constructor() { }

  ngOnInit() {
  }

  length = 100;
  pageSize = 10;
  pageSizeOptions = [5, 10, 25, 100];

  pageEvent: PageEvent;

  setPageSizeOptions(setPageSizeOptionsInput: string) {
    this.pageSizeOptions = setPageSizeOptionsInput.split(',').map(str => +str);
  }

}
