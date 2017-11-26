import {Component, OnInit, ViewChild} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {HttpSecService} from "../../_service/util/http-sec.service";
import {AppUrls} from "../../_service/util/app-urls";
import {SpeedDate} from "../../_model/speed-date";
import {SpeedDateSearch} from "../../_model/speed-date-search";
import {Constants} from "../../_service/util/constants";
import {City} from "../../_model/city";
import {Region} from "../../_model/region";
import {DictionaryService} from "../../_service/util/dictionary.service";
import {Router} from "@angular/router";
import {PageResponse} from "../../_model/page-response";
import {CustomPaginatorComponent} from "../../_component/custom-paginator/custom-paginator.component";

@Component({
  selector: 'app-speed-dates-list',
  templateUrl: './speed-dates-list.component.html',
  styleUrls: ['./speed-dates-list.component.css']
})
export class SpeedDatesListComponent implements OnInit {

  private filter: SpeedDateSearch = new SpeedDateSearch;
  private response: PageResponse = new PageResponse();
  private speedDates: SpeedDate[] = [];

  private regions: Region[] = [];
  private cities: City[] = [];

  eventPhotoUrl: string = AppUrls.EVENT_IMAGE_URL;

  @ViewChild(CustomPaginatorComponent)
  private paginator: CustomPaginatorComponent;

  constructor(private httpSrv: HttpSecService, private dictionary: DictionaryService, private router: Router) { }

  ngOnInit() {
    this.getRegions();
    this.response = new PageResponse();
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

  resetToFirstPage(){
    if(this.filter.dateTo!=null){
      this.filter.dateTo.setHours(23);
      this.filter.dateTo.setMinutes(59);
    }
    this.filter.pageNo = 1;
    this.updateDates();
  }

  public clearFilters(){
    this.filter = new SpeedDateSearch;
    this.filter.pageNo = 1;
    this.filter.pageSize = Constants.SPEED_DATES_ELEMENTS;
    this.resetToFirstPage();
  }

  updateDates(){
    this.getData().subscribe(resp=>{
      this.response = resp;
      this.speedDates = resp.value;
      setTimeout(fun=>{this.paginator.updatePaginator();});
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

  goToEventDetails(event: any, id: number){
    this.router.navigate(['speed-date-details/'+id]);
  }

}
