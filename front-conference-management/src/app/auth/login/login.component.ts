import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {AuthService} from "../../services/auth.service";
import { trigger, transition, style, animate } from '@angular/animations';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  animations: [
    trigger('fadeIn', [
      transition(':enter', [
        style({ opacity: 0 }),
        animate('500ms ease-in', style({ opacity: 1 }))
      ])
    ])
  ]
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;

  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  onLogin(): void {
    if (this.loginForm.valid) {
      const { email, password } = this.loginForm.value;
      this.authService.login(email, password).subscribe(
        response => {
          console.log('Login successful', response);
          this.authService.setToken(response.token);
          this.redirectUser(response.role);
          this.authService.setConferencierId(response.conferencierId);

        },
        error => {
          console.error('Login failed', error);
        }
      );
    }
  }

  private redirectUser(role: string): void {
    switch(role) {
      case 'ROLE_ADMIN':
        this.router.navigate(['/admin-dashboard']);
        break;
      case 'ROLE_CONFERENCIER':
        this.router.navigate(['/conferencier-dashboard']);
        break;
      case 'ROLE_COMMIT_ORGANISATION':
        this.router.navigate(['/commit-organisation-dashboard']);
        break;
      case 'ROLE_COMMIT_SCIENTIFIQUE':
        this.router.navigate(['/commit-scientifique-dashboard']);
        break;
      case 'ROLE_INVITE':
        this.router.navigate(['/invite-dashboard']);
        break;
      default:
        this.router.navigate(['/']);
    }
  }

}
