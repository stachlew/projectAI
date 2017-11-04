import { Injectable } from '@angular/core';
import { isNullOrUndefined } from 'util';

@Injectable()
export class UtilsService {

  constructor() { }

  public contains(array: any[], obj: any): boolean{
    if(isNullOrUndefined(array) || array.length<=0 || isNullOrUndefined(obj)){
      return false;
    }
    else {
      let exist = false;
      array.forEach(el=>{
        if (el === obj) {
          exist = true;
          return;
        }
      });
      return exist;
    }


  }
}
