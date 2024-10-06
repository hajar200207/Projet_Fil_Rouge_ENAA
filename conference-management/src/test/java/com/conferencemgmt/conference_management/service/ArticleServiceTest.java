//package com.conferencemgmt.conference_management.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//import com.conferencemgmt.conference_management.dto.CreateReservationDTO;
//import com.conferencemgmt.conference_management.dto.ReservationInfoDTO;
//import com.conferencemgmt.conference_management.model.Conference;
//import com.conferencemgmt.conference_management.model.Invite;
//import com.conferencemgmt.conference_management.model.Reservation;
//import com.conferencemgmt.conference_management.repository.InviteRepository;
//import com.conferencemgmt.conference_management.repository.ReservationRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class ReservationServiceTest {
//
//    @Mock
//    private ReservationRepository reservationRepository;
//
//    @Mock
//    private InviteRepository inviteRepository;
//
//    @Mock
//    private ConferenceService conferenceService;
//
//    @InjectMocks
//    private ReservationService reservationService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void testGetAllReservations() {
//        Reservation reservation = new Reservation();
//        when(reservationRepository.findAll()).thenReturn(Arrays.asList(reservation));
//
//        List<Reservation> reservations = reservationService.getAllReservations();
//
//        assertEquals(1, reservations.size());
//        verify(reservationRepository, times(1)).findAll();
//    }
//
//    @Test
//    void testGetReservationById() {
//        Long id = 1L;
//        Reservation reservation = new Reservation();
//        when(reservationRepository.findById(id)).thenReturn(Optional.of(reservation));
//
//        Optional<Reservation> result = reservationService.getReservationById(id);
//
//        assertTrue(result.isPresent());
//        assertEquals(reservation, result.get());
//        verify(reservationRepository, times(1)).findById(id);
//    }
//
//    @Test
//    void testSaveReservation() {
//        Reservation reservation = new Reservation();
//        when(reservationRepository.save(reservation)).thenReturn(reservation);
//
//        Reservation savedReservation = reservationService.saveReservation(reservation);
//
//        assertNotNull(savedReservation);
//        assertEquals(reservation, savedReservation);
//        verify(reservationRepository, times(1)).save(reservation);
//    }
//
//    @Test
//    void testUpdateReservation() {
//        Long reservationId = 1L;
//        CreateReservationDTO reservationDetails = new CreateReservationDTO();
//        reservationDetails.setInviteId(2L);
//        reservationDetails.setConferenceId(3L);
//
//        Reservation existingReservation = new Reservation();
//        Invite invite = new Invite();
//        invite.setId(2L);
//        Conference conference = new Conference();
//        conference.setId(3L);
//
//        when(reservationRepository.findById(reservationId)).thenReturn(Optional.of(existingReservation));
//        when(inviteRepository.getInviteById(2L)).thenReturn(invite);
//        when(conferenceService.getConferenceById(3L)).thenReturn(Optional.of(conference));
//        when(reservationRepository.save(existingReservation)).thenReturn(existingReservation);
//
//        Reservation updatedReservation = reservationService.updateReservation(reservationId, reservationDetails);
//
//        assertNotNull(updatedReservation);
//        assertEquals(invite, updatedReservation.getInvite());
//        assertEquals(conference, updatedReservation.getConference());
//        verify(reservationRepository, times(1)).findById(reservationId);
//        verify(reservationRepository, times(1)).save(existingReservation);
//    }
//
//    @Test
//    void testDeleteReservation() {
//        Long id = 1L;
//        doNothing().when(reservationRepository).deleteById(id);
//
//        reservationService.deleteReservation(id);
//
//        verify(reservationRepository, times(1)).deleteById(id);
//    }
//
//
//}
