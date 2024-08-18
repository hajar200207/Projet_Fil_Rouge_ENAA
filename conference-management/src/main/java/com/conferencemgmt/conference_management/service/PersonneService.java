package com.conferencemgmt.conference_management.service;


import com.conferencemgmt.conference_management.model.Admin;
import com.conferencemgmt.conference_management.model.Personne;
import com.conferencemgmt.conference_management.repository.PersonneRepository;
import com.conferencemgmt.conference_management.security.JwtAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneService implements UserDetailsService {

    @Autowired
    private PersonneRepository personneRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtAuth jwtAuth;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return personneRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }

    public Personne register(Personne personne) {
        if (personneRepository.findByEmail(personne.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
        personne.setMotDePasse(passwordEncoder.encode(personne.getMotDePasse()));
        return personneRepository.save(personne);
    }


    public Optional<String> login(String email, String password) {
        Optional<Personne> personneOpt = personneRepository.findByEmail(email);
        if (personneOpt.isPresent() && passwordEncoder.matches(password, personneOpt.get().getMotDePasse())) {
            Personne personne = personneOpt.get();
            String token = jwtAuth.generateJwtToken(personne); // Pass the Personne object
            return Optional.of(token);
        }
        return Optional.empty();
    }
    public List<Personne> getAllPersonnes() {
        return personneRepository.findAll();
    }

    public void deletePersonne(Long id) {
        personneRepository.deleteById(id);
    }

    public Optional<Personne> updatePersonne(Long id, Personne updatedPersonne) {
        return personneRepository.findById(id)
                .map(personne -> {
                    personne.setNom(updatedPersonne.getNom());
                    personne.setPrenom(updatedPersonne.getPrenom());
                    personne.setEmail(updatedPersonne.getEmail());
                    if (updatedPersonne.getMotDePasse() != null && !updatedPersonne.getMotDePasse().isEmpty()) {
                        personne.setMotDePasse(passwordEncoder.encode(updatedPersonne.getMotDePasse()));
                    }
                    personne.setRole(updatedPersonne.getRole());
                    personne.setRoles(updatedPersonne.getRoles());
                    return personneRepository.save(personne);
                });
    }

    public void createAdminUserIfNotExist() {
        String adminEmail = "admin@example.com";
        Optional<Personne> existingAdmin = personneRepository.findByEmail(adminEmail);

        if (existingAdmin.isEmpty()) {
            Admin admin = new Admin();
            admin.setEmail(adminEmail);
            admin.setMotDePasse(passwordEncoder.encode("admin"));
            admin.setDepartement("Admin Department");
            personneRepository.save(admin);
        }
    }

}