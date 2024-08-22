package com.conferencemgmt.conference_management.repository;

import com.conferencemgmt.conference_management.model.Conferencier;
import com.conferencemgmt.conference_management.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {
    List<Demande> findByConferencier(Conferencier conferencier);

}

