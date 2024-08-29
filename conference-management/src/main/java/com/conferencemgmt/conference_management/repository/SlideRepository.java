package com.conferencemgmt.conference_management.repository;

import com.conferencemgmt.conference_management.model.Slide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlideRepository extends JpaRepository<Slide, Long> {
}
