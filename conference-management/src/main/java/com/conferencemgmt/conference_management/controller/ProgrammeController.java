//package com.conferencemgmt.conference_management.controller;
//
//import com.conferencemgmt.conference_management.dto.ProgrammeDTO;
//import com.conferencemgmt.conference_management.service.ProgrammeService;
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/programmes")
//public class ProgrammeController {
//
//    @Autowired
//    private ProgrammeService programmeService;
//
//    @PostMapping
//    public ResponseEntity<?> createProgramme(@RequestBody ProgrammeDTO programmeDTO) {
//        try {
//            ProgrammeDTO createdProgramme = programmeService.createProgramme(programmeDTO);
//            return ResponseEntity.ok(createdProgramme);
//        } catch (EntityNotFoundException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//
//
//    @PutMapping("/{id}")
//    public ResponseEntity<ProgrammeDTO> updateProgramme(@PathVariable Long id, @RequestBody ProgrammeDTO programmeDTO) {
//        ProgrammeDTO updatedProgramme = programmeService.updateProgramme(id, programmeDTO);
//        return updatedProgramme != null ? ResponseEntity.ok(updatedProgramme) : ResponseEntity.notFound().build();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ProgrammeDTO> getProgrammeById(@PathVariable Long id) {
//        ProgrammeDTO programmeDTO = programmeService.getProgrammeById(id);
//        return programmeDTO != null ? ResponseEntity.ok(programmeDTO) : ResponseEntity.notFound().build();
//    }
//
//    @GetMapping
//    public ResponseEntity<List<ProgrammeDTO>> getAllProgrammes() {
//        List<ProgrammeDTO> programmeList = programmeService.getAllProgrammes();
//        return ResponseEntity.ok(programmeList);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteProgramme(@PathVariable Long id) {
//        programmeService.deleteProgramme(id);
//        return ResponseEntity.noContent().build();
//    }
//}
//package com.conferencemgmt.conference_management.controller;
//
//import com.conferencemgmt.conference_management.dto.DemandeDTO;
//import com.conferencemgmt.conference_management.dto.ProgrammeDTO;
//import com.conferencemgmt.conference_management.model.*;
//import com.conferencemgmt.conference_management.repository.ConferencierRepository;
//import com.conferencemgmt.conference_management.service.ProgrammeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/programmes")
//public class ProgrammeController {
//
//    @Autowired
//    private ProgrammeService programmeService;
//
//    @Autowired
//    private ConferencierRepository conferencierRepository ;
//    @PostMapping
//    public ResponseEntity<?> createProgramme(@RequestBody ProgrammeDTO programmeDTO) {
//        if (ProgrammeDTO.getConferencierId() == null) {
//            return ResponseEntity.badRequest().body("Missing 'conferencierId' in the request payload");
//        }
//        if (ProgrammeDTO.getConferenceId() == null) {
//            return ResponseEntity.badRequest().body("Missing 'conferencierId' in the request payload");
//        }
//        if (ProgrammeDTO.getCommitOrganisationId() == null) {
//            return ResponseEntity.badRequest().body("Missing 'conferencierId' in the request payload");
//        }
//        Conferencier conferencier = conferencierRepository.findById(ProgrammeDTO.getConferencierId())
//                .orElseThrow();
//        Conference conference = conferencierRepository.findById(ProgrammeDTO.getConferenceId())
//                .orElseThrow();
//        CommitOrganisation commitOrganisation= conferencierRepository.findById(ProgrammeDTO.getCommitOrganisationId())
//                .orElseThrow();
//        Programme programme = new Programme();
//        programme.setConferencier(conferencier);
//        programme.setSalle(programmeDTO.getSalle());
//        programme.setHeureFin(programmeDTO.getHeureFin());
//        programme.setHeureDebut(programmeDTO.getHeureDebut());
//        programme.setDescription(programmeDTO.getDescription());
//        programme.setDate(programmeDTO.getDate());
//        programme.setTitre(programmeDTO.getTitre());
//        programme.setConference(conference);
//        programme.setCommitOrganisation(commitOrganisation);
//
//        Programme savedProgramme = ProgrammeService.createProgramme(programme);
//        return ResponseEntity.ok(savedProgramme);
//    }
//
//}
package com.conferencemgmt.conference_management.controller;

import com.conferencemgmt.conference_management.dto.ProgrammeDTO;
import com.conferencemgmt.conference_management.dto.ProgrammeInfoDTO;
import com.conferencemgmt.conference_management.model.*;
import com.conferencemgmt.conference_management.repository.ConferencierRepository;
import com.conferencemgmt.conference_management.repository.ConferenceRepository;
import com.conferencemgmt.conference_management.repository.CommitOrganisationRepository;
import com.conferencemgmt.conference_management.service.ProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programmes")
public class ProgrammeController {

    @Autowired
    private ProgrammeService programmeService;

    @Autowired
    private ConferencierRepository conferencierRepository;

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private CommitOrganisationRepository commitOrganisationRepository;
    @PreAuthorize("hasRole('ADMIN') or hasRole('COMMIT_ORGANISATION')")
    @PostMapping
    public ResponseEntity<Programme> createProgramme(@RequestBody ProgrammeDTO programmeDTO) {
        Programme programme = programmeService.createProgramme(programmeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(programme);
    }
    @PreAuthorize("hasRole('ADMIN') or hasRole('COMMIT_ORGANISATION')")

    @GetMapping
    public ResponseEntity<List<ProgrammeDTO>> getAllProgrammes() {
        List<ProgrammeDTO> programmes = programmeService.getAllProgrammes();
        return ResponseEntity.ok(programmes);
    }
    @PreAuthorize("hasRole('ADMIN') or hasRole('COMMIT_ORGANISATION')")

    @GetMapping("/{id}")
    public ResponseEntity<ProgrammeDTO> getProgrammeById(@PathVariable Long id) {
        ProgrammeDTO programmeDTO = programmeService.getProgrammeById(id);
        return ResponseEntity.ok(programmeDTO);
    }
    @PreAuthorize("hasRole('ADMIN') or hasRole('COMMIT_ORGANISATION')")

    @PutMapping("/{id}")
    public ResponseEntity<ProgrammeDTO> updateProgramme(@PathVariable Long id, @RequestBody ProgrammeDTO programmeDTO) {
        ProgrammeDTO updatedProgramme = programmeService.updateProgramme(id, programmeDTO);
        return ResponseEntity.ok(updatedProgramme);
    }
    @PreAuthorize("hasRole('ADMIN') or hasRole('COMMIT_ORGANISATION')")

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgramme(@PathVariable Long id) {
        programmeService.deleteProgramme(id);
        return ResponseEntity.noContent().build();
    }
    @PreAuthorize("hasRole('ADMIN') or hasRole('COMMIT_ORGANISATION')")

    @GetMapping("all/{id}")
    public ProgrammeInfoDTO getProgrammeInfo(@PathVariable Long id) {
        return programmeService.getProgrammeInfo(id);
    }
    @PreAuthorize("hasRole('CONFERENCIER')")
    @GetMapping("/conferencier/{conferencierId}")
    public ResponseEntity<List<ProgrammeDTO>> getProgrammesByConferencier(@PathVariable Long conferencierId) {
        List<ProgrammeDTO> programmes = programmeService.getProgrammesByConferencierId(conferencierId);
        return ResponseEntity.ok(programmes);
    }

}
