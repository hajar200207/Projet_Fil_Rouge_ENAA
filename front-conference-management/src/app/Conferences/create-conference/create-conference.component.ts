import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ConferenceService } from '../../services/conference.service';
import { ConferenceCreateDTO } from "../../DTO/Conference-Create-dto.model";
import { ConferenceSubject } from "../../Enum/conference-subject.enum";

@Component({
  selector: 'app-create-conference',
  templateUrl: './create-conference.component.html',
  styleUrls: ['./create-conference.component.css']
})
export class CreateConferenceComponent implements OnInit {
  conferenceCreateDTO: ConferenceCreateDTO = new ConferenceCreateDTO();
  subjects = Object.values(ConferenceSubject);
  conferencierId: number | null = null;

  constructor(
    private conferenceService: ConferenceService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.conferencierId = +params['conferencierId'] || null;
      console.log('Received conferencierId from query params:', this.conferencierId);
      if (this.conferencierId) {
        this.conferenceCreateDTO.conferencierId = this.conferencierId;
      } else {
        console.warn('Conferencier ID not found.');
      }
    });
  }



  createConference(): void {
    this.conferenceService.createConference(this.conferenceCreateDTO).subscribe(
      response => {
        console.log('Conference created successfully', response);
      },
      error => {
        console.error('Error creating conference', error);
      }
    );
  }
}
