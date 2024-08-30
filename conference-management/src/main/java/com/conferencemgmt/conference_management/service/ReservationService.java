package com.conferencemgmt.conference_management.service;

import com.conferencemgmt.conference_management.dto.CreateReservationDTO;
import com.conferencemgmt.conference_management.dto.ReservationInfoDTO;
import com.conferencemgmt.conference_management.model.Conference;
import com.conferencemgmt.conference_management.model.Invite;
import com.conferencemgmt.conference_management.model.Reservation;
import com.conferencemgmt.conference_management.repository.InviteRepository;
import com.conferencemgmt.conference_management.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private InviteRepository inviteRepository;
    @Autowired
    private ConferenceService conferenceService;
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long id, CreateReservationDTO reservationDetails) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with id " + id));

        // Fetch related entities using IDs
        Invite invite = inviteRepository.getInviteById(reservationDetails.getInviteId());

        Conference conference = conferenceService.getConferenceById(reservationDetails.getConferenceId())
                .orElseThrow(() -> new RuntimeException("Conference not found with id " + reservationDetails.getConferenceId()));

        // Update reservation details
        reservation.setInvite(invite);
        reservation.setConference(conference);
        reservation.setDateReservation(reservationDetails.getDateReservation());
        reservation.setStatus(reservationDetails.getStatus());
        reservation.setCountryOfResidence(reservationDetails.getCountryOfResidence());
        reservation.setCityOfResidence(reservationDetails.getCityOfResidence());
        reservation.setRegistrationType(reservationDetails.getRegistrationType());

        return reservationRepository.save(reservation);
    }


    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
    public ReservationInfoDTO convertToReservationInfoDTO(Reservation reservation) {
        ReservationInfoDTO dto = new ReservationInfoDTO();

        dto.setReservationId(reservation.getId());
        dto.setDateReservation(reservation.getDateReservation());
        dto.setStatus(String.valueOf(reservation.getStatus()));
        dto.setCountryOfResidence(String.valueOf(reservation.getCountryOfResidence()));
        dto.setCityOfResidence(String.valueOf(reservation.getCityOfResidence()));
        dto.setRegistrationType(String.valueOf(reservation.getRegistrationType()));

        Invite invite = reservation.getInvite();
        dto.setInviteId(invite.getId());
        dto.setInviteName(invite.getUsername());
        dto.setInviteEmail(invite.getEmail());

        Conference conference = reservation.getConference();
        dto.setConferenceId(conference.getId());
        dto.setConferenceTitle(conference.getNom());
        dto.setConferenceDescription(conference.getDescription());
        dto.setConferenceDate(conference.getDateDebut());

        return dto;
    }
    public List<ReservationInfoDTO> getAllinfoReservations() {
        List<Reservation> reservations = reservationRepository.findAll();

        return reservations.stream()
                .map(this::convertToReservationInfoDTO)
                .collect(Collectors.toList());
    }
    public List<ReservationInfoDTO> getReservationsByInvite(Long inviteId) {
        return reservationRepository.findByInviteId(inviteId).stream()
                .map(reservation -> {
                    ReservationInfoDTO dto = new ReservationInfoDTO();
                    dto.setReservationId(reservation.getId());
                    dto.setInviteId(reservation.getInvite().getId());
                    dto.setConferenceId(reservation.getConference().getId());
                    dto.setDateReservation(reservation.getDateReservation());
                    dto.setStatus(String.valueOf(reservation.getStatus()));
                    dto.setCountryOfResidence(String.valueOf(reservation.getCountryOfResidence()));
                    dto.setCityOfResidence(String.valueOf(reservation.getCityOfResidence()));
                    dto.setRegistrationType(String.valueOf(reservation.getRegistrationType()));
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
