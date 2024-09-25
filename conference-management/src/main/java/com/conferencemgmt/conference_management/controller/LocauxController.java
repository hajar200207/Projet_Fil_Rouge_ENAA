package com.conferencemgmt.conference_management.controller;

import com.conferencemgmt.conference_management.dto.LocauxDTO;
import com.conferencemgmt.conference_management.model.Locaux;
import com.conferencemgmt.conference_management.service.LocauxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/locaux")
public class LocauxController {

    @Autowired
    private LocauxService locauxService;

    @PostMapping
    public ResponseEntity<Locaux> createLocaux(@RequestBody LocauxDTO locauxDTO) {
        Locaux createdLocaux = locauxService.createLocaux(locauxDTO);
        return ResponseEntity.ok(createdLocaux);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocauxDTO> updateLocaux(@PathVariable Long id, @RequestBody LocauxDTO locauxDTO) {
        LocauxDTO updatedLocaux = locauxService.updateLocaux(id, locauxDTO);
        return updatedLocaux != null ? ResponseEntity.ok(updatedLocaux) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocauxDTO> getLocauxById(@PathVariable Long id) {
        LocauxDTO locauxDTO = locauxService.getLocauxById(id);
        return locauxDTO != null ? ResponseEntity.ok(locauxDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<LocauxDTO>> getAllLocaux() {
        List<LocauxDTO> locauxList = locauxService.getAllLocaux();
        return ResponseEntity.ok(locauxList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocaux(@PathVariable Long id) {
        locauxService.deleteLocaux(id);
        return ResponseEntity.noContent().build();
    }
}
