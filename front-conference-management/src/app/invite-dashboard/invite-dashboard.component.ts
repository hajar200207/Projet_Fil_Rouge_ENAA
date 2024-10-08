import { Component, OnInit } from '@angular/core';
import { AuthService } from "../services/auth.service";
import { Invite } from "../models/invite.model";

@Component({
  selector: 'app-invite-dashboard',
  templateUrl: './invite-dashboard.component.html',
  styleUrls: ['./invite-dashboard.component.css']
})
export class InviteDashboardComponent implements OnInit {
  inviteData: Invite | null = null;
  loading = true;
  error: string | null = null;

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.loadInviteData();
  }

  private loadInviteData(): void {
    const inviteId = this.authService.getInviteId();

    if (!inviteId) {
      this.error = 'Aucun ID invité trouvé';
      this.loading = false;
      return;
    }

    const id = parseInt(inviteId, 10);
    if (isNaN(id)) {
      this.error = 'ID invité invalide';
      this.loading = false;
      return;
    }

    this.authService.getInviteDetails(id).subscribe({
      next: (data) => {
        this.inviteData = data;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Erreur lors du chargement des données';
        this.loading = false;
        console.error('Erreur:', err);
      }
    });
  }
}
