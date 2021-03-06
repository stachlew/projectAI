//ANGULAR
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

//DODATKI ANGULAR
import {CustomMaterialModule} from "./custom-material-module";

//AUTENTYKCJA
import { AuthenticationModule } from './_service/authentication/authentication.module';

//ROUTING
import { AppRoutingModule, routingComponents, routingGuards } from './app.routing';

//KOMPONENTY
import { AppComponent } from './app.component';

import { AlertComponent } from './_component/alert/alert.component';
import { UnauthorizedComponent } from './_component/unauthorized/unauthorized.component';

import { NavigationComponent} from './_component/navigation/navigation.component';
import { LoginFormComponent } from './general/login/login-form/login-form.component';
import { HomeComponent } from './general/home/home.component';
import { LoginComponent } from './general/login/login.component';
import { FooterComponent } from './_component/footer/footer.component';
import { AccountComponent } from './general/account/account.component';
import { RegisterComponent } from './general/register/register.component';
import {ChatComponent} from "./main/chat/chat.component";
import {PersonsListComponent} from "./main/persons-list/persons-list.component";
import {PersonDetailsComponent} from "./main/person-details/person-details.component";
import {SpeedDateDetailsComponent} from "./main/speed-date-details/speed-date-details.component";
import {SpeedDatesListComponent} from "./main/speed-dates-list/speed-dates-list.component";
import {SpeedDateCreateComponent} from "./managment/speed-date-create/speed-date-create.component";
import {SpeedDateManagmentComponent} from "./managment/speed-date-managment/speed-date-managment.component";
import {SpeedDatesManagmentListComponent} from "./managment/speed-dates-managment-list/speed-dates-managment-list.component";

//SERWISY
import { AuthenticationService } from './_service/authentication/authentication.service';
import { HttpSecService } from "./_service/util/http-sec.service";
import {UtilsService} from "./_service/util/utils.service";

//STALE
import { Constants } from './_service/util/constants';
import { ChatContactsComponent } from './main/chat/chat-contacts/chat-contacts.component';
import { ChatConversationComponent } from './main/chat/chat-conversation/chat-conversation.component';
import { ChatMessageComponent } from './main/chat/chat-message/chat-message.component'
import {ChatManagerService} from "./main/chat/chat-manager.service";
import {PersonListService} from "./main/persons-list/person-list.service";
import { CustomPaginatorComponent } from './_component/custom-paginator/custom-paginator.component';
import {AppUrls} from "./_service/util/app-urls";
import { CustomDateTimeComponent } from './_component/custom-date-time/custom-date-time.component';
import {TruncatePipe} from "./pipes/truncate";
import {DictionaryService} from "./_service/util/dictionary.service";
import { ParticipantSliderComponent } from './main/speed-date-details/participant-slider/participant-slider.component';
import { CustomMapComponent } from './_component/custom-map/custom-map.component';
import {AgmCoreModule} from "@agm/core";
import { MatchFormPageComponent } from './main/match-form-page/match-form-page.component';


@NgModule({
  declarations: [
    //ROUTING
    routingComponents,
    //DODATKI
    // FileSelectDirective,

    //KOMPONENTY
    //Aplikacja
    AppComponent,

    //Pojedyncze
    AlertComponent,
    UnauthorizedComponent,

    //Ogolne
    NavigationComponent,
    LoginFormComponent,
    HomeComponent,
    LoginComponent,
    FooterComponent,
    RegisterComponent,

    //Komponenty zalogowanych
    AccountComponent,

    //USER
    ChatComponent,
    PersonDetailsComponent,
    PersonsListComponent,
    SpeedDateDetailsComponent,
    SpeedDatesListComponent,

    //MANAGER
    SpeedDateCreateComponent,
    SpeedDateManagmentComponent,
    SpeedDatesManagmentListComponent,
    ChatContactsComponent,
    ChatConversationComponent,
    ChatMessageComponent,
    CustomPaginatorComponent,
    CustomDateTimeComponent,

    //PIPE
    TruncatePipe,

    ParticipantSliderComponent,

    CustomMapComponent,

    MatchFormPageComponent
  ],
  imports: [
    BrowserModule,
    CustomMaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    AuthenticationModule,
    AppRoutingModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyDzRwU70aqc9Fsin5RDv0MGpP12b-nnBGA'
    })
  ],
  providers: [
    Constants,
    AuthenticationService,
    HttpSecService,
    routingGuards,
    UtilsService,
    ChatManagerService,
    PersonListService,
    DictionaryService,
    AppUrls
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
