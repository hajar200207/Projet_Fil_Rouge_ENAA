package com.conferencemgmt.conference_management.service;

import com.conferencemgmt.conference_management.model.Conference;
import com.conferencemgmt.conference_management.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConferenceService {

    @Autowired
    private ConferenceRepository conferenceRepository;
    public Conference findById(Long id) {
        return conferenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conference not found"));
    }
    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }

    public Optional<Conference> getConferenceById(Long id) {
        return conferenceRepository.findById(id);
    }

    public Conference saveConference(Conference conference) {
        return conferenceRepository.save(conference);
    }

    public Conference updateConference(Long id, Conference updatedConference) {
        Optional<Conference> existingConference = conferenceRepository.findById(id);
        if (existingConference.isPresent()) {
            Conference conference = existingConference.get();
            conference.setNom(updatedConference.getNom());
            conference.setDescription(updatedConference.getDescription());
            conference.setTheme(updatedConference.getTheme());
            conference.setDateDebut(updatedConference.getDateDebut());
            conference.setDateFin(updatedConference.getDateFin());
            conference.setSubject(updatedConference.getSubject());
            conference.setConferencier(updatedConference.getConferencier());
            conference.setLocaux(updatedConference.getLocaux());
            return conferenceRepository.save(conference);
        } else {
            return null; // Or throw an exception
        }
    }

    public void deleteConference(Long id) {
        conferenceRepository.deleteById(id);
    }
}
