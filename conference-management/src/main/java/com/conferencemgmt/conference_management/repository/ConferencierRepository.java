package com.conferencemgmt.conference_management.repository;

import com.conferencemgmt.conference_management.model.Conferencier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferencierRepository extends JpaRepository<Conferencier, Long> {}
