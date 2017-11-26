import {City} from "./city";
import {Match} from "./match";
import {SimpleDictionary} from "./simple-dictionary";

export class User {
  id: number;
  username: string;
  firstname: string;
  lastname: string;
  password: string;
  email: string;
  authorities: string[];
  enabled: boolean;
  age: number;
  profilePhotoId: number;
  birthDate: Date;
  userType: string;
  man: boolean;
  sex: string;
  city: City;

  accountCreateDate: Date;
  lastLogoutDate: Date;
  lastpassres: Date;

  height: number;
  smoking: string;
  drinking: string;
  kids: string;
  profession: string;
  description: string;

  zodiacSign: SimpleDictionary;
  martialStatus: SimpleDictionary;
  education: SimpleDictionary;
  figure: SimpleDictionary;
  hairColor: SimpleDictionary;
  eyeColor: SimpleDictionary;
  religion: SimpleDictionary;
  matchList: Match[];



}
