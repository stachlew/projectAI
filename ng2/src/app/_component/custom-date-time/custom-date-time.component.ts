import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {isNullOrUndefined} from "util";

@Component({
  selector: 'custom-date-time',
  templateUrl: './custom-date-time.component.html',
  styleUrls: ['./custom-date-time.component.css']
})
export class CustomDateTimeComponent implements OnInit {

  @Output() dateChange: EventEmitter<any> = new EventEmitter();

  _dateIn: Date;
  @Input('dateIn')
  set dateIn(value: Date){
    this._dateIn = value;
    this.convertDateIn();
  }

  get dateIn(){
    return this._dateIn;
  }

  mainDate: Date;
  hourHelp: number;
  minHelp: number;
  constructor() { }

  ngOnInit() {
    console.log('Date IN:' + this.dateIn);
  }

  convertDateIn(){
    if(!isNullOrUndefined(this.dateIn)){
      this.mainDate = new Date(this.dateIn);
      this.hourHelp = this.mainDate.getHours();
      this.minHelp = this.mainDate.getMinutes();
    }
  }

  handleInputHelpChanges(){
    if(!isNullOrUndefined(this.mainDate)){
      let newDate = new Date(this.mainDate);
      newDate.setHours(this.hourHelp);
      newDate.setMinutes(this.minHelp);
      this.mainDate = newDate;
    }
    this.sendNewDateTime();
  }

  sendNewDateTime(){
    this.dateChange.emit(this.mainDate);
  }

}
