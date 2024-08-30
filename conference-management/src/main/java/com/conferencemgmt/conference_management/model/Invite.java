package com.conferencemgmt.conference_management.model;

import com.conferencemgmt.conference_management.Enum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor

@Entity
@Table(name = "invite")
public class Invite extends Personne {
    private String organisation;
    @ManyToMany(mappedBy = "invites")
    private List<Conference> conferences;

    @OneToMany(mappedBy = "invite", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;
    public Invite() {
        this.setRole(Role.ROLE_INVITE);
    }
}
