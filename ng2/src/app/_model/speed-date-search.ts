import {City} from "./city";
import {Region} from "./region";

export class SpeedDateSearch{
  region: Region;
  city: City;
  dateFrom: Date;
  dateTo: Date;
  pageNo: number;
  pageSize: number;
}
