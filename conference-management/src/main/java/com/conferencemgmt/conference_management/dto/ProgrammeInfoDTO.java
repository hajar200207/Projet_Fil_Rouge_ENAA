package com.conferencemgmt.conference_management.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class ProgrammeInfoDTO {
    private Long programmeId;
    private String titre;
    private String description;
    private LocalDate date;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private String salle;

    // Commit Organisation details
    private Long commitOrganisationId;
    private String commitOrganisationNom;
    private String commitOrganisationPrenom;
    private String commitOrganisationEmail;
    private String commitOrganisationFonction;

    // Conferencier details
    private Long conferencierId;
    private String conferencierNom;
    private String conferencierPrenom;
    private String conferencierEmail;
    private String conferencierSpecialite;
}
