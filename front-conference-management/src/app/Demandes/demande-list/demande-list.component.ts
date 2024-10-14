import { Component, Input, OnInit } from '@angular/core';
import { DemandeService } from '../../services/demande.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-demande-list',
  templateUrl: './demande-list.component.html',
  styleUrls: ['./demande-list.component.css']
})
export class DemandeListComponent implements OnInit {
  demandes: any[] = [];
  @Input() conferencierId!: number | null;

  constructor(private demandeService: DemandeService, private router: Router) {}

  ngOnInit(): void {
    this.loadDemandes();
  }

  loadDemandes(): void {
    this.demandeService.getAllDemandes().subscribe(data => {
      this.demandes = data;
    });
  }


  createConference(conferencierId: number): void {
    console.log('Navigating to create conference with conferencierId:', conferencierId);
    this.router.navigate(['/create-conference'], { queryParams: { conferencierId } });

  }


  editDemande(id: number): void {
    this.router.navigate(['/demandes', id, 'edit']);
  }

  deleteDemande(id: number): void {
    this.demandeService.deleteDemande(id).subscribe(() => {
      this.loadDemandes(); // Reload the list after deletion
    });
  }
  viewDetail(id: number): void {
    this.router.navigate(['/demandes', id]);
  }


}
