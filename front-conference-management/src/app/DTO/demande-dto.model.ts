
export interface DemandeDTO {
  id?: number;
  conferencierId: number;
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
}
