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
@Table(name = "CommitOrganisation")
public class CommitOrganisation extends Personne {
    private String fonction;

    public CommitOrganisation() {
        this.setRole(Role.ROLE_COMMIT_ORGANISATION);
    }
}
