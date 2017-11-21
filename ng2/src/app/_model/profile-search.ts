import {Region} from "./region";
import {City} from "./city";

export class ProfileSearch{
  region: Region;
  city: City;
  ageFrom: number;
  ageTo: number;
  pageNo: number;
  pageSize: number;

  constructor (){
    this.pageNo = 0;
    this.pageSize = 0;
  }
}
