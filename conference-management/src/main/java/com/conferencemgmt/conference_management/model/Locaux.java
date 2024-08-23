package com.conferencemgmt.conference_management.model;

import com.conferencemgmt.conference_management.Enum.TypeLocaux;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Locaux")
public class Locaux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeLocaux type;

    private String adresse;

    @ManyToOne
    @JoinColumn(name = "commit_organisation_id")
    private CommitOrganisation commitOrganisation;
}
