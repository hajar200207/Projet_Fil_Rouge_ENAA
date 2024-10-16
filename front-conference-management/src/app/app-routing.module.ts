import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AdminGuard } from './services/AdminGuard';
import { ConferencierDashboardComponent } from './conferencier-dashboard/conferencier-dashboard.component';
import { ConferencierGuard } from './services/ConferencierGuard';
import { CommiteOrganisationGuard } from './services/CommiteOrganisationGuard';
import { CommiteScientifiqueGuard } from './services/CommiteScientifiqueGuard';
import { CommitScientifiqueDashboardComponent } from './commit-scientifique-dashboard/commit-scientifique-dashboard.component';
import { CommitOrganisationDashboardComponent } from './commit-organisation-dashboard/commit-organisation-dashboard.component';
import { InviteDashboardComponent } from './invite-dashboard/invite-dashboard.component';
import { InviteGuard } from './services/InviteGuard';
import { ForgotPasswordComponent } from './auth/forgot-password/forgot-password.component';
import { ResetPasswordComponent } from './auth/reset-password/reset-password.component';
import { DemandeListComponent } from './Demandes/demande-list/demande-list.component';
import { DemandeFormComponent } from './Demandes/demande-form/demande-form.component';
import { DemandeDetailComponent } from './Demandes/demande-detail/demande-detail.component';
import { CreateConferenceComponent } from './Conferences/create-conference/create-conference.component';
import { ConferenceDetailsComponent } from './Conferences/conference-details/conference-details.component';
import { LocauxManagementComponent } from './locaux/locaux-management/locaux-management.component';
import { CreateReservationComponent } from './reservations/create-reservation/create-reservation.component';
import { HomeComponent } from "./conference-website/home/home.component";
import { AboutComponent } from "./conference-website/about/about.component";
import { TeamComponent } from "./conference-website/team/team.component";
import { ContactComponent } from "./conference-website/contact/contact.component";

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'team', component: TeamComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'auth', loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule) },
  { path: 'admin-dashboard', component: AdminDashboardComponent, canActivate: [AdminGuard] },
  { path: 'conferencier-dashboard', component: ConferencierDashboardComponent, canActivate: [ConferencierGuard] },
  { path: 'commit-organisation-dashboard', component: CommitOrganisationDashboardComponent, canActivate: [CommiteOrganisationGuard] },
  { path: 'commit-scientifique-dashboard', component: CommitScientifiqueDashboardComponent, canActivate: [CommiteScientifiqueGuard] },
  { path: 'invite-dashboard', component: InviteDashboardComponent, canActivate: [InviteGuard] },
  { path: 'forgot-password', component: ForgotPasswordComponent },
  { path: 'reset-password', component: ResetPasswordComponent },
  { path: 'demandes', component: DemandeListComponent },
  { path: 'demandes/new', component: DemandeFormComponent },
  { path: 'demandes/:id', component: DemandeDetailComponent },
  { path: 'demandes/:id/edit', component: DemandeFormComponent },
  { path: 'create-conference', component: CreateConferenceComponent },
  { path: 'conference-details/:id', component: ConferenceDetailsComponent },
  { path: 'create-reservation', component: CreateReservationComponent },
  { path: 'locaux', component: LocauxManagementComponent },
  { path: '**', redirectTo: '/home' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
