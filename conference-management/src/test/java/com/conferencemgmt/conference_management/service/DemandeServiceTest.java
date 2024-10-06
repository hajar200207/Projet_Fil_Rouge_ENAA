//package com.conferencemgmt.conference_management.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//import com.conferencemgmt.conference_management.dto.DemandeDTO;
//import com.conferencemgmt.conference_management.dto.DemandeConferencierDTO;
//import com.conferencemgmt.conference_management.exception.ResourceNotFoundException;
//import com.conferencemgmt.conference_management.model.Conferencier;
//import com.conferencemgmt.conference_management.model.Demande;
//import com.conferencemgmt.conference_management.repository.ConferencierRepository;
//import com.conferencemgmt.conference_management.repository.DemandeRepository;
//import com.conferencemgmt.conference_management.service.DemandeService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class DemandeServiceTest {
//
//    @Mock
//    private DemandeRepository demandeRepository;
//
//    @Mock
//    private ConferencierRepository conferencierRepository;
//
//    @InjectMocks
//    private DemandeService demandeService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testCreateDemande() {
//        // Mock des données
//        Conferencier conferencier = new Conferencier();
//        conferencier.setId(1L);
//        Demande demande = new Demande();
//        demande.setConferencier(conferencier);
//
//        when(conferencierRepository.findById(conferencier.getId())).thenReturn(Optional.of(conferencier));
//        when(demandeRepository.save(demande)).thenReturn(demande);
//
//        // Appel de la méthode à tester
//        Demande createdDemande = demandeService.createDemande(demande);
//
//        // Vérifications
//        assertNotNull(createdDemande);
//        verify(conferencierRepository, times(1)).findById(conferencier.getId());
//        verify(demandeRepository, times(1)).save(demande);
//    }
//
//    @Test
//    void testGetDemandesByConferencierId() {
//        // Mock des données
//        Long conferencierId = 1L;
//        Conferencier conferencier = new Conferencier();
//        conferencier.setId(conferencierId);
//        Demande demande = new Demande();
//        demande.setConferencier(conferencier);
//
//        when(conferencierRepository.findById(conferencierId)).thenReturn(Optional.of(conferencier));
//        when(demandeRepository.findByConferencier(conferencier)).thenReturn(List.of(demande));
//
//        // Appel de la méthode à tester
//        List<DemandeConferencierDTO> demandes = demandeService.getDemandesByConferencierId(conferencierId);
//
//        // Vérifications
//        assertFalse(demandes.isEmpty());
//        verify(conferencierRepository, times(1)).findById(conferencierId);
//        verify(demandeRepository, times(1)).findByConferencier(conferencier);
//    }
//
//
//    @Test
//    void testDeleteDemande() {
//        // Mock des données
//        Long demandeId = 1L;
//
//        doNothing().when(demandeRepository).deleteById(demandeId);
//
//        // Appel de la méthode à tester
//        demandeService.deleteDemande(demandeId);
//
//        // Vérifications
//        verify(demandeRepository, times(1)).deleteById(demandeId);
//    }
//}
