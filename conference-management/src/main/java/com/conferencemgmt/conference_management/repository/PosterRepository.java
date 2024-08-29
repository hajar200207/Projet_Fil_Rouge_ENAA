package com.conferencemgmt.conference_management.repository;

import com.conferencemgmt.conference_management.model.Poster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosterRepository extends JpaRepository<Poster, Long> {

}
