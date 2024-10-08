package com.conferencemgmt.conference_management.controller;


import com.conferencemgmt.conference_management.model.Conferencier;
import com.conferencemgmt.conference_management.model.Invite;
import com.conferencemgmt.conference_management.model.Personne;
import com.conferencemgmt.conference_management.model.ResetPasswordRequest;
import com.conferencemgmt.conference_management.security.JwtAuth;
import com.conferencemgmt.conference_management.service.PersonneService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/personnes")
public class PersonneController {

    @Autowired
    private PersonneService personneService;
@Autowired

private JwtAuth jwtAuth;
    @PostMapping("/register")
    public ResponseEntity<Personne> register(@RequestBody Personne personne) {

        return ResponseEntity.ok(personneService.register(personne));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestParam String email, @RequestParam String password) {

        return personneService.login(email, password)
                .map(token -> {
                    // Extract the role from the token
                    Claims claims = Jwts.parser()
                            .setSigningKey(jwtAuth.getSecretKey().getBytes(StandardCharsets.UTF_8))
                            .parseClaimsJws(token)
                            .getBody();

                    Map<String, Object> response = new HashMap<>();
                    response.put("token", token);
                    response.put("role", claims.get("role"));
                    response.put("conferencierId", claims.get("conferencierId"));
                    response.put("commitOrganisationId", claims.get("commitOrganisationId"));
                    response.put("invite", claims.get("inviteId"));

                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.badRequest().build());
    }





    @GetMapping
    public List<Personne> getAllPersonnes() {
        return personneService.getAllPersonnes();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonne(@PathVariable Long id) {
        personneService.deletePersonne(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personne> updatePersonne(@PathVariable Long id, @RequestBody Personne personne) {
        return personneService.updatePersonne(id, personne)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
        return personneService.sendPasswordResetEmail(resetPasswordRequest.getEmail());
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestParam String email,
                                                @RequestParam String newPassword) {
        if (email == null || email.isEmpty()) {
            return ResponseEntity.badRequest().body("Email is required");
        }

        if (newPassword == null || newPassword.isEmpty()) {
            return ResponseEntity.badRequest().body("New password is required");
        }

        boolean success = personneService.resetPasswordWithoutToken(email, newPassword);
        if (success) {
            return ResponseEntity.ok("Password reset successfully");
        }
        return ResponseEntity.badRequest().body("Error resetting password");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Personne> getPersonneById(@PathVariable Long id) {
        return personneService.getPersonneById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/conferenciers/{conferencierId}")
    public ResponseEntity<Conferencier> getConferencierById(@PathVariable Long conferencierId) {
        Optional<Conferencier> conferencier = personneService.getConferencierById(conferencierId);
        return conferencier.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/invites/{inviteId}")
    public ResponseEntity<Invite> getInviteById(@PathVariable Long inviteId) {
        Optional<Invite> invite = personneService.getInviteById(inviteId);
        return invite.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
