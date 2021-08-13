package com.barak.searchservice.logic.mappers;

import com.barak.api.search.search_api.SearchDto;
import com.barak.searchservice.entities.SearchEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ISearchMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.description", target = "description")
    @Mapping(target = "websiteId", ignore = true)
    @Mapping(source = "dto.websiteName", target = "websiteName")
    @Mapping(source = "dto.preferredBrowser", target = "preferredBrowser")
    @Mapping(source = "dto.websiteUrl", target = "websiteUrl")
    @Mapping(target = "searchSteps", ignore = true)
    SearchEntity dtoToSearchUpdate(SearchDto dto, @MappingTarget SearchEntity entity);


    @Mapping(target = "id", ignore = true)
    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.description", target = "description")
    @Mapping(source = "dto.websiteId", target = "websiteId")
    @Mapping(source = "dto.websiteName", target = "websiteName")
    @Mapping(source = "dto.preferredBrowser", target = "preferredBrowser")
    @Mapping(source = "dto.websiteUrl", target = "websiteUrl")
    @Mapping(target = "searchSteps", ignore = true)
    SearchEntity dtoToSearchCreate(SearchDto dto);


}
