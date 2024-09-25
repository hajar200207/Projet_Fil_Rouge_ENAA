import { Component, OnInit } from '@angular/core';
import {AuthService} from "../services/auth.service";

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  conferencierId: number | null = null; // Ensure this is number or null

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.getConferencierId();
  }

  private getConferencierId(): void {
    const id = this.authService.getConferencierId();
    this.conferencierId = id ? Number(id) : null; // Ensure id is converted to a number
    if (this.conferencierId === null) {
      console.warn('Conferencier ID not found.');
    }
  }
}
