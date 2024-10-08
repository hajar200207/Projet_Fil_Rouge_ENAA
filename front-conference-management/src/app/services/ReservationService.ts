import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ReservationDTO } from "../DTO/reservation-dto";

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private apiUrl = 'http://localhost:8082/api/reservations';

  constructor(private http: HttpClient) { }

  createReservation(reservation: ReservationDTO): Observable<any> {
    return this.http.post(`${this.apiUrl}/create`, reservation);
  }
}
