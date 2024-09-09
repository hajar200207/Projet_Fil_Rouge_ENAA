// demande.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {DemandeDTO} from "../DTO/demande-dto.model";
import {DemandeConferencierDTO} from "../DTO/demande-conferencier-dto.model";

@Injectable({
  providedIn: 'root'
})
export class DemandeService {
  private baseUrl = 'http://localhost:8080/api/demandes';

  constructor(private http: HttpClient) {}

  createDemande(demandeDTO: DemandeDTO): Observable<DemandeDTO> {
    return this.http.post<DemandeDTO>(this.baseUrl, demandeDTO);
  }

  getAllDemandes(): Observable<DemandeDTO[]> {
    return this.http.get<DemandeDTO[]>(this.baseUrl);
  }

  getDemandeById(id: number): Observable<DemandeDTO> {
    return this.http.get<DemandeDTO>(`${this.baseUrl}/${id}`);
  }

  updateDemande(id: number, demandeDTO: DemandeDTO): Observable<DemandeDTO> {
    return this.http.put<DemandeDTO>(`${this.baseUrl}/${id}`, demandeDTO);
  }

  deleteDemande(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  getDemandesByConferencierId(conferencierId: number): Observable<DemandeConferencierDTO[]> {
    return this.http.get<DemandeConferencierDTO[]>(`${this.baseUrl}/conferencier/${conferencierId}`);
  }
}
