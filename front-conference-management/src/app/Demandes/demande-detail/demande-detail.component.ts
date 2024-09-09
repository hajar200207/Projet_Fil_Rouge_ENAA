import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DemandeService } from '../../services/demande.service';
import { DemandeDTO } from '../../DTO/demande-dto.model';

@Component({
  selector: 'app-demande-detail',
  templateUrl: './demande-detail.component.html',
  styleUrls: ['./demande-detail.component.css']
})
export class DemandeDetailComponent implements OnInit {
  demande: DemandeDTO | undefined;

  constructor(
    private route: ActivatedRoute,
    private demandeService: DemandeService
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.demandeService.getDemandeById(+id).subscribe(data => {
        this.demande = data;
      });
    }
  }
}
