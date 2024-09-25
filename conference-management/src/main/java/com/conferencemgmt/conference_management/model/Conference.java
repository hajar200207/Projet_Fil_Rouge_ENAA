package com.conferencemgmt.conference_management.model;

import com.conferencemgmt.conference_management.Enum.ConferenceSubject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Conference")
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
    private String theme;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "date_debut")
    private LocalDate dateDebut;
    @Column(name = "number_invite")
     private  Number number_invite;
    @Column(name = "date_fin")
    private LocalDate dateFin;
    @Enumerated(EnumType.STRING)
    @Column(name = "subject")
    private ConferenceSubject subject;
    @JsonIgnore  // Ignore cette relation lors de la sérialisation JSON pour éviter l'imbrication

    @ManyToOne
    @JoinColumn(name = "conferencier_id ")
    private Conferencier conferencier;
    @JsonIgnore  // Ignore cette relation lors de la sérialisation JSON pour éviter l'imbrication

    @ManyToOne
    @JoinColumn(name = "locaux_id")
    private Locaux locaux;
    @JsonIgnore  // Ignore cette relation lors de la sérialisation JSON pour éviter l'imbrication

    @ManyToMany
    @JoinTable(
            name = "conference_commitorganisation",
            joinColumns = @JoinColumn(name = "conference_id"),
            inverseJoinColumns = @JoinColumn(name = "commitorganisation_id")
    )
    private Set<CommitOrganisation> commitOrganisations = new HashSet<>();
    @JsonIgnore  // Ignore cette relation lors de la sérialisation JSON pour éviter l'imbrication

    @ManyToMany
    @JoinTable(
            name = "conference_invite",
            joinColumns = @JoinColumn(name = "conference_id"),
            inverseJoinColumns = @JoinColumn(name = "invite_id")
    )

    private Set<Invite> invites = new HashSet<>();
    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;
    @JsonIgnore  // Ignore cette relation lors de la sérialisation JSON pour éviter l'imbrication

    @ManyToMany
    private Set<Slide> slides = new HashSet<>();

    @JsonIgnore  // Ignore cette relation lors de la sérialisation JSON pour éviter l'imbrication

    @ManyToMany
    @JoinTable(
            name = "conference_posters",
            joinColumns = @JoinColumn(name = "conference_id"),
            inverseJoinColumns = @JoinColumn(name = "poster_id")
    )
    private Set<Poster> posters = new HashSet<>();





}
