package com.conferencemgmt.conference_management.dto;



import com.conferencemgmt.conference_management.Enum.ConferenceSubject;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class ConferenceDetailsDTO {
    private Long id;
    private String conferenceName;
    private String conferencierName;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private ConferenceSubject subject;
}
