export class ReservationDTO {
  inviteId!: number;
  conferenceId!: number;
  dateReservation!: string;
  countryOfResidence!: string;
  cityOfResidence!: string;
  registrationType!: string;
  status: string = 'PENDING';
}
