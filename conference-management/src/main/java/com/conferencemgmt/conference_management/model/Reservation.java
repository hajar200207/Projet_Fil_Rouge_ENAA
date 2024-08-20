package com.conferencemgmt.conference_management.model;


import com.conferencemgmt.conference_management.Enum.CityOfResidence;
import com.conferencemgmt.conference_management.Enum.CountryOfResidence;
import com.conferencemgmt.conference_management.Enum.RegistrationType;
import com.conferencemgmt.conference_management.Enum.ReservationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "invite_id", referencedColumnName = "id")
    private Invite invite;

    @ManyToOne
    @JoinColumn(name = "conference_id", referencedColumnName = "id")
    private Conference conference;

    @Column(name = "date_reservation")
    private LocalDate dateReservation;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "country_of_residence")
    private CountryOfResidence countryOfResidence;

    @Enumerated(EnumType.STRING)
    @Column(name = "city_of_residence")
    private CityOfResidence cityOfResidence;

    @Enumerated(EnumType.STRING)
    @Column(name = "registration_type")
    private RegistrationType registrationType;


}
