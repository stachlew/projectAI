import {Region} from "./region";
import {City} from "./city";

export class ProfileRequest{
  region: Region;
  city: City;
  fromAge: number;
  toAge: number;
  distance: number;
  localWidth: string;
  localLenght: string;
}
