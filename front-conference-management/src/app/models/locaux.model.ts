export interface LocauxDTO {
  id: number | null;
  type: 'LOCO' | 'HOTEL' | 'AMPHI';
  adresse: string;
  commitOrganisationId: number;
}
