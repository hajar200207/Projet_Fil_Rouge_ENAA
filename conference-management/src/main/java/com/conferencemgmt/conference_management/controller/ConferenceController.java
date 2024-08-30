package com.conferencemgmt.conference_management.controller;

import com.conferencemgmt.conference_management.dto.ConferenceCreateDTO;
import com.conferencemgmt.conference_management.dto.ConferenceDetailDTO;
import com.conferencemgmt.conference_management.dto.ConferenceUpdateDTO;
import com.conferencemgmt.conference_management.dto.ConferencecreategDTO;
import com.conferencemgmt.conference_management.model.Conference;
import com.conferencemgmt.conference_management.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conferences")
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;

    @GetMapping
    public List<Conference> getAllConferences() {
        return conferenceService.getAllConferences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conference> getConferenceById(@PathVariable Long id) {
        return conferenceService.getConferenceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createConference(@RequestBody ConferenceCreateDTO conferenceCreateDTO) {
        try {
            Conference createdConference = conferenceService.createConference(conferenceCreateDTO);
            return new ResponseEntity<>(createdConference, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conference> updateConference(@PathVariable Long id, @RequestBody ConferenceUpdateDTO conferenceUpdateDTO) {
        return ResponseEntity.ok(conferenceService.updateConference(id, conferenceUpdateDTO));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConference(@PathVariable Long id) {
        conferenceService.deleteConference(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/add")
    public ResponseEntity<Conference> addConference(@RequestBody ConferencecreategDTO conferencecreategDTO) {
        Conference createdConference = conferenceService.addConference(conferencecreategDTO);
        return ResponseEntity.ok(createdConference);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Conference>> getAllinfoConferences() {
        List<Conference> conferences = conferenceService.getAllinfoConferences();
        return ResponseEntity.ok(conferences);
    }
    @GetMapping("/{id}/details")
    public ResponseEntity<ConferenceDetailDTO> getConferenceDetails(@PathVariable Long id) {
        ConferenceDetailDTO conferenceDetailDTO = conferenceService.getConferenceDetails(id);
        return ResponseEntity.ok(conferenceDetailDTO);
    }
}
