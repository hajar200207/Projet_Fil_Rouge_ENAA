package com.conferencemgmt.conference_management.repository;

import com.conferencemgmt.conference_management.model.Poster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosterRepository extends JpaRepository<Poster, Long> {

    List<Poster> findByConferenceId(Long conferenceId);
}
