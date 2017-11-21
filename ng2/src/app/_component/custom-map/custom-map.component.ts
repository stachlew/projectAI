import {Component, Input, OnInit} from '@angular/core';
import {Marker} from "../../_model/marker";

@Component({
  selector: 'app-custom-map',
  templateUrl: './custom-map.component.html',
  styleUrls: ['./custom-map.component.css']
})
export class CustomMapComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  @Input('markers') inputMarkers: Marker[] = [];


  zoom: number = 12;
  defaultLat: number = 52.25353;
  defaultLng: number = 20.90067;


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

    this.fromGeoLengthNum=this.markers[0].lng-this.degreeRange;
    this.toGeoLengthNum=this.markers[0].lng+this.degreeRange;
    this.fromGeoWidthNum=this.markers[0].lat-this.degreeRange;
    this.toGeoWidthNum=this.markers[0].lat+this.degreeRange;

    // this.postSearchByGeo();
  }


  markers: Marker[] = [{
    lat: this.defaultLat,
    lng: this.defaultLng,
    geoWidth: this.defaultLat.toFixed(10),
    geoLength: this.defaultLng.toFixed(10),
    label: 'TU JESTEM',
    draggable: true,
    description: 'Umieść w centrum wyszukiwania',
    idEvent: -1,
    title: 'Znacznik wyszukiwania',
    startTime:null
  }];

  refreshMarks(){
    if(this.markers.length>1)
      this.markers.splice(1,this.markers.length);

    for(let m of this.markers){
      m.lng=Number.parseFloat(m.geoLength);
      m.lat=Number.parseFloat(m.geoWidth);

      this.markers.push(m);
    }
  }

  clickedMarker(label: string, index: number) {
    //console.log(`clicked the marker: ${label || index}`)
  }


  mapClicked(event: any) {
    this.markers[0].lat = event.coords.lat;
    this.markers[0].lng = event.coords.lng;
    //console.info("sze/dlu CENTRALI "+$event.coords.lat+" "+$event.coords.lng);
    this.changeRange(this.kilometersRange);
    // this.postSearchByGeo();

    //console.info("Zmiana wartosci na: "+this.kilometersRange);
  }

  markerDragEnd(m: Marker, event: any) {
    this.markers[0].lat=event.coords.lat;
    this.markers[0].lng=event.coords.lng;
    this.changeRange(this.kilometersRange);
    //this.postSearchByGeo();
    // this.postSearchByGeo();
  }



}
