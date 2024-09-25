export class ConferenceCreateDTO {
  id?: number;               // ID optionnel, peut être généré côté backend
  nom!: string;              // Nom de la conférence (obligatoire)
  description!: string;       // Description (obligatoire)
  theme!: string;            // Thème (obligatoire)
  imageUrl?: string;         // URL de l'image (optionnel)
  dateDebut!: string;        // Date de début (obligatoire)
  dateFin!: string;          // Date de fin (obligatoire)
  number_invite!: number;    // Nombre d'invités (obligatoire)
  subject!: string;          // Sujet de la conférence (obligatoire, string pour Enum)
  conferencierId!: number;   // ID du conférencier (obligatoire)
  locauxId!: number;         // ID des locaux (obligatoire)
}
