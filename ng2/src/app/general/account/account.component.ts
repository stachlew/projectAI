import { Component, OnInit } from '@angular/core';
import {Http} from "@angular/http";
import {HttpSecService} from "../../_service/util/http-sec.service";
import {AppUrls} from "../../_service/util/app-urls";
import {FileUploader} from "ng2-file-upload";
import {User} from "../../_model/user.model";
import {isNullOrUndefined} from "util";
import {PasswordChangeRequest} from "../../_model/password-change-request";
import {AuthenticationService} from "../../_service/authentication/authentication.service";
import {Region} from "../../_model/region";
import {City} from "../../_model/city";
import {DictionaryService} from "../../_service/util/dictionary.service";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  public myProfile: User;
  public uploader:FileUploader;
  public userPhotoUrl: string = AppUrls.USER_IMAGE_URL;

  constructor(private httpService: HttpSecService, public authSrv: AuthenticationService, public dictionary: DictionaryService) { }

  ngOnInit() {
    this.getMyProfile();
  }

  getMyProfile(){
    this.httpService.getAndFetchData(AppUrls.GET_ACCOUNT_INFO_URL).subscribe(resp=>{
      this.myProfile = resp;

      this.uploader = new FileUploader(
        {
          url: AppUrls.UPLOAD_USER_IMAGE_URL,
          authToken: this.httpService.getToken(),
          queueLimit: 1
        });

      this.getRegions();
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

  //HASLO ===============================================
  public oldPass: string;
  public newPass:string;
  public hideNew = true;
  public hideOld = true;

  validateAndChangePassword(){
    if(!isNullOrUndefined(this.oldPass) && !isNullOrUndefined(this.newPass)){
      if(this.checkBadLength(4,50,this.oldPass) && this.checkBadLength(4,50,this.newPass)){
        this.saveNewPassword();
      } else {
        alert("Hasła powinny mieć długość od 4 do 50 znaków!");
      }
    }else {
      alert("Hasło stare oraz hasło nowe jest obowiązkowe!");
    }
  }

  checkBadLength(min: number, max: number, value: string) : boolean {
    if(isNullOrUndefined(value) || value.trim().length<min || value.trim().length>max){
      return false;
    }else {
      return true;
    }
  }

  saveNewPassword(){
    let body: PasswordChangeRequest = new PasswordChangeRequest;
    body.newPass = this.newPass;
    body.oldPass = this.oldPass;
    this.httpService.postAndFetchData(AppUrls.CHANGE_PASSWORD_URL, body).subscribe(resp=>{
      if(resp){
        this.newPass = null;
        this.oldPass = null;
        alert("Pomyślnie zmieniono hasło");
      }else {
        alert("Zmiana hasła nieudana. Zweryfikuj poprawność haseł!");
      }
    });
  }
  //END HASLO ===============================================


  //LOKALIZACJA
  public regions: Region[] = [];
  public cities: City[] = [];
  public activeRegion: Region = new Region();
  public activeCity: City = new City();

  getRegions(){
    this.dictionary.getRegions().subscribe(resp=>{
      this.regions = resp;


      if(this.myProfile.id>0 && this.myProfile.city!= null && this.myProfile.city.region != null){
        this.activeRegion = this.myProfile.city.region;
        this.updateCities({value: this.activeRegion});
      }
    });
  }

  updateCities(event: any){
    this.activeRegion = event.value;
    this.activeCity = null;
    this.dictionary.getCities(this.activeRegion).subscribe(resp=>{
      this.cities = resp;

      if(this.myProfile.id>0){
        this.activeCity = this.myProfile.city;
      }
    });
  }

  compareSelected: ((f1: any, f2: any) => boolean) | null = this.compareByValue;
  compareByValue(f1: any, f2: any) {
    return f1 && f2 && f1.id === f2.id;
  }

  validateAncChangeLocalization(){
    if(isNullOrUndefined(this.activeRegion) || isNullOrUndefined(this.activeCity)){
      alert("Aby zapisać zmiany należy wybrać województwo oraz miasto!");
    }else {
      let body = new User();
      body.city = this.activeCity;

      this.httpService.postAndFetchData(AppUrls.CHANGE_LOCALIZATION_URL,body).subscribe(resp=>{
        if(resp){
          alert("Pomyślnie zapisano zmiany!");
        }else {
          alert("Nie udało się zapisać zmian. Spróbuj ponownie później.");
        }
      });
    }
  }

  //END LOKALIZACJA



}
