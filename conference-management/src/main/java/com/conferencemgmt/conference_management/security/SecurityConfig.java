package com.conferencemgmt.conference_management.security;

import com.conferencemgmt.conference_management.service.PersonneService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthorizationFilter jwtAuthorizationFilter;
    private final PersonneService personneService;

    public SecurityConfig(JwtAuthorizationFilter jwtAuthorizationFilter, PersonneService personneService) {
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
        this.personneService = personneService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/personnes/register", "/api/personnes/login").permitAll()
                                .requestMatchers("/api/personnes/**").permitAll()

//                        .requestMatchers("/api/conferences").hasRole("ADMIN")
//                                .requestMatchers("/api/conferences/{id}/posters").hasRole("CONFERENCIER")
//                                .requestMatchers("/api/conferences/{id}/slides").hasRole("CONFERENCIER")
//
//                                .requestMatchers("/api/conferences/{id}/details").hasAnyRole("ADMIN", "CONFERENCIER")
//                                .requestMatchers("/api/conferences/add").hasRole("ADMIN")
//                                .requestMatchers("/api/articles").hasAnyRole("ADMIN", "COMMIT_SCIENTIFIQUE")
//                                .requestMatchers("/api/articles/**").hasAnyRole("ADMIN", "COMMIT_SCIENTIFIQUE")
//                                .requestMatchers("/api/articles").hasRole("CONFERENCIER")
//                                .requestMatchers("/api/articles/**").hasRole("CONFERENCIER")
//                                .requestMatchers("/api/demandes").hasAnyRole("ADMIN", "CONFERENCIER")
//                                .requestMatchers("/api/demandes/**").hasAnyRole("ADMIN", "CONFERENCIER")
//                                .requestMatchers("/api/demandes/conferencier/**").hasRole("CONFERENCIER")
//                                .requestMatchers("/api/demandes/**").hasAnyRole("ADMIN", "CONFERENCIER")
//                                .requestMatchers("/api/locaux/**").hasAnyRole("ADMIN", "COMMIT_ORGANISATION")
//                                .requestMatchers("/api/posters/conference/**").hasAnyRole("ADMIN", "CONFERENCIER")
//                                .requestMatchers("/api/slides/conference/**").hasAnyRole("ADMIN", "CONFERENCIER")
//                                .requestMatchers("/api/posters/**").hasAnyRole("ADMIN", "COMMIT_ORGANISATION")
//                                .requestMatchers("/api/slides/**").hasAnyRole("ADMIN", "COMMIT_ORGANISATION")

                        .anyRequest().permitAll()
                )
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public OrderedHiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new OrderedHiddenHttpMethodFilter();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @PostConstruct
    public void initAdminUser() {
        personneService.createAdminUserIfNotExist();
    }
}

