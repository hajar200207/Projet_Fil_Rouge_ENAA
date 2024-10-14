export class ConferenceCreateDTO {
  id?: number;
  nom!: string;
  description!: string;
  theme!: string;
  imageUrl?: string;
  dateDebut!: string;
  dateFin!: string;
  number_invite!: number;
  subject!: string;
  conferencierId!: number;
  locauxId!: number;         
}
