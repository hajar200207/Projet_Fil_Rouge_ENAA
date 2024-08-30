package com.conferencemgmt.conference_management.controller;

import com.conferencemgmt.conference_management.dto.SlideDTO;
import com.conferencemgmt.conference_management.dto.SlideInfoDTO;
import com.conferencemgmt.conference_management.model.Slide;
import com.conferencemgmt.conference_management.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slides")
public class SlideController {

    @Autowired
    private SlideService slideService;

    @PostMapping
    public ResponseEntity<Slide> createSlide(@RequestBody SlideDTO slideDTO) {
        Slide slide = slideService.createSlide(slideDTO);
        return ResponseEntity.ok(slide);
    }

    @GetMapping
    public ResponseEntity<List<SlideInfoDTO>> getAllSlides() {
        List<SlideInfoDTO> slides = slideService.getAllSlides();
        return ResponseEntity.ok(slides);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SlideInfoDTO> getSlideById(@PathVariable Long id) {
        SlideInfoDTO slideInfo = slideService.getSlideById(id);
        return ResponseEntity.ok(slideInfo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Slide> updateSlide(@PathVariable Long id, @RequestBody SlideDTO slideDTO) {
        Slide updatedSlide = slideService.updateSlide(id, slideDTO);
        return ResponseEntity.ok(updatedSlide);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSlide(@PathVariable Long id) {
        slideService.deleteSlide(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/conference/{conferenceId}")
    public ResponseEntity<List<Slide>> getSlidesByConferenceId(@PathVariable Long conferenceId) {
        List<Slide> slides = slideService.getSlidesByConferenceId(conferenceId);
        return ResponseEntity.ok(slides);
    }
}
