package com.conferencemgmt.conference_management.controller;

import com.conferencemgmt.conference_management.dto.DemandeConferencierDTO;
import com.conferencemgmt.conference_management.dto.DemandeDTO;
import com.conferencemgmt.conference_management.exception.ResourceNotFoundException;
import com.conferencemgmt.conference_management.model.Conferencier;
import com.conferencemgmt.conference_management.model.Demande;
import com.conferencemgmt.conference_management.repository.ConferencierRepository;
import com.conferencemgmt.conference_management.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demandes")
public class DemandeController {

    @Autowired
    private DemandeService demandeService;
    @Autowired
     private ConferencierRepository conferencierRepository ;

    @PostMapping
    public ResponseEntity<?> createDemande(@RequestBody DemandeDTO demandeDTO) {
        if (demandeDTO.getConferencierId() == null) {
            return ResponseEntity.badRequest().body("Missing 'conferencierId' in the request payload");
        }

        Conferencier conferencier = conferencierRepository.findById(demandeDTO.getConferencierId())
                .orElseThrow();

        Demande demande = new Demande();
        demande.setConferencier(conferencier);
        demande.setNumber_invite(demandeDTO.getNumber_invite());
        demande.setConferenceSubject(demandeDTO.getConferenceSubject());
        demande.setConferenceTitle(demandeDTO.getConferenceTitle());
        demande.setConferenceDescription(demandeDTO.getConferenceDescription());
        demande.setProposedDate(demandeDTO.getProposedDate());
        demande.setProposedStartTime(demandeDTO.getProposedStartTime());
        demande.setProposedEndTime(demandeDTO.getProposedEndTime());
        demande.setLocation(demandeDTO.getLocation());
        demande.setDurationInMinutes(demandeDTO.getDurationInMinutes());
        demande.setExpectedAttendees(demandeDTO.getExpectedAttendees());
        demande.setStatus(demandeDTO.getStatus());
        demande.setAdminComments(demandeDTO.getAdminComments());
        demande.setSubmissionDate(demandeDTO.getSubmissionDate());

        Demande savedDemande = demandeService.createDemande(demande);
        return ResponseEntity.ok(savedDemande);
    }

    @GetMapping
    public ResponseEntity<List<Demande>> getAllDemandes() {
        List<Demande> demandes = demandeService.getAllDemandes();
        return ResponseEntity.ok(demandes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Demande> getDemandeById(@PathVariable Long id) {
        return demandeService.getDemandeById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DemandeDTO> updateDemande(@PathVariable Long id, @RequestBody DemandeDTO demandeDetails) {
        DemandeDTO updatedDemande = demandeService.updateDemande(id, demandeDetails);
        return ResponseEntity.ok(updatedDemande);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDemande(@PathVariable Long id) {
        demandeService.deleteDemande(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/conferencier/{conferencierId}")
    public ResponseEntity<List<DemandeConferencierDTO>> getDemandesByConferencierId(@PathVariable Long conferencierId) {
        List<DemandeConferencierDTO> demandes = demandeService.getDemandesByConferencierId(conferencierId);
        return ResponseEntity.ok(demandes);
    }
}
