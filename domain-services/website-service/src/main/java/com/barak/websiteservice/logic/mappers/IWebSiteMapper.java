package com.barak.websiteservice.logic.mappers;

import com.barak.api.website.website_api.WebSiteDto;
import com.barak.websiteservice.entities.WebSiteEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IWebSiteMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.url", target = "url")
    @Mapping(source = "dto.description", target = "description")
    @Mapping(source = "dto.preferredBrowser", target = "preferredBrowser")
    @Mapping(target = "webPages", ignore = true)
    WebSiteEntity dtoToWebSiteUpdate(WebSiteDto dto, @MappingTarget WebSiteEntity entity);


    @Mapping(target = "id", ignore = true)
    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.url", target = "url")
    @Mapping(source = "dto.description", target = "description")
    @Mapping(source = "dto.preferredBrowser", target = "preferredBrowser")
    @Mapping(target = "webPages", ignore = true)
    WebSiteEntity dtoToWebSiteCreate(WebSiteDto dto);
}
