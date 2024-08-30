package com.conferencemgmt.conference_management.dto;

import com.conferencemgmt.conference_management.Enum.CityOfResidence;
import com.conferencemgmt.conference_management.Enum.CountryOfResidence;
import com.conferencemgmt.conference_management.Enum.RegistrationType;
import com.conferencemgmt.conference_management.Enum.ReservationStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateReservationDTO {

    private Long inviteId;
    private Long conferenceId;
    private LocalDate dateReservation;
    private ReservationStatus status;
    private CountryOfResidence countryOfResidence;
    private CityOfResidence cityOfResidence;
    private RegistrationType registrationType;
}
