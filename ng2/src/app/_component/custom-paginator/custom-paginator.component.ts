import {AfterViewInit, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

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

  @Input('pageSize') pageSize: number = 10;
  @Input('currentPage') currentPage: number = 1;
  @Input('allElements') allElements: number = 0;

  private isPrevAvl: boolean = false;
  private isNextAvl: boolean = false;
  private allPages: number = 1;

  countAllPages(){
    this.allPages = Math.floor(this.allElements / this.pageSize);
    if(this.allElements % this.pageSize > 0){
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

    if(this.currentPage<this.allPages){
      this.isNextAvl = true;
    }else {
      this.isNextAvl = false;
    }
  }


}
