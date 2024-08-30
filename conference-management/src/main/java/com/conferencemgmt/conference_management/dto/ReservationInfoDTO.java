package com.conferencemgmt.conference_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationInfoDTO {
    private Long reservationId;
    private LocalDate dateReservation;
    private String status;
    private String countryOfResidence;
    private String cityOfResidence;
    private String registrationType;

    private Long inviteId;
    private String inviteName;
    private String inviteEmail;

    private Long conferenceId;
    private String conferenceTitle;
    private String conferenceDescription;
    private LocalDate conferenceDate;




}