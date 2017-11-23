import {SpeedDate} from "./speed-date";

export interface Marker{
  width: number;
  length: number;
  widthString:string;
  lengthString:string;
  label: string;
  draggable: boolean;

  speedDate: SpeedDate;
}
