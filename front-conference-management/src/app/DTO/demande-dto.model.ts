
export interface DemandeDTO {
  id?: number;
  conferencierId: number;
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
}
