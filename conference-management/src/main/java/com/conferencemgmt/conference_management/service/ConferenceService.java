package com.conferencemgmt.conference_management.service;

import com.conferencemgmt.conference_management.dto.*;
import com.conferencemgmt.conference_management.model.*;
import com.conferencemgmt.conference_management.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class ConferenceService {
    @Autowired
    private ConferencierRepository conferencierRepository;

    @Autowired
    private LocauxRepository locauxRepository;

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private CommitOrganisationRepository commitOrganisationRepository;

    @Autowired
    private InviteRepository inviteRepository;

    @Autowired
    private SlideRepository slideRepository;

    @Autowired
    private PosterRepository posterRepository;


    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }

    public Optional<Conference> getConferenceById(Long id) {
        return conferenceRepository.findById(id);
    }

    public Conference createConference(ConferenceCreateDTO conferenceCreateDTO) {
       

        Conference conference = new Conference();
        conference.setNom(conferenceCreateDTO.getNom());
        conference.setDescription(conferenceCreateDTO.getDescription());
        conference.setTheme(conferenceCreateDTO.getTheme());
        conference.setImageUrl(conferenceCreateDTO.getImageUrl());
        conference.setDateDebut(conferenceCreateDTO.getDateDebut());
        conference.setDateFin(conferenceCreateDTO.getDateFin());
        conference.setNumber_invite(conferenceCreateDTO.getNumber_invite());
        conference.setSubject(conferenceCreateDTO.getSubject());

        Conferencier conferencier = conferencierRepository.findById(conferenceCreateDTO.getConferencierId())
                .orElseThrow(() -> new RuntimeException("Conferencier not found"));
        conference.setConferencier(conferencier);

        Locaux locaux = locauxRepository.findById(conferenceCreateDTO.getLocauxId())
                .orElseThrow(() -> new RuntimeException("Locaux not found"));
        conference.setLocaux(locaux);

        return conferenceRepository.save(conference);
    }

    public Conference updateConference(Long id, ConferenceUpdateDTO conferenceUpdateDTO) {
        return conferenceRepository.findById(id).map(conference -> {
            conference.setNom(conferenceUpdateDTO.getNom());
            conference.setDescription(conferenceUpdateDTO.getDescription());
            conference.setTheme(conferenceUpdateDTO.getTheme());
            conference.setImageUrl(conferenceUpdateDTO.getImageUrl());
            conference.setDateDebut(conferenceUpdateDTO.getDateDebut());
            conference.setDateFin(conferenceUpdateDTO.getDateFin());
            conference.setNumber_invite(conferenceUpdateDTO.getNumber_invite());
            conference.setSubject(conferenceUpdateDTO.getSubject());

            Conferencier conferencier = conferencierRepository.findById(conferenceUpdateDTO.getConferencierId())
                    .orElseThrow(() -> new RuntimeException("Conferencier not found"));
            conference.setConferencier(conferencier);

            Locaux locaux = locauxRepository.findById(conferenceUpdateDTO.getLocauxId())
                    .orElseThrow(() -> new RuntimeException("Locaux not found"));
            conference.setLocaux(locaux);

            return conferenceRepository.save(conference);
        }).orElseThrow(() -> new RuntimeException("Conference not found with id " + id));
    }


    public void deleteConference(Long id) {
        conferenceRepository.deleteById(id);
    }
    @Transactional
    public Conference addConference(ConferencecreategDTO conferenceDTO) {

        Conference conference = new Conference();

        conference.setNom(conferenceDTO.getNom());
        conference.setDescription(conferenceDTO.getDescription());
        conference.setTheme(conferenceDTO.getTheme());
        conference.setImageUrl(conferenceDTO.getImageUrl());
        conference.setDateDebut(conferenceDTO.getDateDebut());
        conference.setDateFin(conferenceDTO.getDateFin());
        conference.setSubject(conferenceDTO.getSubject());
        conference.setNumber_invite(conferenceDTO.getNumber_invite());

        // Fetch and set Conferencier
        Optional<Conferencier> conferencier = conferencierRepository.findById(conferenceDTO.getConferencierId());
        conferencier.ifPresent(conference::setConferencier);

        // Fetch and set Locaux
        Optional<Locaux> locaux = locauxRepository.findById(conferenceDTO.getLocauxId());
        locaux.ifPresent(conference::setLocaux);

        // Fetch and set CommitOrganisations
        Set<CommitOrganisation> commitOrganisations = conferenceDTO.getCommitOrganisationIds().stream()
                .map(id -> commitOrganisationRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("CommitOrganisation not found with id: " + id)))
                .collect(Collectors.toSet());
        conference.setCommitOrganisations(commitOrganisations);

        // Fetch and set Invites
        Set<Invite> invites = conferenceDTO.getInviteIds().stream()
                .map(id -> inviteRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Invite not found with id: " + id)))
                .collect(Collectors.toSet());
        conference.setInvites(invites);

        // Fetch and set Slides
        Set<Slide> slides = conferenceDTO.getSlideIds().stream()
                .map(id -> slideRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Slide not found with id: " + id)))
                .collect(Collectors.toSet());
        conference.setSlides(slides);

        // Fetch and set Posters
        Set<Poster> posters = conferenceDTO.getPosterIds().stream()
                .map(id -> posterRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Poster not found with id: " + id)))
                .collect(Collectors.toSet());
        conference.setPosters(posters);

        return conferenceRepository.save(conference);
    }

    public List<Conference> getAllinfoConferences() {
        return conferenceRepository.findAll();
    }
    public ConferenceDetailDTO getConferenceDetails(Long conferenceId) {
        Conference conference = conferenceRepository.findById(conferenceId)
                .orElseThrow();

        List<SlideDTO> slides = slideRepository.findByConferenceId(conferenceId)
                .stream()
                .map(slide -> new SlideDTO(slide.getId(), slide.getTitle(), slide.getAbstractContent()))
                .collect(Collectors.toList());

        List<InviteDTO> invites = inviteRepository.findByConferencesId(conferenceId)
                .stream()
                .map(invite -> new InviteDTO(invite.getId(), invite.getNom(), invite.getEmail()))
                .collect(Collectors.toList());

        // Mapping for posters, commitOrganisations, etc.

        ConferenceDetailDTO conferenceDetailDTO = new ConferenceDetailDTO();
        conferenceDetailDTO.setId(conference.getId());
        conferenceDetailDTO.setNom(conference.getNom());
        conferenceDetailDTO.setDescription(conference.getDescription());
        conferenceDetailDTO.setTheme(conference.getTheme());
        conferenceDetailDTO.setImageUrl(conference.getImageUrl());
        conferenceDetailDTO.setDateDebut(conference.getDateDebut());
        conferenceDetailDTO.setDateFin(conference.getDateFin());
        conferenceDetailDTO.setSubject(conference.getSubject());
        conferenceDetailDTO.setConferencierId(conference.getConferencier().getId());
        conferenceDetailDTO.setLocauxId(conference.getLocaux().getId());
        conferenceDetailDTO.setSlides(slides);
        conferenceDetailDTO.setInvites(invites);
        // Set other details
        return conferenceDetailDTO;
    }

    public List<Slide> getSlidesByConferenceId(Long id) {
        return conferenceRepository.findSlidesByConferenceId(id);
    }

    public List<Poster> getPostersByConferenceId(Long id) {
        return conferenceRepository.findPostersByConferenceId(id);
    }
}
