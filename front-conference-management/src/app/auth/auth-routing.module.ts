import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterInviteComponent } from './register-invite/register-invite.component';
import { RegisterCommitOrganisationComponent } from './register-commit-organisation/register-commit-organisation.component';
import { RegisterConferencierComponent } from './register-conferencier/register-conferencier.component';
import { RegisterCommitScientifiqueComponent } from './register-commit-scientifique/register-commit-scientifique.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: 'register-invite', component: RegisterInviteComponent },
  { path: 'register-commit-organisation', component: RegisterCommitOrganisationComponent },
  { path: 'register-conferencier', component: RegisterConferencierComponent },
  { path: 'register-commit-scientifique', component: RegisterCommitScientifiqueComponent },
  { path: 'login', component: LoginComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule { }
