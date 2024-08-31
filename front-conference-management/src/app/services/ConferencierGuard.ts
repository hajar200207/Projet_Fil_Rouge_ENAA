import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class ConferencierGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate(): boolean {
    const token = this.authService.getToken();
    // Decode the token and check if the user role is 'ROLE_CONFERENCIER'
    if (token && this.getRoleFromToken(token) === 'ROLE_CONFERENCIER') {
      return true;
    } else {
      this.router.navigate(['/auth/login']);
      return false;
    }
  }

  private getRoleFromToken(token: string): string {
    const payload = atob(token.split('.')[1]);
    const parsedPayload = JSON.parse(payload);
    return parsedPayload.role;
  }
}
