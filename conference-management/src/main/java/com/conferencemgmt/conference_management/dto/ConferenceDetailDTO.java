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
public class ConferenceDetailDTO {
    private Long id;
    private String nom;
    private String description;
    private String theme;
    private String imageUrl;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private ConferenceSubject subject;
    private Long conferencierId;
    private Long locauxId;
    private List<SlideDTO> slides;
    private List<InviteDTO> invites;
    private List<PosterDTO> posters;
    private List<CommitOrganisationDTO> commitOrganisations;
    private Number numberInvite;
}
