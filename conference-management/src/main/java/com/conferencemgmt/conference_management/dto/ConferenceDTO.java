package com.conferencemgmt.conference_management.dto;

import com.conferencemgmt.conference_management.Enum.ConferenceSubject;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ConferenceDTO {
    private Long id;
    private String nom;
    private String description;
    private String theme;
    private String imageUrl;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Number number_invite;
    private ConferenceSubject subject;

    private Long locauxId;
    private Long conferencierId;
}
