import { Component, OnInit } from '@angular/core';
import {FileUploader} from "ng2-file-upload";
import {HttpSecService} from "../../_service/util/http-sec.service";

@Component({
  selector: 'app-speed-date-create',
  templateUrl: './speed-date-create.component.html',
  styleUrls: ['./speed-date-create.component.css']
})
export class SpeedDateCreateComponent implements OnInit {


  inputDate: Date;

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

  constructor(private httpService: HttpSecService) { }

  ngOnInit() {
    this.inputDate = new Date();
  }

  //wystarczy tyle by uploadowac plik. Nalezy odpowiednio przystroic formularz tak jak to jest na przykladzie
  public uploader:FileUploader = new FileUploader({url:this.httpService.applicationUrl + '/api/postFile',authToken:this.httpService.getToken()});


}
