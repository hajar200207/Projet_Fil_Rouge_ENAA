//package com.conferencemgmt.conference_management.service;
//
//import com.conferencemgmt.conference_management.dto.ConferenceCreateDTO;
//import com.conferencemgmt.conference_management.model.Conference;
//import com.conferencemgmt.conference_management.model.Conferencier;
//import com.conferencemgmt.conference_management.model.Locaux;
//import com.conferencemgmt.conference_management.repository.ConferenceRepository;
//import com.conferencemgmt.conference_management.repository.ConferencierRepository;
//import com.conferencemgmt.conference_management.repository.LocauxRepository;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Optional;
//
//class ConferenceServiceTest {
//
//    @Mock
//    private ConferencierRepository conferencierRepository;
//
//    @Mock
//    private LocauxRepository locauxRepository;
//
//    @Mock
//    private ConferenceRepository conferenceRepository;
//
//    @InjectMocks
//    private ConferenceService conferenceService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testCreateConference() {
//        ConferenceCreateDTO dto = new ConferenceCreateDTO();
//        dto.setNom("Conference Example");
//        dto.setDescription("Description Example");
//        dto.setConferencierId(1L);
//        dto.setLocauxId(2L);
//
//        Conferencier conferencierMock = new Conferencier();
//        conferencierMock.setId(1L);
//        Locaux locauxMock = new Locaux();
//        locauxMock.setId(2L);
//
//        when(conferencierRepository.findById(dto.getConferencierId())).thenReturn(Optional.of(conferencierMock));
//        when(locauxRepository.findById(dto.getLocauxId())).thenReturn(Optional.of(locauxMock));
//        when(conferenceRepository.save(any(Conference.class))).thenAnswer(invocation -> invocation.getArgument(0));
//
//        Conference createdConference = conferenceService.createConference(dto);
//
//        assertNotNull(createdConference);
//        assertEquals(dto.getNom(), createdConference.getNom());
//        assertEquals(conferencierMock, createdConference.getConferencier());
//        assertEquals(locauxMock, createdConference.getLocaux());
//
//        verify(conferencierRepository).findById(dto.getConferencierId());
//        verify(locauxRepository).findById(dto.getLocauxId());
//        verify(conferenceRepository).save(any(Conference.class));
//    }
//}
