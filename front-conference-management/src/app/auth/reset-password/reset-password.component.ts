// reset-password.component.ts
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html'
})
export class ResetPasswordComponent {
  email: string = '';
  newPassword: string = '';

  constructor(private authService: AuthService, private route: ActivatedRoute, private router: Router) {}

  onSubmit() {
    this.authService.resetPassword(this.email, this.newPassword).subscribe(
      response => {
        alert('Password reset successfully');
        this.router.navigate(['/login']);
      },
      error => {
        alert('Password reset successfully');
        this.router.navigate(['/login']);
      }
    );
  }

}
