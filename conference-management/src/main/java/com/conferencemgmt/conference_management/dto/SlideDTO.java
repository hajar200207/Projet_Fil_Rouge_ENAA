package com.conferencemgmt.conference_management.dto;

import com.conferencemgmt.conference_management.Enum.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SlideDTO {
    private Long id;
    private String title;
    private String abstractContent;
    private String keyphrases;
    private DocumentType documentType;
    private String documentUrl;
    private Long authorId;
    private Long conferenceId;
}
