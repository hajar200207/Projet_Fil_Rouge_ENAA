package com.conferencemgmt.conference_management.dto;

import com.conferencemgmt.conference_management.Enum.ConferenceSubject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConferencecreategDTO {
    private String nom;
    private String description;
    private String theme;
    private String imageUrl;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private ConferenceSubject subject;
    private Long conferencierId;
    private Long locauxId;
    private List<Long> commitOrganisationIds;
    private List<Long> inviteIds;
    private List<Long> slideIds;
    private List<Long> posterIds;
    private Number number_invite;
}
