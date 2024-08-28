package com.conferencemgmt.conference_management.service;

import com.conferencemgmt.conference_management.dto.ConferenceCreateDTO;
import com.conferencemgmt.conference_management.dto.ConferenceUpdateDTO;
import com.conferencemgmt.conference_management.model.Conference;
import com.conferencemgmt.conference_management.model.Conferencier;
import com.conferencemgmt.conference_management.model.Locaux;
import com.conferencemgmt.conference_management.repository.ConferenceRepository;
import com.conferencemgmt.conference_management.repository.ConferencierRepository;
import com.conferencemgmt.conference_management.repository.LocauxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ConferenceService {
    @Autowired
    private ConferencierRepository conferencierRepository;

    @Autowired
    private LocauxRepository locauxRepository;

    @Autowired
    private ConferenceRepository conferenceRepository;

    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }

    public Optional<Conference> getConferenceById(Long id) {
        return conferenceRepository.findById(id);
    }

    public Conference createConference(ConferenceCreateDTO conferenceCreateDTO) {
        if (conferenceRepository.existsByNomAndDateDebut(conferenceCreateDTO.getNom(), conferenceCreateDTO.getDateDebut())) {
            throw new RuntimeException("A conference with the same name and start date already exists");
        }

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
}
