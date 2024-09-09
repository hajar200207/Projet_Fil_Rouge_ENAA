import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DemandeService } from '../../services/demande.service';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from "../../services/auth.service";

@Component({
  selector: 'app-demande-form',
  templateUrl: './demande-form.component.html',
  styleUrls: ['./demande-form.component.css']
})
export class DemandeFormComponent implements OnInit {
  demandeForm: FormGroup;
  isEditing = false;
  statuses = ['PENDING', 'ACCEPTED', 'REFUSED'];

  constructor(
    private fb: FormBuilder,
    private demandeService: DemandeService,
    private router: Router,
    private route: ActivatedRoute,
    private authService: AuthService
  ) {
    this.demandeForm = this.fb.group({
      conferenceTitle: ['', Validators.required],
      conferenceSubject: ['', Validators.required],
      number_invite: [0, Validators.required],
      proposedDate: ['', Validators.required],
      proposedStartTime: ['', Validators.required],
      proposedEndTime: ['', Validators.required],
      location: ['', Validators.required],
      durationInMinutes: [0, Validators.required],
      expectedAttendees: [0, Validators.required],
      status: ['', Validators.required],
      adminComments: [''],
      submissionDate: ['', Validators.required],
      conferencierId: [this.authService. getConferencierId()]
    });
  }

  ngOnInit(): void {
    const demandeId = +this.route.snapshot.paramMap.get('id')!;
    if (demandeId) {
      this.isEditing = true;
      this.demandeService.getDemandeById(demandeId).subscribe(demande => {
        this.demandeForm.patchValue(demande);
      });
    }
  }

  onSubmit(): void {
    console.log(this.demandeForm.value); // Log the form values to check if conferencierId is set

    if (this.isEditing) {
      const demandeId = +this.route.snapshot.paramMap.get('id')!;
      this.demandeService.updateDemande(demandeId, this.demandeForm.value).subscribe(() => {
        this.router.navigate(['/dashboard']);
      });
    } else {
      this.demandeService.createDemande(this.demandeForm.value).subscribe(() => {
        this.router.navigate(['/dashboard']);
      });
    }
  }


}
