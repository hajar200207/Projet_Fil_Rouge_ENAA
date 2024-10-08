import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable, tap} from 'rxjs';
import {Conferencier} from "../models/Conferencier.model";
import {Invite} from "../models/invite.model";

interface RegisterPayload {
  nom: string;
  prenom: string;
  email: string;
  motDePasse: string;

}
interface LoginResponse {
  token: string;
  role: string;
  conferencierId?: number;
  commitOrganisationId?: number;
  inviteId?: number;// Add this line

}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private baseUrl = 'http://localhost:8082/api/personnes';

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
    const params = new HttpParams()
      .set('email', email)
      .set('password', password);

    return this.http.post(`${this.baseUrl}/login`, {}, { params }).pipe(
      tap((response: any) => {
        this.setToken(response.token);
        this.setConferencierId(response.conferencierId);
        this.setCommitOrganisationId(response.commitOrganisationId);
        this.setInviteId(response.inviteId);
        if (response.inviteId) {
          this.setInviteId(response.inviteId.toString());
        }
      })
    );
  }



  setConferencierId(conferencierId: string): void {
    localStorage.setItem('conferencierId', conferencierId);
  }

  getConferencierId(): string | null {
    return localStorage.getItem('conferencierId');
  }


  setCommitOrganisationId(commitOrganisationId: string): void { // Add this method
    localStorage.setItem('commitOrganisationId', commitOrganisationId);
  }

  getCommitOrganisationId(): string | null { // Add this method
    return localStorage.getItem('commitOrganisationId');
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
    localStorage.removeItem('conferencierId');

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

  getConferencierDetails(conferencierId: number): Observable<Conferencier> {
    return this.http.get<Conferencier>(`${this.baseUrl}/conferenciers/${conferencierId}`);
  }


  getInviteId(): string | null {
    return localStorage.getItem('inviteId');
  }

  setInviteId(inviteId: string): void {
    localStorage.setItem('inviteId', inviteId);
  }

  getInviteDetails(inviteId: number): Observable<Invite> {
    return this.http.get<Invite>(`${this.baseUrl}/invites/${inviteId}`);
  }


}
