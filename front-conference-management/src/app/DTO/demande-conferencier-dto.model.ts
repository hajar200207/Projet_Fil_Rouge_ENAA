// demande-conferencier-dto.model.ts
export interface DemandeConferencierDTO {
  demandeId: number;
  number_invite: number;
  conferenceSubject: string;
  conferenceTitle: string;
  conferenceDescription: string;
  proposedDate: string; // or Date type
  proposedStartTime: string; // or Time type
  proposedEndTime: string; // or Time type
  location: string;
  durationInMinutes: number;
  expectedAttendees: number;
  status: string;
  adminComments?: string;
  submissionDate: string; // or Date type

  // Conferencier Details
  conferencierId: number;
  conferencierNom: string;
  conferencierPrenom: string;
  conferencierEmail: string;
  conferencierSpecialite: string;
}
