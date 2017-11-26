import { Component, OnInit } from '@angular/core';
import {User} from "../../_model/user.model";
import {Region} from "../../_model/region";
import {City} from "../../_model/city";
import {Localization} from "../../_model/localization";
import {DictionaryService} from "../../_service/util/dictionary.service";
import {isNullOrUndefined} from "util";
import {Router} from "@angular/router";
import {HttpSecService} from "../../_service/util/http-sec.service";
import {AppUrls} from "../../_service/util/app-urls";
import {Constants} from "../../_service/util/constants";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  manSlug: string = Constants.SEX_MAN;
  womanSlug: string = Constants.SEX_WOMAN;
  userSlug: string = Constants.USER_TYPE;
  managerSlug: string = Constants.MANAGER_TYPE;

  minBirthDate: Date;
  defaultDate: Date;

  registerButtonBlock: boolean = false;
  registrationComplete: boolean = false;
  errorResponse: string = '';

  errorFields: any[] = [];
  constructor(private dictionary: DictionaryService, private router: Router, private httpSrv: HttpSecService) {
  }

  ngOnInit() {
    this.userForm.userType = Constants.ROLE_USER;
    this.errorFields = [
      {      error: false,      errorText: ''    }, //login
      {      error: false,      errorText: ''    }, //haslo
      {      error: false,      errorText: ''    }, //e-mail
      {      error: false,      errorText: ''    }, //typ konta
      {      error: false,      errorText: ''    }, //imie
      {      error: false,      errorText: ''    }, //nazwisko
      {      error: false,      errorText: ''    }, //data uro
      {      error: false,      errorText: ''    }, //plec
      {      error: false,      errorText: ''    }, //wojewodztwo
      {      error: false,      errorText: ''    } //miasto
    ];
    this.getRegions();
    this.getMinBirthDate();
  }

  hide = true;
  userForm: User = new User();

  localization = new Localization();
  regionActive: Region;
  cityActive: City;

  regions: Region[] = [];
  cities: City[] = [];



  modifyFormFieldsBeforePost(){
    this.userForm.city = this.cityActive;
    this.userForm.man = ( this.userForm.sex === Constants.SEX_MAN ? true : false);


  }

  getRegions(){
    this.dictionary.getRegions().subscribe(resp=>{
      this.regions = resp;
    });
  }

  updateCities(event: any){
    this.regionActive = event.value;
    this.cityActive = null;
    this.dictionary.getCities( this.regionActive).subscribe(resp=>{
      this.cities = resp;
    });
  }

  validateAndSaveForm(){
    //ustawianie pol
    this.checkBadLenght(2,50,this.userForm.username, this.errorFields[0]);
    this.checkBadLenght(2,50,this.userForm.password, this.errorFields[1]);
    this.checkBadLenght(2,50,this.userForm.email, this.errorFields[2]);
    this.checkNull(this.userForm.userType, this.errorFields[3]);
    this.checkBadLenght(2,50,this.userForm.firstname, this.errorFields[4]);
    this.checkBadLenght(2,50,this.userForm.lastname, this.errorFields[5]);
    this.checkNull(this.userForm.birthDate, this.errorFields[6]);
    this.checkNull(this.userForm.sex, this.errorFields[7]);
    if(this.userForm.userType === this.userSlug){
      this.checkNull(this.regionActive, this.errorFields[8]);
      this.checkNull(this.cityActive, this.errorFields[9]);
    }else {
      this.errorFields[8].error=false;
      this.errorFields[8].errorText = '';
      this.errorFields[9].error=false;
      this.errorFields[9].errorText = '';
    }

    //valid tablicy
    if(!this.checkErrors()){
      this.modifyFormFieldsBeforePost();
      this.saveUser();
    }
  }

  checkBadLenght(min: number, max: number, value: string, errorArrayElement: any) {
    if(isNullOrUndefined(value) || value.trim().length<min || value.trim().length>max){
      errorArrayElement.error = true;
      errorArrayElement.errorText = 'Ilość znaków: '+min+'-'+max+'!';
    }else {
      errorArrayElement.error = false;
      errorArrayElement.errorText = '';
    }
  }

  checkNull(value: any, errorArrayElement: any) {
    if(isNullOrUndefined(value)){
      errorArrayElement.error = true;
      errorArrayElement.errorText = 'Pole obowiązkowe!';
    }else {
      errorArrayElement.error = false;
      errorArrayElement.errorText = '';
    }
  }

  checkErrors() : boolean{
    let hasErrors: boolean = false;
    this.errorFields.forEach(formField =>{
      if(formField.error){
        hasErrors = true;
      }
    });
    return hasErrors;
  }

  saveUser(){
    this.registerButtonBlock = true;
    this.httpSrv.postAndFetchData(AppUrls.REGISTER_ACCOUNT_URL,this.userForm).subscribe(resp=>{
      if(resp.status == 200){
        this.registrationComplete = true;
      }else {
        this.errorResponse = resp.error;
      }
      this.registerButtonBlock = false;
    });
    console.log("save user");
  }

  goToLogin(){
    this.router.navigate(['login']);
  }

  getMinBirthDate(){
    let border18 : Date = new Date();
    border18.setFullYear(border18.getFullYear() - 18);

    let default25: Date = new Date();
    default25.setFullYear(default25.getFullYear() - 25);
    default25.setMonth(0);
    default25.setDate(0);

    this.userForm.birthDate = null;
    this.defaultDate = default25;
    this.minBirthDate = border18;
  }

}
