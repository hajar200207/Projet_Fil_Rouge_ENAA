import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {AuthService} from "../../services/auth.service";


@Component({
  selector: 'app-register-commit-organisation',
  templateUrl: './register-commit-organisation.component.html',
  styleUrls: ['./register-commit-organisation.component.css']
})
export class RegisterCommitOrganisationComponent implements OnInit {
  registerForm!: FormGroup;

  constructor(private fb: FormBuilder, private authService: AuthService) {}

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      nom: ['', Validators.required],
      prenom: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      motDePasse: ['', Validators.required],
      fonction: ['', Validators.required],
      type: ['commitOrganisation']  // Default value for the hidden type field
    });
  }

  onSubmit(): void {
    if (this.registerForm.valid) {
      this.authService.registerCommitOrganisation(this.registerForm.value).subscribe(
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
