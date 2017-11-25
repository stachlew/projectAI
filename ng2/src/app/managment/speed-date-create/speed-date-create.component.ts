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

  constructor(private httpService: HttpSecService, private dictionary: DictionaryService, private route: ActivatedRoute, public router: Router) {
    this.eventForm.localization = new Localization;
    this.eventForm.id = null;
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.speedDateId = params.speeddateId;
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
    this.eventForm.localization = new Localization;
    this.eventForm.localization.city = this.activeCity;
    let marker: Marker = this.customMap.getMarkerLocalization();
    this.eventForm.localization.geoWidth = marker.width.toFixed(10);
    this.eventForm.localization.geoLength = marker.length.toFixed(10);
  }

  saveEvent(){
    this.prepareBeforeSave();
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

  public uploader:FileUploader = new FileUploader(
    {
      url: this.httpService.applicationUrl + '/api/postFile',
      authToken: this.httpService.getToken(),
      queueLimit: 1
    });

  //defaultSelectValue
  compareSelected: ((f1: any, f2: any) => boolean) | null = this.compareByValue;
  compareByValue(f1: any, f2: any) {
    return f1 && f2 && f1.id === f2.id;
  }

  goToList(){
    this.router.navigate(['speed-dates-managment-list']);
  }


}
