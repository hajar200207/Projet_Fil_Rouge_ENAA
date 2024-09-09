import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AdminDashboardComponent} from "./admin-dashboard/admin-dashboard.component";
import {AdminGuard} from "./services/AdminGuard";
import {ConferencierDashboardComponent} from "./conferencier-dashboard/conferencier-dashboard.component";
import {ConferencierGuard} from "./services/ConferencierGuard";
import {CommiteOrganisationGuard} from "./services/CommiteOrganisationGuard";
import {CommiteScientifiqueGuard} from "./services/CommiteScientifiqueGuard";
import {
  CommitScientifiqueDashboardComponent
} from "./commit-scientifique-dashboard/commit-scientifique-dashboard.component";
import {
  CommitOrganisationDashboardComponent
} from "./commit-organisation-dashboard/commit-organisation-dashboard.component";
import {InviteDashboardComponent} from "./invite-dashboard/invite-dashboard.component";
import {InviteGuard} from "./services/InviteGuard";
import {ForgotPasswordComponent} from "./auth/forgot-password/forgot-password.component";
import {ResetPasswordComponent} from "./auth/reset-password/reset-password.component";
import {DemandeListComponent} from "./Demandes/demande-list/demande-list.component";
import {DemandeFormComponent} from "./Demandes/demande-form/demande-form.component";
import {DemandeDetailComponent} from "./Demandes/demande-detail/demande-detail.component";

const routes: Routes = [
  { path: 'auth', loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule) },
  { path: '', redirectTo: '/auth/login', pathMatch: 'full' },
  { path: 'admin-dashboard', component: AdminDashboardComponent, canActivate: [AdminGuard] },
  { path: 'conferencier-dashboard', component: ConferencierDashboardComponent, canActivate: [ConferencierGuard] },
  { path: 'commit-organisation-dashboard', component: CommitOrganisationDashboardComponent, canActivate: [CommiteOrganisationGuard] },
  { path: 'commit-scientifique-dashboard', component: CommitScientifiqueDashboardComponent, canActivate: [CommiteScientifiqueGuard] }, // Consistent naming
  { path: 'invite-dashboard', component: InviteDashboardComponent, canActivate: [InviteGuard] },
  { path: 'forgot-password', component: ForgotPasswordComponent },
  { path: 'reset-password', component: ResetPasswordComponent },
  { path: 'demandes', component: DemandeListComponent },
  { path: 'demandes/new', component: DemandeFormComponent },
  { path: 'demandes/:id', component: DemandeDetailComponent },
  { path: 'demandes/:id/edit', component: DemandeFormComponent },

  { path: '**', redirectTo: '/auth/login' }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
