package com.conferencemgmt.conference_management.model;

import com.conferencemgmt.conference_management.Enum.DocumentType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Slide")
public class Slide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "abstract")
    private String abstractContent;

    @Column(name = "keyphrases")
    private String keyphrases;

    @Enumerated(EnumType.STRING)
    @Column(name = "document_type")
    private DocumentType documentType;

    @Column(name = "document_url")
    private String documentUrl;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Conferencier author;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "conference_id", referencedColumnName = "id")
    private Conference conference;
}

