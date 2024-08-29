package com.conferencemgmt.conference_management.controller;

import com.conferencemgmt.conference_management.dto.PosterCreateDTO;
import com.conferencemgmt.conference_management.model.Poster;
import com.conferencemgmt.conference_management.service.PosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posters")
public class PosterController {
    @Autowired
    private PosterService posterService;

    @GetMapping
    public List<Poster> getAllPosters() {
        return posterService.getAllPosters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poster> getPosterById(@PathVariable Long id) {
        Optional<Poster> poster = posterService.getPosterById(id);
        return poster.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Poster> createPoster(@RequestBody PosterCreateDTO posterCreateDTO) {
        Poster poster = posterService.createPoster(posterCreateDTO);
        return ResponseEntity.ok(poster);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Poster> updatePoster(@PathVariable Long id, @RequestBody PosterCreateDTO posterCreateDTO) {
        Poster updatedPoster = posterService.updatePoster(id, posterCreateDTO);
        return ResponseEntity.ok(updatedPoster);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoster(@PathVariable Long id) {
        posterService.deletePoster(id);
        return ResponseEntity.noContent().build();
    }
}
