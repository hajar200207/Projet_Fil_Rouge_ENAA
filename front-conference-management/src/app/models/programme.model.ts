export interface ProgrammeDTO {
    id: number;
    programmeName: string;
    description: string;
    startDate: string;
    endDate: string;
    conferencierid: number;   // Foreign key reference to Conference
    conferencierName: string;  // Referencing the Conferencier's name
}
