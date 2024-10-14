import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-register-conferencier',
  templateUrl: './register-conferencier.component.html',
  styleUrls: ['./register-conferencier.component.css']
})
export class RegisterConferencierComponent implements OnInit {
  registerForm!: FormGroup;

  constructor(private fb: FormBuilder, private authService: AuthService) {}

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      nom: ['', Validators.required],
      prenom: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      motDePasse: ['', Validators.required],
      specialite: ['', Validators.required],
      type: ['conferencier'] 
    });
  }

  onSubmit(): void {
    if (this.registerForm.valid) {
      this.authService.registerConferencier(this.registerForm.value).subscribe(
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
