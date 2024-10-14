import {Demande} from "./demande.model";

export interface Conferencier {
  id: number;
  nom: string;
  prenom: string;
  email: string;
  motDePasse: string;
  specialite: string;
  biographie: string;
  demandes: Demande[];
//  slides: Slide[];
 // programmes: Programme[];
}
