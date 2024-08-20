package com.conferencemgmt.conference_management.model;

import com.conferencemgmt.conference_management.Enum.ConferenceSubject;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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

    @Column(name = "date_fin")
    private LocalDate dateFin;
    @Enumerated(EnumType.STRING)
    @Column(name = "subject")
    private ConferenceSubject subject;
    @ManyToOne
    @JoinColumn(name = "conferencier_id", referencedColumnName = "id")
    private Conferencier conferencier;

    @OneToOne
    @JoinColumn(name = "locaux_id", referencedColumnName = "id")
    private Locaux locaux;

    @OneToMany(mappedBy = "conference")
    private List<Slide> slides;

    @OneToMany(mappedBy = "conference")
    private List<Poster> posters;

    @OneToMany(mappedBy = "conference")
    private List<Programme> programmes;
    @ManyToMany
    @JoinTable(
            name = "conference_commitorganisation",
            joinColumns = @JoinColumn(name = "conference_id"),
            inverseJoinColumns = @JoinColumn(name = "commitorganisation_id")
    )
    private List<CommitOrganisation> commitOrganisations;

    @ManyToMany
    @JoinTable(
            name = "conference_invite",
            joinColumns = @JoinColumn(name = "conference_id"),
            inverseJoinColumns = @JoinColumn(name = "invite_id")
    )
    private List<Invite> invites;

    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;

}
