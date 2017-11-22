import {City} from "./city";

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
  isMan: boolean;
  sex: string;
  city: City;

}
