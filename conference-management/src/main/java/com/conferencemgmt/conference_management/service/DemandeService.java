package com.conferencemgmt.conference_management.service;

import com.conferencemgmt.conference_management.dto.DemandeConferencierDTO;
import com.conferencemgmt.conference_management.dto.DemandeDTO;
import com.conferencemgmt.conference_management.exception.ResourceNotFoundException;
import com.conferencemgmt.conference_management.model.Conferencier;
import com.conferencemgmt.conference_management.model.Demande;
import com.conferencemgmt.conference_management.repository.ConferencierRepository;
import com.conferencemgmt.conference_management.repository.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DemandeService {

    @Autowired
    private DemandeRepository demandeRepository;
@Autowired
private ConferencierRepository conferencierRepository;
    public Demande createDemande(Demande demande) {
        if (demande.getConferencier() != null) {
            Conferencier conferencier = conferencierRepository.findById(demande.getConferencier().getId())
                    .orElseThrow(() -> new RuntimeException("Conferencier not found"));
            demande.setConferencier(conferencier);
        }
        return demandeRepository.save(demande);
    }
    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }

    public Optional<Demande> getDemandeById(Long id) {
        return demandeRepository.findById(id);
    }

    public DemandeDTO updateDemande(Long id, DemandeDTO demandeDetails) {
        Demande demande = demandeRepository.findById(id)
                .orElseThrow();

        // Update the fields with the new details
        demande.setConferenceSubject(demandeDetails.getConferenceSubject());
        demande.setConferenceTitle(demandeDetails.getConferenceTitle());
        demande.setConferenceDescription(demandeDetails.getConferenceDescription());
        demande.setProposedDate(demandeDetails.getProposedDate());
        demande.setProposedStartTime(demandeDetails.getProposedStartTime());
        demande.setProposedEndTime(demandeDetails.getProposedEndTime());
        demande.setLocation(demandeDetails.getLocation());
        demande.setDurationInMinutes(demandeDetails.getDurationInMinutes());
        demande.setExpectedAttendees(demandeDetails.getExpectedAttendees());
        demande.setStatus(demandeDetails.getStatus());
        demande.setAdminComments(demandeDetails.getAdminComments());
        demande.setSubmissionDate(demandeDetails.getSubmissionDate());
        demande.setNumber_invite(demandeDetails.getNumber_invite());

        // Save the updated Demande
        Demande updatedDemande = demandeRepository.save(demande);

        // Convert to DTO
        DemandeDTO updatedDemandeDTO = new DemandeDTO(
                updatedDemande.getId(),
                updatedDemande.getConferencier().getId(),
                updatedDemande.getNumber_invite(),
                updatedDemande.getConferenceSubject(),
                updatedDemande.getConferenceTitle(),
                updatedDemande.getConferenceDescription(),
                updatedDemande.getProposedDate(),
                updatedDemande.getProposedStartTime(),
                updatedDemande.getProposedEndTime(),
                updatedDemande.getLocation(),
                updatedDemande.getDurationInMinutes(),
                updatedDemande.getExpectedAttendees(),
                updatedDemande.getStatus(),
                updatedDemande.getAdminComments(),
                updatedDemande.getSubmissionDate()

        );

        return updatedDemandeDTO;
    }

    public void deleteDemande(Long id) {
        demandeRepository.deleteById(id);
    }


    // add methode get by id conferencier
    public List<DemandeConferencierDTO> getDemandesByConferencierId(Long conferencierId) {
        Conferencier conferencier = conferencierRepository.findById(conferencierId)
                .orElseThrow();

        return demandeRepository.findByConferencier(conferencier).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private DemandeConferencierDTO mapToDto(Demande demande) {
        DemandeConferencierDTO dto = new DemandeConferencierDTO();
        dto.setDemandeId(demande.getId());
        dto.setConferenceSubject(demande.getConferenceSubject());
        dto.setConferenceTitle(demande.getConferenceTitle());
        dto.setConferenceDescription(demande.getConferenceDescription());
        dto.setProposedDate(demande.getProposedDate());
        dto.setProposedStartTime(demande.getProposedStartTime());
        dto.setProposedEndTime(demande.getProposedEndTime());
        dto.setLocation(demande.getLocation());
        dto.setDurationInMinutes(demande.getDurationInMinutes());
        dto.setExpectedAttendees(demande.getExpectedAttendees());
        dto.setStatus(demande.getStatus());
        dto.setAdminComments(demande.getAdminComments());
        dto.setSubmissionDate(demande.getSubmissionDate());

        // Set Conferencier details
        dto.setConferencierId(demande.getConferencier().getId());
        dto.setConferencierNom(demande.getConferencier().getNom());
        dto.setConferencierPrenom(demande.getConferencier().getPrenom());
        dto.setConferencierEmail(demande.getConferencier().getEmail());
        dto.setConferencierSpecialite(demande.getConferencier().getSpecialite());

        return dto;
    }

}
