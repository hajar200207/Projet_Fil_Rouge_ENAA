import {Component, OnInit} from '@angular/core';
import {ConferenceDetailsDTO} from "../../DTO/conference-details-dto";
import {ConferenceService} from "../../services/conference.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-conference-details',
  templateUrl: './conference-details.component.html',
  styleUrls: ['./conference-details.component.css']
})
export class ConferenceDetailsComponent implements OnInit {
  conferences: ConferenceDetailsDTO[] = [];

  constructor(private conferenceService: ConferenceService, private router: Router  ) { }

  ngOnInit(): void {
    this.conferenceService.getAllConferenceDetails().subscribe(data => {
      this.conferences = data;
    });
  }
  openReservationForm(conferenceId: number): void {
    this.router.navigate(['/create-reservation'], { queryParams: { conferenceId } });
  }

}

