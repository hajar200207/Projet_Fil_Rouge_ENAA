package com.conferencemgmt.conference_management.dto;

import com.conferencemgmt.conference_management.Enum.ConferenceSubject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConferenceUpdateDTO {
    private String nom;
    private String description;
    private String theme;
    private String imageUrl;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Number number_invite;
    private ConferenceSubject subject;
    private Long conferencierId;
    private Long locauxId;
}

