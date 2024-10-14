
export interface DemandeConferencierDTO {
  demandeId: number;
  number_invite: number;
  conferenceSubject: string;
  conferenceTitle: string;
  conferenceDescription: string;
  proposedDate: string;
  proposedStartTime: string;
  proposedEndTime: string;
  location: string;
  durationInMinutes: number;
  expectedAttendees: number;
  status: string;
  adminComments?: string;
  submissionDate: string;


  conferencierId: number;
  conferencierNom: string;
  conferencierPrenom: string;
  conferencierEmail: string;
  conferencierSpecialite: string;
}
