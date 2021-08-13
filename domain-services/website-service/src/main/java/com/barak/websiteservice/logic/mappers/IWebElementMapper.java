package com.barak.websiteservice.logic.mappers;

import com.barak.api.website.web_element_api.WebElementDto;
import com.barak.websiteservice.entities.WebElementEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IWebElementMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.description", target = "description")
    @Mapping(source = "dto.identifier", target = "identifier")
    @Mapping(source = "dto.identifierType", target = "identifierType")
    @Mapping(target = "webPageEntity", ignore = true)
    @Mapping(target = "actionEntities", ignore = true)
    WebElementEntity dtoToWebElementUpdate(WebElementDto dto, @MappingTarget WebElementEntity entity);


    @Mapping(target = "id", ignore = true)
    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.description", target = "description")
    @Mapping(source = "dto.identifier", target = "identifier")
    @Mapping(source = "dto.identifierType", target = "identifierType")
    @Mapping(target = "webPageEntity", ignore = true)
    @Mapping(target = "actionEntities", ignore = true)
    WebElementEntity dtoToWebElementCreate(WebElementDto dto);
}
