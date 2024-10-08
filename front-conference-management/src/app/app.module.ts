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
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
