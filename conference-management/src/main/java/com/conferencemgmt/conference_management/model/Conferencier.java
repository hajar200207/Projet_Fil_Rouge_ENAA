package com.conferencemgmt.conference_management.model;

import com.conferencemgmt.conference_management.Enum.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

@Table(name = "Conferencier")
public class Conferencier extends Personne {

    private String specialite;
    @OneToMany(mappedBy = "author")
    private List<Slide> slides;
    public Conferencier() {
        this.setRole(Role.ROLE_CONFERENCIER);
    }
}

