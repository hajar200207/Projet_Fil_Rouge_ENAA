package com.conferencemgmt.conference_management.repository;

import com.conferencemgmt.conference_management.model.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Articles, Long> {
}
