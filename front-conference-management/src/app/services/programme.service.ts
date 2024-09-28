import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ProgrammeDTO } from '../models/programme.model';

@Injectable({
  providedIn: 'root'
})
export class ProgrammeService {

  private apiUrl = 'http://localhost:8080/api/programmes';

  constructor(private http: HttpClient) {}

  createProgramme(programme: ProgrammeDTO): Observable<ProgrammeDTO> {
    return this.http.post<ProgrammeDTO>(`${this.apiUrl}`, programme);
  }

  getProgrammes(): Observable<ProgrammeDTO[]> {
    return this.http.get<ProgrammeDTO[]>(`${this.apiUrl}`);
  }

}
