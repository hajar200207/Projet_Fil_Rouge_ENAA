import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {HttpClientModule} from "@angular/common/http";
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { ConferencierDashboardComponent } from './conferencier-dashboard/conferencier-dashboard.component';
import { CommitOrganisationDashboardComponent } from './commit-organisation-dashboard/commit-organisation-dashboard.component';
import { CommitScientifiqueDashboardComponent } from './commit-scientifique-dashboard/commit-scientifique-dashboard.component';
import { InviteDashboardComponent } from './invite-dashboard/invite-dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminDashboardComponent,
    ConferencierDashboardComponent,
    CommitOrganisationDashboardComponent,
    CommitScientifiqueDashboardComponent,
    InviteDashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
