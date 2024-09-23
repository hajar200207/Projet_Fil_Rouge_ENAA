import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from "../services/auth.service";
import { Conferencier } from "../models/Conferencier.model";

@Component({
  selector: 'app-conferencier-dashboard',
  templateUrl: './conferencier-dashboard.component.html',
  styleUrls: ['./conferencier-dashboard.component.css']
})
export class ConferencierDashboardComponent implements OnInit {
  conferencierId: string | null = null;
  conferencierData: Conferencier | null = null;
  isFormVisible: boolean = false;

  constructor(
    private route: ActivatedRoute,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.conferencierId = this.authService.getConferencierId();

    if (!this.conferencierId) {
      console.error('No conferencierId found');
      return;
    }

    this.fetchConferencierData();
  }

  fetchConferencierData(): void {
    if (this.conferencierId) {
      this.authService.getConferencierDetails(Number(this.conferencierId)).subscribe(
        (data) => {
          this.conferencierData = data;
        },
        (error) => {
          console.error('Error fetching conferencier data', error);
        }
      );
    }
  }

  showDemandeForm(): void {
    this.isFormVisible = true;
  }

  hideDemandeForm(): void {
    this.isFormVisible = false;
  }
}
