package com.conferencemgmt.conference_management.dto;


import com.conferencemgmt.conference_management.Enum.ConferenceSubject;
import com.conferencemgmt.conference_management.Enum.DemandeStatus;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DemandeDTO {
    private Long id;
    private Long conferencierId;
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
}
