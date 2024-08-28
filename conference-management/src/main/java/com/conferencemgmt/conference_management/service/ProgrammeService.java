package com.conferencemgmt.conference_management.service;

import com.conferencemgmt.conference_management.dto.ProgrammeDTO;
import com.conferencemgmt.conference_management.dto.ProgrammeInfoDTO;
import com.conferencemgmt.conference_management.exception.ResourceNotFoundException;
import com.conferencemgmt.conference_management.model.*;
import com.conferencemgmt.conference_management.repository.CommitOrganisationRepository;
import com.conferencemgmt.conference_management.repository.ConferenceRepository;
import com.conferencemgmt.conference_management.repository.ConferencierRepository;
import com.conferencemgmt.conference_management.repository.ProgrammeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProgrammeService {

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private CommitOrganisationRepository commitOrganisationRepository;

    @Autowired
    private ConferencierRepository conferencierRepository;

    @Autowired
    private ProgrammeRepository programmeRepository;

    public Programme convertToEntity(ProgrammeDTO programmeDTO) {
        Programme programme = new Programme();

        programme.setTitre(programmeDTO.getTitre());
        programme.setDescription(programmeDTO.getDescription());
        programme.setDate(programmeDTO.getDate());
        programme.setHeureDebut(programmeDTO.getHeureDebut());
        programme.setHeureFin(programmeDTO.getHeureFin());
        programme.setSalle(programmeDTO.getSalle());



        CommitOrganisation commitOrganisation = commitOrganisationRepository.findById(programmeDTO.getCommitOrganisationId())
                .orElseThrow();
        programme.setCommitOrganisation(commitOrganisation);

        Conferencier conferencier = conferencierRepository.findById(programmeDTO.getConferencierId())
                .orElseThrow();
        programme.setConferencier(conferencier);

        return programme;
    }

    public Programme createProgramme(ProgrammeDTO programmeDTO) {
        Programme programme = convertToEntity(programmeDTO);
        return programmeRepository.save(programme);
    }
    public List<ProgrammeDTO> getAllProgrammes() {
        return programmeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ProgrammeDTO getProgrammeById(Long id) {
        Programme programme = programmeRepository.findById(id)
                .orElseThrow();
        return convertToDTO(programme);
    }

    public ProgrammeDTO updateProgramme(Long id, ProgrammeDTO programmeDTO) {
        Programme programme = programmeRepository.findById(id)
                .orElseThrow();

        programme.setTitre(programmeDTO.getTitre());
        programme.setDescription(programmeDTO.getDescription());
        programme.setDate(programmeDTO.getDate());
        programme.setHeureDebut(programmeDTO.getHeureDebut());
        programme.setHeureFin(programmeDTO.getHeureFin());
        programme.setSalle(programmeDTO.getSalle());

        CommitOrganisation commitOrganisation = commitOrganisationRepository.findById(programmeDTO.getCommitOrganisationId())
                .orElseThrow();
        programme.setCommitOrganisation(commitOrganisation);

        Conferencier conferencier = conferencierRepository.findById(programmeDTO.getConferencierId())
                .orElseThrow();
        programme.setConferencier(conferencier);

        Programme updatedProgramme = programmeRepository.save(programme);
        return convertToDTO(updatedProgramme);
    }

    public void deleteProgramme(Long id) {
        Programme programme = programmeRepository.findById(id)
                .orElseThrow();
        programmeRepository.delete(programme);
    }


    private ProgrammeDTO convertToDTO(Programme programme) {
        ProgrammeDTO dto = new ProgrammeDTO();
        dto.setId(programme.getId());
        dto.setTitre(programme.getTitre());
        dto.setDescription(programme.getDescription());
        dto.setDate(programme.getDate());
        dto.setHeureDebut(programme.getHeureDebut());
        dto.setHeureFin(programme.getHeureFin());
        dto.setSalle(programme.getSalle());
        dto.setCommitOrganisationId(programme.getCommitOrganisation().getId());
        dto.setConferencierId(programme.getConferencier().getId());
        return dto;
    }
    public ProgrammeInfoDTO getProgrammeInfo(Long id) {
        Programme programme = programmeRepository.findById(id).orElseThrow(() -> new RuntimeException("Programme not found"));

        ProgrammeInfoDTO dto = new ProgrammeInfoDTO();
        dto.setProgrammeId(programme.getId());
        dto.setTitre(programme.getTitre());
        dto.setDescription(programme.getDescription());
        dto.setDate(programme.getDate());
        dto.setHeureDebut(programme.getHeureDebut());
        dto.setHeureFin(programme.getHeureFin());
        dto.setSalle(programme.getSalle());

        if (programme.getCommitOrganisation() != null) {
            dto.setCommitOrganisationId(programme.getCommitOrganisation().getId());
            dto.setCommitOrganisationNom(programme.getCommitOrganisation().getNom());
            dto.setCommitOrganisationPrenom(programme.getCommitOrganisation().getPrenom());
            dto.setCommitOrganisationEmail(programme.getCommitOrganisation().getEmail());
            dto.setCommitOrganisationFonction(programme.getCommitOrganisation().getFonction());
        }

        if (programme.getConferencier() != null) {
            dto.setConferencierId(programme.getConferencier().getId());
            dto.setConferencierNom(programme.getConferencier().getNom());
            dto.setConferencierPrenom(programme.getConferencier().getPrenom());
            dto.setConferencierEmail(programme.getConferencier().getEmail());
            dto.setConferencierSpecialite(programme.getConferencier().getSpecialite());
        }

        return dto;
    }
}
