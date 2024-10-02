package com.conferencemgmt.conference_management.repository;

import com.conferencemgmt.conference_management.model.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {



}
