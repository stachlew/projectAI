import {AfterViewInit, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Constants} from "../../_service/util/constants";

@Component({
  selector: 'app-custom-paginator',
  templateUrl: './custom-paginator.component.html',
  styleUrls: ['./custom-paginator.component.css']
})
export class CustomPaginatorComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    this.updatePaginator();
  }

  public updatePaginator(){
    this.countAllPages();
    this.checkButtonsAvl();
  }

  @Output() pageChange = new EventEmitter();

  @Input('pageSize') pageSize: number = Constants.PAGINATOR_ELEMENTS;
  @Input('currentPage') currentPage: number = 1;
  @Input('elementsCount') elementsCount: number = 0;

  private isPrevAvl: boolean = false;
  private isNextAvl: boolean = false;
  private allPages: number = 1;

  countAllPages(){
    this.allPages = Math.floor(this.elementsCount / this.pageSize);
    if(this.elementsCount % this.pageSize > 0){
      this.allPages++;
    }

    if(this.allPages == 0){
      this.allPages = 1;
    }
  }

  nextPage(){
    if(this.isNextAvl){
      this.currentPage++;
      this.checkButtonsAvl();
      this.pageChange.emit(this.currentPage);
    }
  }

  prevPage(){
    if(this.isPrevAvl){
      this.currentPage--;
      this.checkButtonsAvl();
      this.pageChange.emit(this.currentPage);
    }
  }

  checkButtonsAvl(){
    if(this.currentPage>1){
      this.isPrevAvl = true;
    }else{
      this.isPrevAvl = false;
    }

    if(this.currentPage<this.allPages && this.elementsCount > 0 ){
      this.isNextAvl = true;
    }else {
      this.isNextAvl = false;
    }
  }


}
