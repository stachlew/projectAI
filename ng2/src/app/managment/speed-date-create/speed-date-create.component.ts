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

@Component({
  selector: 'app-speed-date-create',
  templateUrl: './speed-date-create.component.html',
  styleUrls: ['./speed-date-create.component.css']
})
export class SpeedDateCreateComponent implements OnInit {

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

  constructor(private httpService: HttpSecService, private dictionary: DictionaryService ) {
    this.eventForm.localization = new Localization;
    this.eventForm.id = null;
  }

  ngOnInit() {
    this.inputDate = new Date();
    this.getRegions();
    this.refreshModalMap();
    this.prepareInitMap();
  }

  prepareInitMap(){
    this.eventForm.localization.geoLength = this.defaultLength.toFixed(5);
    this.eventForm.localization.geoWidth = this.defaultWidth.toFixed(5);
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
    this.eventForm.localization.geoWidth = marker.width.toFixed(5);
    this.eventForm.localization.geoLength = marker.length.toFixed(5);
  }

  saveEvent(){
    this.prepareBeforeSave();
    this.httpService.postAndFetchData(AppUrls.EVENTS_SAVE_URL,this.eventForm).subscribe(resp=>{
      console.log("saveddd");
    });
    console.log("save");
  }


  getRegions(){
    this.dictionary.getRegions().subscribe(resp=>{
      this.regions = resp;
    });
  }

  updateCities(event: any){
    this.activeRegion = event.value;
    this.activeCity = null;
    this.dictionary.getCities(this.activeRegion).subscribe(resp=>{
      this.cities = resp;
    });
  }




  public uploader:FileUploader = new FileUploader({url:this.httpService.applicationUrl + '/api/postFile',authToken:this.httpService.getToken()});


}
