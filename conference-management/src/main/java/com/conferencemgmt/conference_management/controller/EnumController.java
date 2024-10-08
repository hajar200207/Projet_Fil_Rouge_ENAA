package com.conferencemgmt.conference_management.controller;

import com.conferencemgmt.conference_management.Enum.CityOfResidence;
import com.conferencemgmt.conference_management.Enum.CountryOfResidence;
import com.conferencemgmt.conference_management.Enum.RegistrationType;
import com.conferencemgmt.conference_management.Enum.ReservationStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/enums")
public class EnumController {

    @GetMapping("/reservation-status")
    public ReservationStatus[] getReservationStatuses() {
        return ReservationStatus.values();
    }

    @GetMapping("/registration-types")
    public RegistrationType[] getRegistrationTypes() {
        return RegistrationType.values();
    }

    @GetMapping("/countries")
    public CountryOfResidence[] getCountries() {
        return CountryOfResidence.values();
    }

    @GetMapping("/cities")
    public CityOfResidence[] getCities() {
        return CityOfResidence.values();
    }
}

