package com.conferencemgmt.conference_management.service;

import com.conferencemgmt.conference_management.Mapper.LocauxMapper;
import com.conferencemgmt.conference_management.dto.LocauxDTO;
import com.conferencemgmt.conference_management.model.CommitOrganisation;
import com.conferencemgmt.conference_management.model.Locaux;
import com.conferencemgmt.conference_management.repository.CommitOrganisationRepository;
import com.conferencemgmt.conference_management.repository.LocauxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
//public class LocauxService {
//
//    @Autowired
//    private LocauxRepository locauxRepository;
//    @Autowired
//    private LocauxMapper locauxMapper;
//
//
//    public LocauxDTO createLocaux(LocauxDTO locauxDTO) {
//        Locaux locaux = locauxMapper.toEntity(locauxDTO);
//        Locaux savedLocaux = locauxRepository.save(locaux);
//        return locauxMapper.toDto(savedLocaux);
//    }
//
//    public LocauxDTO updateLocaux(Long id, LocauxDTO locauxDTO) {
//        if (locauxRepository.existsById(id)) {
//            Locaux locaux = locauxMapper.toEntity(locauxDTO);
//            locaux.setId(id);
//            Locaux updatedLocaux = locauxRepository.save(locaux);
//            return locauxMapper.toDto(updatedLocaux);
//        } else {
//            // Handle the case when the `Locaux` with the given id does not exist
//            return null;
//        }
//    }
//
//    public LocauxDTO getLocauxById(Long id) {
//        Optional<Locaux> locaux = locauxRepository.findById(id);
//        return locaux.map(locauxMapper::toDto).orElse(null);
//    }
//
//    public List<LocauxDTO> getAllLocaux() {
//        List<Locaux> locauxList = locauxRepository.findAll();
//        return locauxMapper.toDtoList(locauxList);
//    }
//
//    public void deleteLocaux(Long id) {
//        if (locauxRepository.existsById(id)) {
//            locauxRepository.deleteById(id);
//        }
//    }


import com.conferencemgmt.conference_management.Mapper.LocauxMapper;
import com.conferencemgmt.conference_management.dto.LocauxDTO;
import com.conferencemgmt.conference_management.model.CommitOrganisation;
import com.conferencemgmt.conference_management.model.Locaux;
import com.conferencemgmt.conference_management.repository.CommitOrganisationRepository;
import com.conferencemgmt.conference_management.repository.LocauxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocauxService {

    @Autowired
    private LocauxRepository locauxRepository;

    @Autowired
    private LocauxMapper locauxMapper;

    @Autowired
    private CommitOrganisationRepository commitOrganisationRepository;

    public Locaux createLocaux(LocauxDTO locauxDTO) {
        Locaux locaux = locauxMapper.toEntity(locauxDTO);

        if (locauxDTO.getCommitOrganisationId() != null) {
            CommitOrganisation commitOrganisation = commitOrganisationRepository.findById(locauxDTO.getCommitOrganisationId())
                    .orElseThrow(() -> new RuntimeException("CommitOrganisation not found"));
            locaux.setCommitOrganisation(commitOrganisation);
        }

        return locauxRepository.save(locaux);
    }

    public LocauxDTO updateLocaux(Long id, LocauxDTO locauxDTO) {
        if (locauxRepository.existsById(id)) {
            Locaux locaux = locauxMapper.toEntity(locauxDTO);
            locaux.setId(id);

            if (locauxDTO.getCommitOrganisationId() != null) {
                CommitOrganisation commitOrganisation = commitOrganisationRepository.findById(locauxDTO.getCommitOrganisationId())
                        .orElseThrow(() -> new RuntimeException("CommitOrganisation not found"));
                locaux.setCommitOrganisation(commitOrganisation);
            }

            Locaux updatedLocaux = locauxRepository.save(locaux);
            return locauxMapper.toDto(updatedLocaux);
        } else {
            return null;
        }
    }

    public LocauxDTO getLocauxById(Long id) {
        Optional<Locaux> locaux = locauxRepository.findById(id);
        return locaux.map(locauxMapper::toDto).orElse(null);
    }

    public List<LocauxDTO> getAllLocaux() {
        List<Locaux> locauxList = locauxRepository.findAll();
        return locauxMapper.toDtoList(locauxList);
    }

    public void deleteLocaux(Long id) {
        if (locauxRepository.existsById(id)) {
            locauxRepository.deleteById(id);
        }
    }
}
