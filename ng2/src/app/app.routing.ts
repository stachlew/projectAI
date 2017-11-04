import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './general/login/login.component';
import { HomeComponent } from './general/home/home.component';
import { UnauthorizedComponent } from './_component/unauthorized/unauthorized.component';
import { AuthenticationGuard } from './_service/authentication/guard/authentication.guard';
import { RoleGuard } from './_service/authentication/guard/role.guard';
import { AccountComponent } from './general/account/account.component'
import {PersonsListComponent} from "./main/persons-list/persons-list.component";
import {SpeedDatesListComponent} from "./main/speed-dates-list/speed-dates-list.component";
import {ChatComponent} from "./main/chat/chat.component";
import {SpeedDateManagmentComponent} from "./managment/speed-date-managment/speed-date-managment.component";
import {SpeedDateCreateComponent} from "./managment/speed-date-create/speed-date-create.component";
import {RegisterComponent} from "./general/register/register.component";
import {SpeedDateDetailsComponent} from "./main/speed-date-details/speed-date-details.component";
import {PersonDetailsComponent} from "./main/person-details/person-details.component";
import {SpeedDatesManagmentListComponent} from "./managment/speed-dates-managment-list/speed-dates-managment-list.component";

const appRoutes: Routes = [

  //ANONYMOUS
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'unauthorized',
    component: UnauthorizedComponent
  },

  //USER
  {
    path: 'account',
    component: AccountComponent,
    canActivate: [AuthenticationGuard, RoleGuard],
    data: { roles : ['ROLE_USER','ROLE_MANAGER'] }
  },
  {
    path: 'chat',
    component: ChatComponent,
    canActivate: [AuthenticationGuard, RoleGuard],
    data: { roles : ['ROLE_USER'] }
  },
  {
    path: 'person-details/:personId',
    component: PersonDetailsComponent,
    canActivate: [AuthenticationGuard, RoleGuard],
    data: { roles : ['ROLE_USER'] }
  },
  {
    path: 'persons-list',
    component: PersonsListComponent,
    canActivate: [AuthenticationGuard, RoleGuard],
    data: { roles : ['ROLE_USER'] }
  },
  {
    path: 'speed-date-details/:speeddateId',
    component: SpeedDateDetailsComponent,
    canActivate: [AuthenticationGuard, RoleGuard],
    data: { roles : ['ROLE_USER'] }
  },
  {
    path: 'speed-dates-list',
    component: SpeedDatesListComponent,
    canActivate: [AuthenticationGuard, RoleGuard],
    data: { roles : ['ROLE_USER'] }
  },


  //MANAGER
  {
    path: 'speed-date-managment/:speeddateId',
    component: SpeedDateManagmentComponent,
    canActivate: [AuthenticationGuard, RoleGuard],
    data: { roles : ['ROLE_MANAGER'] }
  },
  {
    path: 'speed-dates-managment-list',
    component: SpeedDatesManagmentListComponent,
    canActivate: [AuthenticationGuard, RoleGuard],
    data: { roles : ['ROLE_MANAGER'] }
  },
  {
    path: 'speed-date-create',
    component: SpeedDateCreateComponent,
    canActivate: [AuthenticationGuard, RoleGuard],
    data: { roles : ['ROLE_MANAGER'] }
  },

  // Kazdy brakujacy powyzej
  {
    path: '**',
    redirectTo: ''
  }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule {}

export const routingComponents = [
  LoginComponent,
  HomeComponent,
  UnauthorizedComponent,
  AccountComponent
];

export const routingGuards = [
  AuthenticationGuard,
  RoleGuard
];
