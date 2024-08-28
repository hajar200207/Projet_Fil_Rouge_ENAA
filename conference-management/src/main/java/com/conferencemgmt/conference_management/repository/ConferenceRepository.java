package com.conferencemgmt.conference_management.repository;

import com.conferencemgmt.conference_management.model.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {



}
