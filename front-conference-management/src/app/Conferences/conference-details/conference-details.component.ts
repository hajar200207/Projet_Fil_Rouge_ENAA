import {Component, OnInit} from '@angular/core';
import {ConferenceDetailsDTO} from "../../DTO/conference-details-dto";
import {ConferenceService} from "../../services/conference.service";

@Component({
  selector: 'app-conference-details',
  templateUrl: './conference-details.component.html',
  styleUrls: ['./conference-details.component.css']
})
export class ConferenceDetailsComponent implements OnInit {
  conferences: ConferenceDetailsDTO[] = [];

  constructor(private conferenceService: ConferenceService) { }

  ngOnInit(): void {
    this.conferenceService.getAllConferenceDetails().subscribe(data => {
      this.conferences = data;
    });
  }
}

