import { Component, OnInit } from '@angular/core';
import {Http} from "@angular/http";
import {HttpSecService} from "../../_service/util/http-sec.service";
import {AppUrls} from "../../_service/util/app-urls";
import {FileUploader} from "ng2-file-upload";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  public userId: number;
  public uploader:FileUploader;
  public userPhotoUrl: string = AppUrls.USER_IMAGE_URL;

  constructor(private http: Http, private httpService: HttpSecService) { }

  ngOnInit() {
    this.getMyId();
    this.uploader = new FileUploader(
      {
        url: AppUrls.UPLOAD_USER_IMAGE_URL,
        authToken: this.httpService.getToken(),
        queueLimit: 1
      });
  }

  getMyId(){
    this.httpService.getAndFetchData(AppUrls.UTILS_MY_ID_URL).subscribe(resp=>{
      this.userId = resp;
    });
  }

  deleteImage() {
    this.httpService.getAndFetchData(AppUrls.DELETE_USER_IMAGE_URL).subscribe(resp => {
      if (resp) {
        alert("Pomyślnie usunięto zdjęcie.");
      } else {
        alert("Nie udało się usunąć zdjęcia");
      }

    });
  }




}
