import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AdministrationComponent} from './administration/administration.component';
import { SettingsComponent } from './settings/settings.component';
import { UnauthorizedComponent } from './_component/unauthorized/unauthorized.component';
import { AuthenticationGuard } from './_service/authentication/guard/authentication.guard';
import { RoleGuard } from './_service/authentication/guard/role.guard';
import { AccountComponent } from './account/account.component'
import {PersonsListComponent} from "./persons-list/persons-list.component";
import {SpeedDatesListComponent} from "./speed-dates-list/speed-dates-list.component";
import {ChatComponent} from "./chat/chat.component";
import {AccountWizardComponent} from "./account-wizard/account-wizard.component";
import {SpeedDatesManagmentComponent} from "./speed-dates-managment/speed-dates-managment.component";
import {SpeedDatesCreateComponent} from "./speed-dates-create/speed-dates-create.component";

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
    path: 'unauthorized',
    component: UnauthorizedComponent
  },

  //USER
  {
    path: 'personslist',
    component: PersonsListComponent,
    canActivate: [AuthenticationGuard, RoleGuard],
    data: { roles : ['ROLE_USER'] }
  },
  {
    path: 'speeddatesList',
    component: SpeedDatesListComponent,
    canActivate: [AuthenticationGuard, RoleGuard],
    data: { roles : ['ROLE_USER'] }
  },
  {
    path: 'chat',
    component: ChatComponent,
    canActivate: [AuthenticationGuard, RoleGuard],
    data: { roles : ['ROLE_USER'] }
  },
  {
    path: 'accountWizard',
    component: AccountWizardComponent,
    canActivate: [AuthenticationGuard, RoleGuard],
    data: { roles : ['ROLE_USER'] }
  },

  //MANAGER
  {
    path: 'speedDatesManagment',
    component: SpeedDatesManagmentComponent,
    canActivate: [AuthenticationGuard, RoleGuard],
    data: { roles : ['ROLE_MANAGER'] }
  },
  {
    path: 'speedDatesCreate',
    component: SpeedDatesCreateComponent,
    canActivate: [AuthenticationGuard, RoleGuard],
    data: { roles : ['ROLE_MANAGER'] }
  },



  //ADMIN
  {
    path: 'administration',
    component: AdministrationComponent,
    canActivate: [AuthenticationGuard, RoleGuard],
    data: { roles : ['ROLE_ADMIN'] }
  },
  {
    path: 'settings',
    component: SettingsComponent,
    canActivate: [AuthenticationGuard, RoleGuard],
    data: { roles : ['ROLE_USER'] }
  },
  {
    path: 'account',
    component: AccountComponent,
    canActivate: [AuthenticationGuard, RoleGuard],
    data: { roles : ['ROLE_USER'] }
  },

  //Kazdy brakujacy powyzej
  {
    path: '**',
    redirectTo: 'home'
  },

];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule {}

export const routingComponents = [
  LoginComponent,
  HomeComponent,
  AdministrationComponent,
  SettingsComponent,
  UnauthorizedComponent,
  AccountComponent
];

export const routingGuards = [
  AuthenticationGuard,
  RoleGuard
];
