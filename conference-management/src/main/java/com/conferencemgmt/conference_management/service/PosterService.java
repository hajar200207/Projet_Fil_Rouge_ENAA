package com.conferencemgmt.conference_management.service;

import com.conferencemgmt.conference_management.dto.PosterCreateDTO;
import com.conferencemgmt.conference_management.model.Poster;
import com.conferencemgmt.conference_management.model.CommitOrganisation;
import com.conferencemgmt.conference_management.model.Conference;
import com.conferencemgmt.conference_management.repository.PosterRepository;
import com.conferencemgmt.conference_management.repository.CommitOrganisationRepository;
import com.conferencemgmt.conference_management.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosterService {
    @Autowired
    private PosterRepository posterRepository;

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private CommitOrganisationRepository commitOrganisationRepository;

    public List<Poster> getAllPosters() {
        return posterRepository.findAll();
    }

    public Optional<Poster> getPosterById(Long id) {
        return posterRepository.findById(id);
    }

    public Poster createPoster(PosterCreateDTO posterCreateDTO) {
        Conference conference = conferenceRepository.findById(posterCreateDTO.getConferenceId())
                .orElseThrow(() -> new RuntimeException("Conference not found"));

        CommitOrganisation commitOrganisation = commitOrganisationRepository.findById(posterCreateDTO.getCommitOrganisationId())
                .orElseThrow(() -> new RuntimeException("CommitOrganisation not found"));

        Poster poster = new Poster();
        poster.setTitre(posterCreateDTO.getTitre());
        poster.setDescription(posterCreateDTO.getDescription());
        poster.setImageUrl(posterCreateDTO.getImageUrl());
        poster.setConference(conference);
        poster.setCommitOrganisation(commitOrganisation);

        return posterRepository.save(poster);
    }

    public Poster updatePoster(Long id, PosterCreateDTO posterCreateDTO) {
        return posterRepository.findById(id).map(poster -> {
            poster.setTitre(posterCreateDTO.getTitre());
            poster.setDescription(posterCreateDTO.getDescription());
            poster.setImageUrl(posterCreateDTO.getImageUrl());

            Conference conference = conferenceRepository.findById(posterCreateDTO.getConferenceId())
                    .orElseThrow(() -> new RuntimeException("Conference not found"));

            CommitOrganisation commitOrganisation = commitOrganisationRepository.findById(posterCreateDTO.getCommitOrganisationId())
                    .orElseThrow(() -> new RuntimeException("CommitOrganisation not found"));

            poster.setConference(conference);
            poster.setCommitOrganisation(commitOrganisation);

            return posterRepository.save(poster);
        }).orElseThrow(() -> new RuntimeException("Poster not found with id " + id));
    }


    public void deletePoster(Long id) {
        posterRepository.deleteById(id);
    }

    public List<Poster> getPostersByConferenceId(Long conferenceId) {
        return posterRepository.findByConferenceId(conferenceId);
    }
}
