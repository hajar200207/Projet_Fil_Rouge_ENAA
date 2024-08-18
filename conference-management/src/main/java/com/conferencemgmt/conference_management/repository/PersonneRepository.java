package com.conferencemgmt.conference_management.repository;

import java.util.List;
import java.util.Optional;

import com.conferencemgmt.conference_management.Enum.Role;
import com.conferencemgmt.conference_management.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {

    Optional<Personne> findByEmail(String email);

    List<Personne> findAllByRole(Role role);
}

