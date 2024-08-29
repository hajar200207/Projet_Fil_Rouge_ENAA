package com.conferencemgmt.conference_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PosterCreateDTO {
    private String titre;
    private String description;
    private String imageUrl;
    private Long conferenceId;
    private Long commitOrganisationId;
}
