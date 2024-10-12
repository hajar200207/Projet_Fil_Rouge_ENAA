import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AuthRoutingModule } from './auth-routing.module';
import { RegisterInviteComponent } from './register-invite/register-invite.component';
import { RegisterCommitOrganisationComponent } from './register-commit-organisation/register-commit-organisation.component';
import { RegisterConferencierComponent } from './register-conferencier/register-conferencier.component';
import { RegisterCommitScientifiqueComponent } from './register-commit-scientifique/register-commit-scientifique.component';
import { LoginComponent } from './login/login.component';
import {MatInputModule} from "@angular/material/input";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";

@NgModule({
  declarations: [
    RegisterInviteComponent,
    RegisterCommitOrganisationComponent,
    RegisterConferencierComponent,
    RegisterCommitScientifiqueComponent,
    LoginComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,  // Add this line
    AuthRoutingModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule
  ]
})
export class AuthModule { }
