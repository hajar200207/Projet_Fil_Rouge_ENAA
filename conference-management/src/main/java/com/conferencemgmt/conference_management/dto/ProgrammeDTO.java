package com.conferencemgmt.conference_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammeDTO {
    private Long id;
    private String titre;
    private String description;
    private LocalDate date;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private String salle;
    private Long commitOrganisationId;
    private Long conferencierid;
    private Long conferenceId;

}