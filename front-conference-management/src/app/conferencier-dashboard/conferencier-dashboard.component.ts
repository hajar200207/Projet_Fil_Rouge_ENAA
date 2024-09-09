import { Component } from '@angular/core';
import {AuthService} from "../services/auth.service";

@Component({
  selector: 'app-conferencier-dashboard',
  templateUrl: './conferencier-dashboard.component.html',
  styleUrls: ['./conferencier-dashboard.component.css']
})
export class ConferencierDashboardComponent {
  isFormVisible: boolean = false;

  constructor(public authService: AuthService) {}

  showDemandeForm(): void {
    this.isFormVisible = true;
  }
}
