// forgot-password.component.ts
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html'
})
export class ForgotPasswordComponent {
  email: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    this.authService.forgotPassword(this.email).subscribe(
      response => {
        alert('Password reset email sent');
      },
      error => {
        alert('Password reset email sent see your email ');

      }
    );
  }
}
