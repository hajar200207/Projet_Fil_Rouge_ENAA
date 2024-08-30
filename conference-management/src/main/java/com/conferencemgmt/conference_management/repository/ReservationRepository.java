package com.conferencemgmt.conference_management.repository;

import com.conferencemgmt.conference_management.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}

