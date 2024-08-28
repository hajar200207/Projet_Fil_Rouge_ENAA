package com.conferencemgmt.conference_management.dto;

import com.conferencemgmt.conference_management.Enum.ConferenceSubject;
import com.conferencemgmt.conference_management.model.Conferencier;
import com.conferencemgmt.conference_management.model.CommitOrganisation;
import com.conferencemgmt.conference_management.model.Conference;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProgrammeDTOall {
    private Long id;
    private String titre;
    private String description;
    private LocalDateTime heureDebut;
    private LocalDateTime heureFin;
    private LocalDateTime date;
    private String salle;

    // Relationships
    private Long conferenceId;
    private String conferenceNom;
    private String conferenceDescription;
    private String conferenceTheme;

    private Long commitOrganisationId;
    private String commitOrganisationNom;
    private String commitOrganisationFonction;

    private Long conferencierId;
    private String conferencierNom;
    private String conferencierPrenom;
    private String conferencierEmail;
    private String conferencierSpecialite;
}
