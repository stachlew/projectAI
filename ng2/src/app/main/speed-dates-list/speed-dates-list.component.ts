import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {HttpSecService} from "../../_service/util/http-sec.service";
import {AppUrls} from "../../_service/util/app-urls";
import {SpeedDate} from "../../_model/speed-date";
import {SpeedDateSearch} from "../../_model/speed-date-search";
import {Constants} from "../../_service/util/constants";
import {City} from "../../_model/city";
import {Region} from "../../_model/region";
import {DictionaryService} from "../../_service/util/dictionary.service";

@Component({
  selector: 'app-speed-dates-list',
  templateUrl: './speed-dates-list.component.html',
  styleUrls: ['./speed-dates-list.component.css']
})
export class SpeedDatesListComponent implements OnInit {

  private filter: SpeedDateSearch = new SpeedDateSearch;
  private speedDates: SpeedDate[] = [];

  private regions: Region[] = [];
  private cities: City[] = [];

  constructor(private httpSrv: HttpSecService, private dictionary: DictionaryService) { }

  ngOnInit() {
    this.getRegions();
    this.initData();
  }

  getRegions(){
    this.dictionary.getRegions().subscribe(resp=>{
      this.regions = resp;
    });
  }

  updateCities(event: any){
    this.filter.region = event.value;
    this.filter.city=null;
    this.dictionary.getCities(this.filter.region).subscribe(resp=>{
      this.cities = resp;
    });
  }

  initData(){
    this.filter = new SpeedDateSearch;
    this.filter.pageNo = 1;
    this.filter.pageSize = Constants.SPEED_DATES_ELEMENTS;
    this.updateDates();
  }


  updateDates(){
    this.getData().subscribe(resp=>{
      this.speedDates = resp.value;
    });
  }

  getData() : Observable<any> {
    return this.httpSrv.postAndFetchData(AppUrls.GUEST_GET_ALL_EVENTS_URL,this.filter).map(resp=>{
      return <SpeedDate> resp;
    });
  }

  changePage(pageNo: number){
    this.filter.pageNo = pageNo;
    this.updateDates();
  }

}
