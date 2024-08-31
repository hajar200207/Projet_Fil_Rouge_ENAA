import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-register-invite',
  templateUrl: './register-invite.component.html',
  styleUrls: ['./register-invite.component.css']
})
export class RegisterInviteComponent implements OnInit {
  registerForm!: FormGroup;

  constructor(private fb: FormBuilder, private authService: AuthService) {}

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      nom: ['', Validators.required],
      prenom: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      motDePasse: ['', Validators.required],
      type: ['invite'],
      organisation: ['', Validators.required],
    });
  }

  onSubmit(): void {
    if (this.registerForm.valid) {
      this.authService.registerInvite(this.registerForm.value).subscribe(
        response => {
          console.log('Registration successful', response);
        },
        error => {
          console.error('Registration failed', error);
        }
      );
    }
  }
}
