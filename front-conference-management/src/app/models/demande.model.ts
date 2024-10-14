import {DemandeStatus} from "../Enum/DemandeStatus";

export class Demande {
  id: number;
  conferencierId: number;
  numberInvite: number;
  conferenceSubject: string;
  conferenceTitle: string;
  conferenceDescription: string;
  proposedDate: string;
  proposedStartTime: string;
  proposedEndTime: string;
  location: string;
  durationInMinutes: number;
  expectedAttendees: number;
  status: DemandeStatus;
  adminComments: string;
  submissionDate: string;

  constructor(
    id: number,
    conferencierId: number,
    numberInvite: number,
    conferenceSubject: string,
    conferenceTitle: string,
    conferenceDescription: string,
    proposedDate: string,
    proposedStartTime: string,
    proposedEndTime: string,
    location: string,
    durationInMinutes: number,
    expectedAttendees: number,
    status: DemandeStatus,
    adminComments: string,
    submissionDate: string
  ) {
    this.id = id;
    this.conferencierId = conferencierId;
    this.numberInvite = numberInvite;
    this.conferenceSubject = conferenceSubject;
    this.conferenceTitle = conferenceTitle;
    this.conferenceDescription = conferenceDescription;
    this.proposedDate = proposedDate;
    this.proposedStartTime = proposedStartTime;
    this.proposedEndTime = proposedEndTime;
    this.location = location;
    this.durationInMinutes = durationInMinutes;
    this.expectedAttendees = expectedAttendees;
    this.status = status;
    this.adminComments = adminComments;
    this.submissionDate = submissionDate;
  }
}
