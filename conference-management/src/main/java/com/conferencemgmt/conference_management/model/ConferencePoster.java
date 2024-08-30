package com.conferencemgmt.conference_management.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ConferencePoster")
public class ConferencePoster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conference_id", referencedColumnName = "id")
    private Conference conference;

    @ManyToOne
    @JoinColumn(name = "poster_id", referencedColumnName = "id")
    private Poster poster;

}

