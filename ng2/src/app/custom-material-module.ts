

import {NgModule} from "@angular/core";
import {
  MatButtonModule, MatCheckboxModule, MatIconModule, MatInputModule, MatPaginatorModule, MatSelectModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatTabsModule
} from "@angular/material";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

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
    MatSliderModule
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
    MatSliderModule
  ],
})
export class CustomMaterialModule { }
