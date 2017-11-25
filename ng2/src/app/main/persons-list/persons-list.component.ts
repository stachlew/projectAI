import {Component, OnInit, ViewChild} from '@angular/core';
import {PageEvent} from "@angular/material";
import {Router} from "@angular/router";
import {PersonListService} from "./person-list.service";
import {AppUrls} from "../../_service/util/app-urls";
import {DictionaryService} from "../../_service/util/dictionary.service";
import {ProfileSearch} from "../../_model/profile-search";
import {Region} from "../../_model/region";
import {City} from "../../_model/city";
import {PageResponse} from "../../_model/page-response";
import {Constants} from "../../_service/util/constants";
import {SpeedDateSearch} from "../../_model/speed-date-search";
import {SpeedDate} from "../../_model/speed-date";
import {Observable} from "rxjs/Observable";
import {HttpSecService} from "../../_service/util/http-sec.service";
import {CustomPaginatorComponent} from "../../_component/custom-paginator/custom-paginator.component";

@Component({
  selector: 'app-persons-list',
  templateUrl: './persons-list.component.html',
  styleUrls: ['./persons-list.component.css']
})
export class PersonsListComponent implements OnInit {

  public userPhotoUrl: string = AppUrls.USER_IMAGE_URL;
  public filter: ProfileSearch = new ProfileSearch;

  public regions: Region[] = [];
  public cities: City[] = [];

  public response: PageResponse;
  public persons: any = [];

  @ViewChild(CustomPaginatorComponent)
  private paginator: CustomPaginatorComponent;

  constructor(public router: Router, public personsService: PersonListService, private dictionary: DictionaryService, private httpSrv: HttpSecService) { }

  ngOnInit() {
    this.getRegions();
    this.response = new PageResponse;
    this.initData();
  }

  initData(){
    this.filter = new ProfileSearch;
    this.filter.pageNo = 1;
    this.filter.pageSize = Constants.PERSONS_ELEMENTS;
    this.getProfilesData();
  }

  getProfilesData(){
    this.getData().subscribe(resp=>{
      this.response = resp;
      this.persons = resp.value;
      setTimeout(fun=>{this.paginator.updatePaginator();});
    });
  }

  getData() : Observable<any> {
    return this.httpSrv.postAndFetchData(AppUrls.PERSONS_GET_PROFILES_LIST,this.filter).map(resp=>{
      return <SpeedDate> resp;
    });
  }

  resetToFirst(){
    this.filter.pageNo=1;
    this.changePage(this.filter.pageNo);
  }

  clearSearch(){
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

  goToPersonDetails(id: number){
    this.router.navigate(['person-details/'+id]);
  }

  changePage(pageNo: number){
    this.filter.pageNo = pageNo;
    this.getProfilesData();
  }




  ///ACTIONY

  action1(){
    return this.httpSrv.getAndFetchData(AppUrls.APP_HOST+'/api/action1').subscribe(resp=>{
        let data = resp;
        console.log('ODPOWIEDZ ACTION 1: '+data);
      },
      err=>{
        console.log('FAILED ACTION 1');
      });
  }

  action2(){
    return this.httpSrv.getAndFetchData(AppUrls.APP_HOST+'/api/action2').subscribe(resp=>{
        let data = resp;
        console.log('ODPOWIEDZ ACTION 2: '+data);
      },
      err=>{
        console.log('FAILED ACTION 2');
      });
  }

  action3(){
    return this.httpSrv.getAndFetchData(AppUrls.APP_HOST+'/api/action3').subscribe(resp=>{
        let data = resp;
        console.log('ODPOWIEDZ ACTION 3: '+data);
      },
      err=>{
        console.log('FAILED ACTION 3');
      });
  }

}
