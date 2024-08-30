package com.conferencemgmt.conference_management.repository;

import com.conferencemgmt.conference_management.model.Invite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface InviteRepository extends JpaRepository<Invite, Long> {


    Invite getInviteById(Long inviteId);
    List<Invite> findByConferencesId(Long conferenceId);

}
