

import {NgModule} from "@angular/core";
import {
  MatButtonModule, MatCheckboxModule, MatDatepickerModule, MatIconModule, MatInputModule, MatNativeDateModule,
  MatPaginatorModule, MatRadioModule,
  MatSelectModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatTabsModule
} from "@angular/material";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FileUploadModule} from "ng2-file-upload";

@NgModule({
  imports: [
    MatButtonModule,
    MatCheckboxModule,
    MatIconModule,
    MatTabsModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatSelectModule,
    MatSlideToggleModule,
    MatPaginatorModule,
    MatSliderModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatRadioModule,
    FileUploadModule
  ],
  exports: [
    MatButtonModule,
    MatCheckboxModule,
    MatIconModule,
    MatTabsModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatSelectModule,
    MatSlideToggleModule,
    MatPaginatorModule,
    MatSliderModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatRadioModule,
    FileUploadModule
  ],
})
export class CustomMaterialModule { }
