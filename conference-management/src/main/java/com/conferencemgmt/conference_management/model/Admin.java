package com.conferencemgmt.conference_management.model;


import com.conferencemgmt.conference_management.Enum.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "`admin`")
public class Admin extends Personne {
    private String departement;

    public Admin() {
        this.setRole(Role.ROLE_ADMIN);
    }
}






