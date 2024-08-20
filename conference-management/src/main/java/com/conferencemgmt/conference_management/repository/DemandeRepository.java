package com.conferencemgmt.conference_management.repository;

import com.conferencemgmt.conference_management.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {
}

