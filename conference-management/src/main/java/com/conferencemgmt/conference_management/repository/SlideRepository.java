package com.conferencemgmt.conference_management.repository;

import com.conferencemgmt.conference_management.model.Slide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface SlideRepository extends JpaRepository<Slide, Long> {
    List<Slide> findByConferenceId(Long conferenceId);
}
