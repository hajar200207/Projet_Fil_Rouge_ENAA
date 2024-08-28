package com.conferencemgmt.conference_management.model;

import com.conferencemgmt.conference_management.Enum.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")

@JsonIgnoreProperties({"programmes", "locauxList", "posters"})
@Table(name = "CommitOrganisation")
public class CommitOrganisation extends Personne {

    private String fonction;

    @OneToMany(mappedBy = "commitOrganisation")
    private List<Programme> programmes;

    @OneToMany(mappedBy = "commitOrganisation")
    private List<Locaux> locauxList;

    @OneToMany(mappedBy = "commitOrganisation")
    private List<Poster> posters;

    public CommitOrganisation() {
        this.setRole(Role.ROLE_COMMIT_ORGANISATION);
    }
}
