package com.conferencemgmt.conference_management.dto;

import com.conferencemgmt.conference_management.Enum.TypeLocaux;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocauxDTO {
    private Long id;
    private TypeLocaux type;
    private String adresse;
    private Long commitOrganisationId;
}
