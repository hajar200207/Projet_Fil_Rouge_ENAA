package com.conferencemgmt.conference_management.controller;

import com.conferencemgmt.conference_management.dto.CreateReservationDTO;
import com.conferencemgmt.conference_management.dto.ReservationInfoDTO;
import com.conferencemgmt.conference_management.model.Conference;
import com.conferencemgmt.conference_management.model.Invite;
import com.conferencemgmt.conference_management.model.Reservation;
import com.conferencemgmt.conference_management.repository.InviteRepository;
import com.conferencemgmt.conference_management.service.ConferenceService;
import com.conferencemgmt.conference_management.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
@Autowired
private InviteRepository inviteRepository;
@Autowired
private ConferenceService conferenceService;
    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Reservation reservation = reservationService.getReservationById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with id " + id));
        return ResponseEntity.ok(reservation);
    }

    @PostMapping("/create")
    public ResponseEntity<Reservation> createReservation(@RequestBody CreateReservationDTO reservationDTO) {
        // Fetch the invite and conference by their IDs
        Invite invite = inviteRepository.getInviteById(reservationDTO.getInviteId());
        Optional<Conference> conferenceOptional = conferenceService.getConferenceById(reservationDTO.getConferenceId());

        if (conferenceOptional.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        Conference conference = conferenceOptional.get();

        Reservation reservation = new Reservation();
        reservation.setInvite(invite);
        reservation.setConference(conference);
        reservation.setDateReservation(reservationDTO.getDateReservation());
        reservation.setStatus(reservationDTO.getStatus());
        reservation.setCountryOfResidence(reservationDTO.getCountryOfResidence());
        reservation.setCityOfResidence(reservationDTO.getCityOfResidence());
        reservation.setRegistrationType(reservationDTO.getRegistrationType());

        Reservation savedReservation = reservationService.saveReservation(reservation);

        return ResponseEntity.ok(savedReservation);
    }
    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestBody CreateReservationDTO reservationDetails) {
        return reservationService.updateReservation(id, reservationDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/all")
    public List<ReservationInfoDTO> getAllinfoReservations() {
        return reservationService.getAllinfoReservations();
    }
}
