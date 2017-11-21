export interface Marker{
  lat: number;
  lng: number;
  geoWidth:string;
  geoLength:string;
  label?: string;
  draggable: boolean;
  title: string;
  description: string;
  idEvent:number;
  startTime:Date;
}
