package com.conferencemgmt.conference_management.model;

import com.conferencemgmt.conference_management.Enum.TypeLocaux;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    @OneToMany(mappedBy = "locaux")
    private List<Conference> conferences;
    @ManyToOne
    @JoinColumn(name = "commit_organisation_id")
    private CommitOrganisation commitOrganisation;
}
