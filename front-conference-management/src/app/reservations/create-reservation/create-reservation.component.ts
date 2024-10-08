import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { EnumService } from "../../services/EnumService";
import { ReservationService } from "../../services/ReservationService"; // Import ReservationService
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-create-reservation',
  templateUrl: './create-reservation.component.html',
  styleUrls: ['./create-reservation.component.css']
})
export class CreateReservationComponent implements OnInit {
  reservationForm!: FormGroup;
  statusOptions: string[] = [];
  registrationTypes: string[] = [];
  countries: string[] = [];
  cities: string[] = [];

  constructor(
    private fb: FormBuilder,
    private enumService: EnumService,
    private reservationService: ReservationService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.reservationForm = this.fb.group({
      inviteId: [''],
      conferenceId: [''],
      dateReservation: [''],
      status: [''],
      registrationType: [''],
      countryOfResidence: [''],
      cityOfResidence: ['']
    });

    // Get the conferenceId from query parameters
    this.route.queryParams.subscribe(params => {
      const conferenceId = params['conferenceId'];
      if (conferenceId) {
        this.reservationForm.patchValue({ conferenceId });
      }
    });

    this.enumService.getReservationStatuses().subscribe(data => this.statusOptions = data);
    this.enumService.getRegistrationTypes().subscribe(data => this.registrationTypes = data);
    this.enumService.getCountries().subscribe(data => this.countries = data);
    this.enumService.getCities().subscribe(data => this.cities = data);
  }

  onSubmit(): void {
    console.log(this.reservationForm.value);

    this.reservationService.createReservation(this.reservationForm.value).subscribe(
      response => {
        console.log('Reservation created successfully:', response);
      },
      error => {
        console.error('Error creating reservation:', error);
      }
    );
  }
}
