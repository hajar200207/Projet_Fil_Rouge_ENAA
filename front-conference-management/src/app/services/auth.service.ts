// src/app/services/auth.service.ts
import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';

interface RegisterPayload {
  nom: string;
  prenom: string;
  email: string;
  motDePasse: string;

}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private baseUrl = 'http://localhost:8080/api/personnes';

  constructor(private http: HttpClient) { }

  register(personne: RegisterPayload): Observable<any> {
    return this.http.post(`${this.baseUrl}/register`, personne);
  }
  registerInvite(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/register`, data);
  }

  registerCommitScientifique(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/register`, data);
  }
  registerCommitOrganisation(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/register`, data);
  }
  registerConferencier(data: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/register`, data);
  }
  login(email: string, password: string): Observable<any> {
    const params = new HttpParams().set('email', email).set('password', password);
    return this.http.post(`${this.baseUrl}/login`, {}, { params });
  }

  setToken(token: string): void {
    localStorage.setItem('authToken', token);
  }

  getToken(): string | null {
    return localStorage.getItem('authToken');
  }

  isLoggedIn(): boolean {
    return !!this.getToken();
  }

  logout(): void {
    localStorage.removeItem('authToken');
  }
  getUserRole(): string {
    const token = localStorage.getItem('token');
    if (!token) {
      return '';
    }
    // Assuming the role is stored in the token's payload
    const payload = JSON.parse(atob(token.split('.')[1]));
    return payload.role;
  }
  forgotPassword(email: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/forgot-password`, { email });
  }

  resetPassword(email: string, newPassword: string): Observable<any> {
    const params = new HttpParams()
      .set('email', email)
      .set('newPassword', newPassword); // Ensure both parameters are set
    return this.http.post(`${this.baseUrl}/reset-password`, {}, { params });
  }

}
