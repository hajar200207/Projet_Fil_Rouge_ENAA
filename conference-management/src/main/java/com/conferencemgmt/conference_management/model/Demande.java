package com.conferencemgmt.conference_management.model;

import com.conferencemgmt.conference_management.Enum.ConferenceSubject;
import com.conferencemgmt.conference_management.Enum.DemandeStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@Entity
@Table(name = "demande")
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conferencier_id")
    private Conferencier conferencier;
    @Enumerated(EnumType.STRING)
    @Column(name = "conference_subject", nullable = false)
    private ConferenceSubject conferenceSubject;

    @Column(name = "conference_title", nullable = false)
    private String conferenceTitle;

    @Column(name = "conference_description", nullable = false)
    private String conferenceDescription;

    @Column(name = "proposed_date", nullable = false)
    private LocalDate proposedDate;

    @Column(name = "proposed_start_time", nullable = false)
    private LocalTime proposedStartTime;

    @Column(name = "proposed_end_time", nullable = false)
    private LocalTime proposedEndTime;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "duration_in_minutes", nullable = false)
    private int durationInMinutes;

    @Column(name = "expected_attendees", nullable = false)
    private int expectedAttendees;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private DemandeStatus status;

    @Column(name = "admin_comments")
    private String adminComments;

    @Column(name = "submission_date", nullable = false)
    private LocalDate submissionDate;
}
