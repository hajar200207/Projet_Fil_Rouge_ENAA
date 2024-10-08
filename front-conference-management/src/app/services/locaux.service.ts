import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {LocauxDTO} from "../models/locaux.model";

@Injectable({
    providedIn: 'root',
})
export class LocauxService {
    private apiUrl = 'http://localhost:8082/api/locaux';

    constructor(private http: HttpClient) {}

    getAllLocaux(): Observable<LocauxDTO[]> {
        return this.http.get<LocauxDTO[]>(this.apiUrl);
    }

    createLocaux(locauxDTO: LocauxDTO): Observable<LocauxDTO> {
        return this.http.post<LocauxDTO>(this.apiUrl, locauxDTO);
    }

    updateLocaux(id: number, locauxDTO: LocauxDTO): Observable<LocauxDTO> {
        return this.http.put<LocauxDTO>(`${this.apiUrl}/${id}`, locauxDTO);
    }

    deleteLocaux(id: number | null): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }
}
