package com.conferencemgmt.conference_management.service;


import com.conferencemgmt.conference_management.model.Admin;
import com.conferencemgmt.conference_management.model.Personne;
import com.conferencemgmt.conference_management.repository.PersonneRepository;
import com.conferencemgmt.conference_management.security.JwtAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonneService implements UserDetailsService {

    @Autowired
    private PersonneRepository personneRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtAuth jwtAuth;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private JavaMailSender javaMailSender;

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
    public void initiatePasswordReset(String email) {
        Optional<Personne> personneOpt = personneRepository.findByEmail(email);
        if (personneOpt.isPresent()) {
            Personne personne = personneOpt.get();
            String token = UUID.randomUUID().toString();
            personne.setResetToken(token);
            personne.setResetTokenExpiry(LocalDateTime.now().plusHours(1));
            personneRepository.save(personne);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Password Reset Request");
            message.setText("To reset your password, please use the following token: " + token);
            mailSender.send(message);
        }
    }

    public boolean validateResetToken(String email, String token) {
        Optional<Personne> personneOpt = personneRepository.findByEmail(email);
        if (personneOpt.isPresent()) {
            Personne personne = personneOpt.get();
            return token.equals(personne.getResetToken()) &&
                    LocalDateTime.now().isBefore(personne.getResetTokenExpiry());
        }
        return false;
    }

    public boolean resetPasswordWithoutToken(String email, String newPassword) {
        Optional<Personne> personneOpt = personneRepository.findByEmail(email);
        if (personneOpt.isEmpty()) {
            return false;
        }

        Personne personne = personneOpt.get();

        String hashedPassword = passwordEncoder.encode(newPassword);
        personne.setMotDePasse(hashedPassword); // Correct method to set the password

        personneRepository.save(personne);
        return true;
    }


    public ResponseEntity<String> sendPasswordResetEmail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Password Reset Request");

        // Définir le nom d'affichage ici
        message.setFrom("welcom conference-management <ouadihajar2002@gmail.com>");

        message.setText("To reset your password, please follow this link: [http://localhost:4200/reset-password]");

        javaMailSender.send(message);

        return ResponseEntity.ok("Password reset email sent");
    }

}