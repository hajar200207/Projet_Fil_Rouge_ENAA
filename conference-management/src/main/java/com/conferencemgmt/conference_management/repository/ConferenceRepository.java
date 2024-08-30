package com.conferencemgmt.conference_management.repository;

import com.conferencemgmt.conference_management.model.Conference;
import com.conferencemgmt.conference_management.model.Poster;
import com.conferencemgmt.conference_management.model.Slide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {


    boolean existsByNomAndDateDebut(String nom, LocalDate dateDebut);
    @Query("SELECT s FROM Slide s WHERE s.conference.id = :conferenceId")
    List<Slide> findSlidesByConferenceId(@Param("conferenceId") Long id);



    @Query("SELECT p FROM Poster p WHERE p.conference.id = :conferenceId")
    List<Poster> findPostersByConferenceId(@Param("conferenceId") Long id);
}
