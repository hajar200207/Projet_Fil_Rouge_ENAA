package com.conferencemgmt.conference_management.dto;



import com.conferencemgmt.conference_management.Enum.EtatArticle;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDTO {
    private Long id;
    private String titre;
    private String contenu;
    private EtatArticle etat;

    private Long commitScientifiqueId;
    private String commitScientifiqueNom;
    private String commitScientifiquePrenom;
    private String domaineExpertise;
}
