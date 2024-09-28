import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ProgrammeService } from '../../services/programme.service';

@Component({
  selector: 'app-add-programme',
  templateUrl: './add-programme.component.html'
})
export class AddProgrammeComponent implements OnInit {
  programmeForm!: FormGroup;  // Add definite assignment assertion (!)
  conferencierid!: string;  // Add definite assignment assertion (!)

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private programmeService: ProgrammeService
  ) {}

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.conferencierid = params['conferencierid'] || '';  // Provide fallback
    });

    // Initialize the form
    this.programmeForm = this.fb.group({
      titre: ['', Validators.required],
      description: ['', Validators.required],
      date: ['', Validators.required],
      heureDebut: ['', Validators.required],
      heureFin: ['', Validators.required],
      salle: ['', Validators.required],
      conferencierid: [this.conferencierid, Validators.required], // Hidden field
    });
  }

  // Submit the form to create a new program
  onSubmit() {
    if (this.programmeForm.valid) {
      this.programmeService.createProgramme(this.programmeForm.value).subscribe(response => {
      });
    }
  }
}
