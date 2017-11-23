import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AppUrls} from "../../_service/util/app-urls";
import {SpeedDate} from "../../_model/speed-date";
import {HttpSecService} from "../../_service/util/http-sec.service";
import {CustomMapComponent} from "../../_component/custom-map/custom-map.component";

@Component({
  selector: 'app-speed-date-details',
  templateUrl: './speed-date-details.component.html',
  styleUrls: ['./speed-date-details.component.css']
})
export class SpeedDateDetailsComponent implements OnInit {

  eventPhotoUrl: string = AppUrls.EVENT_IMAGE_URL;
  eventDetailUrl: string = AppUrls.GUEST_GET_EVENT_DETAILS_URL;

  speedDateId: number;
  details: SpeedDate = new SpeedDate;

  constructor(private route: ActivatedRoute, private httpSrv: HttpSecService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
    this.initDetails(params.speeddateId);
    this.getDetails();
  });
  }

  initDetails(speedDateId: number){
    this.speedDateId = speedDateId;
  }

  getDetails(){
    this.httpSrv.getAndFetchData(this.eventDetailUrl+'/'+this.speedDateId).subscribe(resp=>{
      this.details = resp;
      setTimeout(x=>this.customMap.transformDatesIntoMarkers());
    });
  }

  @ViewChild('customMap') customMap : CustomMapComponent;
  refreshModalMap(){
    console.log("refreshModalMap");
    setTimeout(x=>this.customMap.repaintMap(),700);
  }

}
