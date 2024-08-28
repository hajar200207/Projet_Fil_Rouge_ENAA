package com.conferencemgmt.conference_management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "programme")
public class Programme{



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titre", nullable = false)
    private String titre;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "heure_debut", nullable = false)
    private LocalTime heureDebut;

    @Column(name = "heure_fin", nullable = false)
    private LocalTime heureFin;

    @Column(name = "salle", nullable = false)
    private String salle;

//    @ManyToOne
//    @JoinColumn(name = "conference_id")
//    private Conference conference;

    @ManyToOne
    @JoinColumn(name = "commit_organisation_id")
    private CommitOrganisation commitOrganisation;

    @ManyToOne
    @JoinColumn(name = "conferencier_id")
    private Conferencier conferencier;
}
