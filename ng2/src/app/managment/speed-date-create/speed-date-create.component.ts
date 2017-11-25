import {Component, OnInit, ViewChild} from '@angular/core';
import {FileUploader} from "ng2-file-upload";
import {HttpSecService} from "../../_service/util/http-sec.service";
import {City} from "../../_model/city";
import {Region} from "../../_model/region";
import {SpeedDate} from "../../_model/speed-date";
import {AppUrls} from "../../_service/util/app-urls";
import {DictionaryService} from "../../_service/util/dictionary.service";
import {Localization} from "../../_model/localization";
import {CustomMapComponent} from "../../_component/custom-map/custom-map.component";
import {Marker} from "../../_model/marker";
import {ActivatedRoute, Router} from "@angular/router";
import {isNullOrUndefined} from "util";

@Component({
  selector: 'app-speed-date-create',
  templateUrl: './speed-date-create.component.html',
  styleUrls: ['./speed-date-create.component.css']
})
export class SpeedDateCreateComponent implements OnInit {


  speedDateId: number;
  isSaved: boolean = false;

  eventForm: SpeedDate  = new SpeedDate();
  inputDate: Date;
  public regions: Region[] = [];
  public cities: City[] = [];
  public eventPhotoUrl: string = AppUrls.EVENT_IMAGE_URL;
  public activeRegion: Region = new Region();
  public activeCity: City = new City();
  public defaultWidth: number = 52.25279;
  public defaultLength: number = 20.86684;
  public mapZoom: number = 6;
  @ViewChild('customMap') customMap : CustomMapComponent;

  errorFields: any[] = [];



  constructor(private httpService: HttpSecService, private dictionary: DictionaryService, private route: ActivatedRoute, public router: Router) {
    this.eventForm.localization = new Localization;
    this.eventForm.id = null;
  }

  ngOnInit() {
    this.errorFields = [
      {      error: false,      errorText: ''    }, //tytul wydarzenia
      {      error: false,      errorText: ''    }, //opis wydarzenia
      {      error: false,      errorText: ''    }, //data
      {      error: false,      errorText: ''    }, //województwo
      {      error: false,      errorText: ''    }, //miasto
      {      error: false,      errorText: ''    }, //adres
      {      error: false,      errorText: ''    }, //liczba miejsc
    ];

    this.route.params.subscribe(params => {
      this.speedDateId = params.speeddateId;

      this.uploader = new FileUploader(
        {
          url: AppUrls.UPLOAD_EVENT_IMAGE_URL + this.speedDateId,
          authToken: this.httpService.getToken(),
          queueLimit: 1
        });
    });

    if(this.speedDateId>0){
      this.getExistingEvent();
    }
    else {
      this.initSpeedDateAfterLoad();
    }
  }

  initSpeedDateAfterLoad(){
    this.inputDate = new Date();
    this.getRegions();
    this.refreshModalMap();
    this.prepareInitMap();
  }

  prepareInitMap(){
    if(this.eventForm.id!=null){
      this.defaultLength = Number(this.eventForm.localization.geoLength);
      this.defaultWidth =  Number(this.eventForm.localization.geoWidth);
    }
    else{
      this.eventForm.localization = new Localization;
      this.eventForm.localization.geoLength = this.defaultLength.toFixed(10);
      this.eventForm.localization.geoWidth = this.defaultWidth.toFixed(10);
    }

    setTimeout(x=>{
      this.customMap.transformDatesIntoMarkers();
        this.refreshModalMap();
      }
    ,1000);
  }

  refreshModalMap(){
    setTimeout(x=>this.customMap.repaintMap(),700);
  }



  initAlreadySaved(){
    this.activeRegion = this.eventForm.localization.city.region;
    this.activeCity = this.eventForm.localization.city;
    this.inputDate = this.eventForm.eventStart;
  }

  prepareBeforeSave(){
    this.eventForm.eventStart = new Date(this.inputDate);
    let address: string = this.eventForm.localization.address;
    this.eventForm.localization = new Localization;
    this.eventForm.localization.address = address;
    this.eventForm.localization.city = this.activeCity;
    let marker: Marker = this.customMap.getMarkerLocalization();
    this.eventForm.localization.geoWidth = marker.width.toFixed(10);
    this.eventForm.localization.geoLength = marker.length.toFixed(10);
  }

  //WALIDACJA==============================

  validateAndSaveForm(){
    //ustawianie pol
    this.checkBadLenght(4,100,this.eventForm.title, this.errorFields[0]);
    this.checkBadLenght(4,1000,this.eventForm.description, this.errorFields[1]);
    this.checkNull(this.inputDate, this.errorFields[2]);
    this.checkNull(this.activeRegion.regionName, this.errorFields[3]);
    this.checkNull(this.activeCity, this.errorFields[4]);
    this.checkBadLenght(4,200,this.eventForm.localization.address, this.errorFields[5]);
    this.checkBadNumber(1,9999,this.eventForm.capacity, this.errorFields[6]);


    //valid tablicy
    if(!this.checkErrors()){
      this.prepareBeforeSave();
      this.saveEvent();
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

  checkBadNumber(min: number, max: number, value: number, errorArrayElement: any){
    if(isNullOrUndefined(value) || value<min || value>max) {
      errorArrayElement.error = true;
      errorArrayElement.errorText = 'Możliwy zakres: '+min+'-'+max+'!';
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

  //=======================================

  saveEvent(){
    this.httpService.postAndFetchData(AppUrls.EVENTS_SAVE_URL,this.eventForm).subscribe(resp=>{
      console.log("saveddd");
      this.isSaved = true;
    },error2 => {
      alert('Wystąpił błąd! Spróbuj ponownie poźniej!')
    });
    console.log("save");
  }


  getRegions(){
    this.dictionary.getRegions().subscribe(resp=>{
      this.regions = resp;

      if(this.eventForm.id>0){
        this.updateCities({value: this.activeRegion});
      }
    });
  }

  updateCities(event: any){
    this.activeRegion = event.value;
    this.activeCity = null;
    this.dictionary.getCities(this.activeRegion).subscribe(resp=>{
      this.cities = resp;

      if(this.eventForm.id>0){
        this.activeCity = this.eventForm.localization.city;
      }
    });
  }

  getExistingEvent(){
    this.httpService.getAndFetchData(AppUrls.EVENTS_DETAIL_URL + this.speedDateId).subscribe(resp=>{
      this.eventForm = resp;
      this.initSpeedDateAfterLoad();
      this.initAlreadySaved();
    });
  }

  public uploader:FileUploader;

  //defaultSelectValue
  compareSelected: ((f1: any, f2: any) => boolean) | null = this.compareByValue;
  compareByValue(f1: any, f2: any) {
    return f1 && f2 && f1.id === f2.id;
  }

  goToList(){
    this.router.navigate(['speed-dates-managment-list']);
  }

  deleteImage(){
    this.httpService.getAndFetchData(AppUrls.DELETE_EVENT_IMAGE_URL + this.speedDateId).subscribe(resp=>{
      if(resp){
        alert("Pomyślnie usunięto zdjęcie.");
      }else {
        alert("Nie udało się usunąć zdjęcia");
      }

    });

  }


}
