package com.conferencemgmt.conference_management.dto;

import com.conferencemgmt.conference_management.Enum.DocumentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SlideInfoDTO {
    private Long id;
    private String title;
    private String abstractContent;
    private String keyphrases;
    private DocumentType documentType;
    private String documentUrl;

    // Author details
    private Long authorId;
    private String authorName;
    private String authorEmail;

    // Conference details
    private Long conferenceId;
    private String conferenceName;
}
