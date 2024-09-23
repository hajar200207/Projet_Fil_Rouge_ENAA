import {Demande} from "./demande.model";

export interface Conferencier {
  id: number;
  nom: string;
  prenom: string;
  email: string;
  motDePasse: string;
  specialite: string;
  biographie: string;
  demandes: Demande[];  // Assuming 'Demande' is another model for demand requests
//  slides: Slide[];      // Assuming 'Slide' is another model for presentations or files
 // programmes: Programme[]; // Assuming 'Programme' is another model for schedules or programs
}
