package com.conferencemgmt.conference_management.model;

import com.conferencemgmt.conference_management.Enum.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

@Table(name = "Conferencier")
public class Conferencier extends Personne {
    private String specialite;

    public Conferencier() {
        this.setRole(Role.ROLE_CONFERENCIER);
    }
}

