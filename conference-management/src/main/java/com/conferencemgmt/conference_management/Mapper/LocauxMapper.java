package com.conferencemgmt.conference_management.Mapper;

import com.conferencemgmt.conference_management.dto.LocauxDTO;
import com.conferencemgmt.conference_management.model.Locaux;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocauxMapper {

    @Mapping(source = "commitOrganisation.id", target = "commitOrganisationId")
    LocauxDTO toDto(Locaux locaux);

    @Mapping(source = "commitOrganisationId", target = "commitOrganisation.id")
    Locaux toEntity(LocauxDTO locauxDTO);

    List<LocauxDTO> toDtoList(List<Locaux> locauxList);

    List<Locaux> toEntityList(List<LocauxDTO> locauxDTOList);
}
