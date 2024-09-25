import { Component, OnInit } from '@angular/core';

import { ActivatedRoute } from '@angular/router';
import {LocauxDTO} from "../../models/locaux.model";
import {LocauxService} from "../../services/locaux.service";

@Component({
  selector: 'app-locaux-management',
  templateUrl: './locaux-management.component.html',
  styleUrls: ['./locaux-management.component.css']
})
export class LocauxManagementComponent implements OnInit {
  locauxList: LocauxDTO[] = [];
  newLocaux: LocauxDTO = { id: null, type: 'LOCO', adresse: '', commitOrganisationId: 0 };
  editLocaux: LocauxDTO | null = null;

  constructor(private locauxService: LocauxService, private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      const commitOrganisationId = params['commitOrganisationId'];
      if (commitOrganisationId) {
        this.newLocaux.commitOrganisationId = +commitOrganisationId;
      }
    });
    this.getAllLocaux();
  }

  getAllLocaux() {
    this.locauxService.getAllLocaux().subscribe(data => {
      this.locauxList = data;
    });
  }

  addLocaux() {
    this.locauxService.createLocaux(this.newLocaux).subscribe(() => {
      this.getAllLocaux();
      this.newLocaux = { id: null, type: 'LOCO', adresse: '', commitOrganisationId: this.newLocaux.commitOrganisationId }; // Reset form
    });
  }

  editLocauxDetails(locaux: LocauxDTO) {
    this.editLocaux = { ...locaux };
  }

  updateLocaux() {
    if (this.editLocaux) {
      this.locauxService.updateLocaux(this.editLocaux.id!, this.editLocaux).subscribe(() => {
        this.getAllLocaux();
        this.editLocaux = null; // Reset edit form
      });
    }
  }

  deleteLocaux(id: number | null) {
    this.locauxService.deleteLocaux(id).subscribe(() => {
      this.getAllLocaux();
    });
  }
}
