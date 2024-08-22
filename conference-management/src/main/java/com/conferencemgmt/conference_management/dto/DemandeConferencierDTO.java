package com.conferencemgmt.conference_management.dto;

import com.conferencemgmt.conference_management.Enum.ConferenceSubject;
import com.conferencemgmt.conference_management.Enum.DemandeStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class DemandeConferencierDTO {
    private Long demandeId;
    private  Long number_invite;

    private ConferenceSubject conferenceSubject;
    private String conferenceTitle;
    private String conferenceDescription;
    private LocalDate proposedDate;
    private LocalTime proposedStartTime;
    private LocalTime proposedEndTime;
    private String location;
    private int durationInMinutes;
    private int expectedAttendees;
    private DemandeStatus status;
    private String adminComments;
    private LocalDate submissionDate;

    // Conferencier Details
    private Long conferencierId;
    private String conferencierNom;
    private String conferencierPrenom;
    private String conferencierEmail;
    private String conferencierSpecialite;
}
