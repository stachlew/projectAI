import {Injectable, OnInit} from "@angular/core";
import {Region} from "../../_model/region";
import {City} from "../../_model/city";
import {HttpSecService} from "./http-sec.service";
import {AppUrls} from "./app-urls";
import {Observable} from "rxjs/Observable";

@Injectable()
export class DictionaryService implements OnInit {

  constructor(private httpServ: HttpSecService) {
  }

  ngOnInit(){

  }

  getRegions(): Observable<Region[]> {
    return this.httpServ.getAndFetchData(AppUrls.GET_REGIONS_URL).map(resp=>
      {
        return <Region[]> resp;
      }
    )
  }

  getCities(region: Region): Observable<City[]> {
    return this.httpServ.postAndFetchData(AppUrls.GET_CITIES_URL,region).map(resp=>
      {
        return <City[]> resp;
      }
    )
  }

}

