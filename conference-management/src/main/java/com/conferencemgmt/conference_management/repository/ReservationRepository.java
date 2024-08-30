package com.conferencemgmt.conference_management.repository;

import com.conferencemgmt.conference_management.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByInviteId(Long inviteId);
}

