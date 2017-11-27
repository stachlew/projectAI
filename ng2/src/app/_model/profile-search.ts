import {Region} from "./region";
import {City} from "./city";
import {SimpleDictionary} from "./simple-dictionary";

export class ProfileSearch{
  region: Region;
  city: City;
  ageFrom: number;
  ageTo: number;
  sex: string;

  education: SimpleDictionary;
  smoking: SimpleDictionary;
  drinking: SimpleDictionary;
  kids: SimpleDictionary;
  zodiacSign: SimpleDictionary;
  martialStatus: SimpleDictionary;
  figure: SimpleDictionary;
  hairColor: SimpleDictionary;
  eyeColor: SimpleDictionary;
  religion: SimpleDictionary;

  pageNo: number;
  pageSize: number;
  countElements: number;
  countPage: number;

  constructor (){
    this.pageNo = 0;
    this.pageSize = 0;
  }
}
