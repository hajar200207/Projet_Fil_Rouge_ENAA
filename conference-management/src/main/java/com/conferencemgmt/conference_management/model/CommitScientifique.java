package com.conferencemgmt.conference_management.model;

import com.conferencemgmt.conference_management.Enum.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)

@Table(name = "CommitScientifique")
public class CommitScientifique extends Personne {
    private String domaineExpertise;

    public CommitScientifique() {
        this.setRole(Role.ROLE_COMMIT_SCIENTIFIQUE);
    }
}
