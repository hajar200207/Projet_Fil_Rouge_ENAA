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
import { ForgotPasswordComponent } from './auth/forgot-password/forgot-password.component';
import { ResetPasswordComponent } from './auth/reset-password/reset-password.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { DemandeListComponent } from './Demandes/demande-list/demande-list.component';
import { DemandeFormComponent } from './Demandes/demande-form/demande-form.component';
import { DemandeDetailComponent } from './Demandes/demande-detail/demande-detail.component';
import { CreateConferenceComponent } from './Conferences/create-conference/create-conference.component';
import { ConferenceDetailsComponent } from './Conferences/conference-details/conference-details.component';
import { LocauxManagementComponent } from './locaux/locaux-management/locaux-management.component';
import { CreateReservationComponent } from './reservations/create-reservation/create-reservation.component';
import { ListReservationsComponent } from './reservations/list-reservations/list-reservations.component';
import { HomeComponent } from './conference-website/home/home.component';
import { AboutComponent } from './conference-website/about/about.component';
import { TeamComponent } from './conference-website/team/team.component';
import { ContactComponent } from './conference-website/contact/contact.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";
import {MatIconModule} from "@angular/material/icon";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule} from "@angular/material/list";
import {MatCardModule} from "@angular/material/card";
import {MatTabsModule} from "@angular/material/tabs";
import {MatTableModule} from "@angular/material/table";

@NgModule({
  declarations: [
    AppComponent,
    AdminDashboardComponent,
    ConferencierDashboardComponent,
    CommitOrganisationDashboardComponent,
    CommitScientifiqueDashboardComponent,
    InviteDashboardComponent,
    ForgotPasswordComponent,
    ResetPasswordComponent,
    DemandeListComponent,
    DemandeDetailComponent,
    DemandeFormComponent,
    CreateConferenceComponent,
    ConferenceDetailsComponent,
    LocauxManagementComponent,
    CreateReservationComponent,
    ListReservationsComponent,
    HomeComponent,
    AboutComponent,
    TeamComponent,
    ContactComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatButtonModule,
    MatInputModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    MatCardModule,
    MatTabsModule,
    MatTableModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
