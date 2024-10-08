import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {ConferenceCreateDTO} from "../DTO/Conference-Create-dto.model";
import {ConferenceDetailDTO} from "../DTO/conference-detail.dto";
import {ConferenceDetailsDTO} from "../DTO/conference-details-dto";

@Injectable({
  providedIn: 'root'
})
export class ConferenceService {
  private apiUrl = 'http://localhost:8082/api/conferences';

  constructor(private http: HttpClient) {}

  createConference(conferenceCreateDTO: ConferenceCreateDTO): Observable<any> {
    return this.http.post(`${this.apiUrl}`, conferenceCreateDTO);
  }
  getConferenceDetails(id: number): Observable<ConferenceDetailsDTO> {
    return this.http.get<ConferenceDetailsDTO>(`${this.apiUrl}/conference/${id}/details`);
  }
  getAllConferenceDetails(): Observable<ConferenceDetailsDTO[]> {
    return this.http.get<ConferenceDetailsDTO[]>(`${this.apiUrl}/all-details`);
  }
}
