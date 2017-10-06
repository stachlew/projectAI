

import {NgModule} from "@angular/core";
import {MatButtonModule, MatCheckboxModule, MatIconModule, MatInputModule, MatTabsModule} from "@angular/material";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  imports: [
    MatButtonModule,
    MatCheckboxModule,
    MatIconModule,
    MatTabsModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatIconModule
  ],
  exports: [
    MatButtonModule,
    MatCheckboxModule,
    MatIconModule,
    MatTabsModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatIconModule
  ],
})
export class CustomMaterialModule { }
