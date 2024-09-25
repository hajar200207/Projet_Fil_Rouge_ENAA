import { Component } from '@angular/core';
import { Router } from "@angular/router";

@Component({
  selector: 'app-commit-organisation-dashboard',
  templateUrl: './commit-organisation-dashboard.component.html',
  styleUrls: ['./commit-organisation-dashboard.component.css']
})
export class CommitOrganisationDashboardComponent {
  commitOrganisationId: string | null;

  constructor(private router: Router) {
    this.commitOrganisationId = localStorage.getItem('commitOrganisationId');
  }

  navigateToAddLocaux() {
    if (this.commitOrganisationId) {
      this.router.navigate(['/locaux'], { queryParams: { commitOrganisationId: this.commitOrganisationId } });
    } else {
      console.error('Commit Organisation ID is not set.');
    }
  }
}
