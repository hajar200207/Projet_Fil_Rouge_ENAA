package com.conferencemgmt.conference_management.model;

import com.conferencemgmt.conference_management.Enum.EtatArticle;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Articles")
public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String contenu;

    @Enumerated(EnumType.STRING)
    private EtatArticle etat;

    @ManyToOne
    @JoinColumn(name = "commit_scientifique_id", referencedColumnName = "id")
    private CommitScientifique commitScientifique;
}
