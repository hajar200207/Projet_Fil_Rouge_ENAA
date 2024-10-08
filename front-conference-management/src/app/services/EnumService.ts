import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EnumService {

  private baseUrl = 'http://localhost:8082/api/enums';

  constructor(private http: HttpClient) { }

  getReservationStatuses(): Observable<string[]> {
    return this.http.get<string[]>(`${this.baseUrl}/reservation-status`);
  }

  getRegistrationTypes(): Observable<string[]> {
    return this.http.get<string[]>(`${this.baseUrl}/registration-types`);
  }

  getCountries(): Observable<string[]> {
    return this.http.get<string[]>(`${this.baseUrl}/countries`);
  }

  getCities(): Observable<string[]> {
    return this.http.get<string[]>(`${this.baseUrl}/cities`);
  }
}
