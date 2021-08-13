package com.barak.websiteservice.logic.mappers;

import com.barak.api.website.webpage_api.WebPageDto;
import com.barak.websiteservice.entities.WebPageEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IWebPageMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.url", target = "url")
    @Mapping(source = "dto.description", target = "description")
    @Mapping(target = "webSiteEntity", ignore = true)
    @Mapping(target = "webElementEntities", ignore = true)
    WebPageEntity dtoToWebPageUpdate(WebPageDto dto, @MappingTarget WebPageEntity entity);


    @Mapping(target = "id", ignore = true)
    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.url", target = "url")
    @Mapping(source = "dto.description", target = "description")
    @Mapping(target = "webSiteEntity", ignore = true)
    @Mapping(target = "webElementEntities", ignore = true)
    WebPageEntity dtoToWebPageCreate(WebPageDto dto);
}
