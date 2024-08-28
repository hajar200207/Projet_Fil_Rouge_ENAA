package com.conferencemgmt.conference_management.service;

import com.conferencemgmt.conference_management.dto.ArticleDTO;
import com.conferencemgmt.conference_management.model.Articles;
import com.conferencemgmt.conference_management.model.CommitScientifique;
import com.conferencemgmt.conference_management.repository.ArticleRepository;
import com.conferencemgmt.conference_management.repository.CommitScientifiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommitScientifiqueRepository commitScientifiqueRepository;

    public List<ArticleDTO> getAllArticles() {
        return articleRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ArticleDTO getArticleById(Long id) {
        Articles article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        return convertToDTO(article);
    }

    public ArticleDTO createArticle(ArticleDTO articleDTO) {
        CommitScientifique commitScientifique = commitScientifiqueRepository.findById(articleDTO.getCommitScientifiqueId())
                .orElseThrow(() -> new RuntimeException("CommitScientifique not found"));

        Articles article = new Articles();
        article.setTitre(articleDTO.getTitre());
        article.setContenu(articleDTO.getContenu());
        article.setEtat(articleDTO.getEtat());
        article.setCommitScientifique(commitScientifique);

        Articles savedArticle = articleRepository.save(article);
        return convertToDTO(savedArticle);
    }

    public ArticleDTO updateArticle(Long id, ArticleDTO articleDTO) {
        Articles article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));

        article.setTitre(articleDTO.getTitre());
        article.setContenu(articleDTO.getContenu());
        article.setEtat(articleDTO.getEtat());

        Articles updatedArticle = articleRepository.save(article);
        return convertToDTO(updatedArticle);
    }

    public void deleteArticle(Long id) {
        Articles article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        articleRepository.delete(article);
    }

    private ArticleDTO convertToDTO(Articles article) {
        ArticleDTO dto = new ArticleDTO();
        dto.setId(article.getId());
        dto.setTitre(article.getTitre());
        dto.setContenu(article.getContenu());
        dto.setEtat(article.getEtat());

        CommitScientifique commitScientifique = article.getCommitScientifique();
        if (commitScientifique != null) {
            dto.setCommitScientifiqueId(commitScientifique.getId());
            dto.setCommitScientifiqueNom(commitScientifique.getNom());
            dto.setCommitScientifiquePrenom(commitScientifique.getPrenom());
            dto.setDomaineExpertise(commitScientifique.getDomaineExpertise());
        }

        return dto;
    }
}

