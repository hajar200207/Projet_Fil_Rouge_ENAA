package com.conferencemgmt.conference_management.model;

import com.conferencemgmt.conference_management.Enum.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

@Entity
@Table(name = "Invite")
public class Invite extends Personne {
    private String organisation;

    public Invite() {
        this.setRole(Role.ROLE_INVITE);
    }
}
