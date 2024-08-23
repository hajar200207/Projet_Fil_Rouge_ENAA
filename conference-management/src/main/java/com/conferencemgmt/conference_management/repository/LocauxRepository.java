package com.conferencemgmt.conference_management.repository;


import com.conferencemgmt.conference_management.model.Locaux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocauxRepository extends JpaRepository<Locaux, Long> {

}
