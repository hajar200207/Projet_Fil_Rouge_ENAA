import { Component, OnInit } from '@angular/core';
import { DemandeService } from '../../services/demande.service';
import { Router } from '@angular/router';
import {Demande} from "../../models/demande.model";

@Component({
  selector: 'app-demande-list',
  templateUrl: './demande-list.component.html',
  styleUrls: ['./demande-list.component.css']
})
export class DemandeListComponent implements OnInit {
  demandes: any[] = [];

  constructor(private demandeService: DemandeService, private router: Router) {}

  ngOnInit(): void {
    this.loadDemandes();
  }

  loadDemandes(): void {
    this.demandeService.getAllDemandes().subscribe(data => {
      this.demandes = data;
    });
  }

  viewDetail(id: number): void {
    this.router.navigate(['/demandes', id]);
  }

  editDemande(id: number): void {
    this.router.navigate(['/demandes', id, 'edit']);
  }

  deleteDemande(id: number): void {
    this.demandeService.deleteDemande(id).subscribe(() => {
      this.loadDemandes(); // Reload the list after deletion
    });
  }
}
