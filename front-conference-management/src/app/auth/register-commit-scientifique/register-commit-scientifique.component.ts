import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-register-commit-scientifique',
  templateUrl: './register-commit-scientifique.component.html',
  styleUrls: ['./register-commit-scientifique.component.css']
})
export class RegisterCommitScientifiqueComponent implements OnInit {
  registerForm!: FormGroup;

  constructor(private fb: FormBuilder, private authService: AuthService) {}

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      nom: ['', Validators.required],
      prenom: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      motDePasse: ['', Validators.required],
      domaineExpertise: ['', Validators.required],
      type: ['commitScientifique']
    });
  }

  onSubmit(): void {
    if (this.registerForm.valid) {
      this.authService.registerCommitScientifique(this.registerForm.value).subscribe(
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
