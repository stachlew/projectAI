import {AfterViewInit, Component, Input, OnInit, ViewChild} from '@angular/core';
import {Marker} from "../../_model/marker";
import {AgmMap} from "@agm/core";
import {SpeedDate} from "../../_model/speed-date";
import {isNullOrUndefined} from "util";

@Component({
  selector: 'app-custom-map',
  templateUrl: './custom-map.component.html',
  styleUrls: ['./custom-map.component.css']
})
export class CustomMapComponent implements OnInit {

  constructor() { }

  ngOnInit() {

  }

  private isNotEmpty(array: any[]): boolean {
    if(!isNullOrUndefined(array) && array.length > 0)
      return true;
    else
      return false;
  }

  public transformDatesIntoMarkers(){
    if(this.detailView && this.isNotEmpty(this.speedDates) && !isNullOrUndefined(this.speedDates[0].localization)){
      this.defaultWidth = Number(this.speedDates[0].localization.geoWidth);
      this.defaultLength = Number(this.speedDates[0].localization.geoLength);
      this.markers = [
        {
          width: Number(this.speedDates[0].localization.geoWidth),
          length: Number(this.speedDates[0].localization.geoLength),
          widthString:  Number(this.speedDates[0].localization.geoWidth).toFixed(10),
          lengthString:  Number(this.speedDates[0].localization.geoLength).toFixed(10),
          label: this.speedDates[0].title,
          draggable: false,
          speedDate: this.speedDates[0]
        }
      ]
    }else if (this.searchView){

    }
    else if(this.createView){

    }
    else{
      alert("CustomMapComponent: wybrany przypadek trybu wyświetlania markerów mapy nie obsługiwany!");
    }
  }

  public markers: Marker[] = [];



  @Input('speedDates') speedDates: SpeedDate[] = [];
  @Input('defaultWidth') defaultWidth: number = 52.25353;
  @Input('defaultLength') defaultLength: number = 20.90067;

  @Input('detailView') detailView: boolean = false;
  @Input('searchView') searchView: boolean = false;
  @Input('createView') createView: boolean = false;

  //readOnly + myPosition = wyszukiwanie
  //readOnly + !myPosition = podgląd 1 wydarzenia
  //!readOnly = dodawanie 1 markera

  @ViewChild('agmMap') agmMap : AgmMap;
  zoom: number = 12;

  private kilometersRange:number = 126;
  private degreeRange:number = 0.0089827083*126;
  private fromGeoLengthNum:number;
  private toGeoLengthNum:number;
  private fromGeoWidthNum:number;
  private toGeoWidthNum:number;
  private kmToDeg:number=0.0139827083;

  public changeRange(value: number){
    this.kilometersRange=value;
    this.degreeRange=this.kilometersRange*this.kmToDeg;
    this.fromGeoLengthNum=this.markers[0].length-this.degreeRange;
    this.toGeoLengthNum=this.markers[0].length+this.degreeRange;
    this.fromGeoWidthNum=this.markers[0].width-this.degreeRange;
    this.toGeoWidthNum=this.markers[0].width+this.degreeRange;
    // this.postSearchByGeo();
  }


  searchMarkers: Marker[] = [{
    width: this.defaultWidth,
    length: this.defaultLength,
    widthString: this.defaultWidth.toFixed(10),
    lengthString: this.defaultLength.toFixed(10),
    label: 'TU JESTEM',
    draggable: true,
    speedDate: new SpeedDate()
  }];

  // refreshMarks(){
  //   if(this.markers.length>1)
  //     this.markers.splice(1,this.markers.length);
  //
  //   for(let m of this.markers){
  //     m.lng=Number.parseFloat(m.geoLength);
  //     m.lat=Number.parseFloat(m.geoWidth);
  //
  //     this.markers.push(m);
  //   }
  // }

  clickedMarker(label: string, index: number) {
    console.log(`clicked the marker: ${label || index}`)
  }


  mapClicked(event: any) {
    console.info("mapClicked: W: "+event.coords.lat+" L: "+event.coords.lng);
    if(this.detailView)
      return;

    this.markers[0].width = event.coords.lat;
    this.markers[0].length = event.coords.lng;

    this.changeRange(this.kilometersRange);
    // this.postSearchByGeo();

    console.info("Zmiana wartosci na: "+this.kilometersRange);
  }

  markerDragEnd(m: Marker, event: any) {
    if(this.detailView)
      return;

    this.markers[0].width=event.coords.lat;
    this.markers[0].length=event.coords.lng;
    this.changeRange(this.kilometersRange);
    console.info("markerDragEnd: sze/dlu CENTRALI "+event.coords.lat+" "+event.coords.lng);
    //this.postSearchByGeo();
    // this.postSearchByGeo();
  }

  public repaintMap() {
    console.log("repaintMap");
    this.agmMap.triggerResize();
  }



}
