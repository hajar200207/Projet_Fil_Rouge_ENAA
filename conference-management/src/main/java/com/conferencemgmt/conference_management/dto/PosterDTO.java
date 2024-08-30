package com.conferencemgmt.conference_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PosterDTO {
    private Long id;
    private String title;
    private String abstractContent;

}
