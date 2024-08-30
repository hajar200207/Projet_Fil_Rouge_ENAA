package com.conferencemgmt.conference_management.service;

import com.conferencemgmt.conference_management.dto.SlideDTO;
import com.conferencemgmt.conference_management.dto.SlideInfoDTO;
import com.conferencemgmt.conference_management.exception.ResourceNotFoundException;
import com.conferencemgmt.conference_management.model.*;
import com.conferencemgmt.conference_management.repository.ConferenceRepository;
import com.conferencemgmt.conference_management.repository.ConferencierRepository;
import com.conferencemgmt.conference_management.repository.SlideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SlideService {

    @Autowired
    private SlideRepository slideRepository;

    @Autowired
    private ConferencierRepository conferencierRepository;

    @Autowired
    private ConferenceRepository conferenceRepository;

    public Slide createSlide(SlideDTO slideDTO) {
        Slide slide = new Slide();
        slide.setTitle(slideDTO.getTitle());
        slide.setAbstractContent(slideDTO.getAbstractContent());
        slide.setKeyphrases(slideDTO.getKeyphrases());
        slide.setDocumentType(slideDTO.getDocumentType());
        slide.setDocumentUrl(slideDTO.getDocumentUrl());

        Conferencier author = conferencierRepository.findById(slideDTO.getAuthorId())
                .orElseThrow();
        slide.setAuthor(author);

        Conference conference = conferenceRepository.findById(slideDTO.getConferenceId())
                .orElseThrow();
        slide.setConference(conference);

        return slideRepository.save(slide);
    }

    public List<SlideInfoDTO> getAllSlides() {
        return slideRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public SlideInfoDTO getSlideById(Long id) {
        Slide slide = slideRepository.findById(id)
                .orElseThrow();
        return convertToDTO(slide);
    }

    public Slide updateSlide(Long id, SlideDTO slideDTO) {
        Slide slide = slideRepository.findById(id)
                .orElseThrow();

        slide.setTitle(slideDTO.getTitle());
        slide.setAbstractContent(slideDTO.getAbstractContent());
        slide.setKeyphrases(slideDTO.getKeyphrases());
        slide.setDocumentType(slideDTO.getDocumentType());
        slide.setDocumentUrl(slideDTO.getDocumentUrl());

        Conferencier author = conferencierRepository.findById(slideDTO.getAuthorId())
                .orElseThrow();
        slide.setAuthor(author);

        Conference conference = conferenceRepository.findById(slideDTO.getConferenceId())
                .orElseThrow();
        slide.setConference(conference);

        return slideRepository.save(slide);
    }

    public void deleteSlide(Long id) {
        Slide slide = slideRepository.findById(id)
                .orElseThrow();
        slideRepository.delete(slide);
    }

    private SlideInfoDTO convertToDTO(Slide slide) {
        SlideInfoDTO dto = new SlideInfoDTO();
        dto.setId(slide.getId());
        dto.setTitle(slide.getTitle());
        dto.setAbstractContent(slide.getAbstractContent());
        dto.setKeyphrases(slide.getKeyphrases());
        dto.setDocumentType(slide.getDocumentType());
        dto.setDocumentUrl(slide.getDocumentUrl());

        dto.setAuthorId(slide.getAuthor().getId());
        dto.setAuthorName(slide.getAuthor().getSpecialite());
        dto.setAuthorEmail(slide.getAuthor().getEmail());

        dto.setConferenceId(slide.getConference().getId());
        dto.setConferenceName(slide.getConference().getNom());

        return dto;
    }

    public List<Slide> getSlidesByConferenceId(Long conferenceId) {
        return  slideRepository.findByConferenceId(conferenceId);
    }
}
