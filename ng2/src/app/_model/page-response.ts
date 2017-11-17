export class PageResponse{
  pageNo: number;
  pageCount: number;
  elementsCount: number;
  value: any[];

  constructor(){
    this.pageNo = 1;
    this.pageCount = 0;
    this.elementsCount = 0;
    this.value = [];
  }
}
