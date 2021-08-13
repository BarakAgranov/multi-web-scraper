package com.barak.websiteservice.logic.mappers;

import com.barak.api.website.element_action_api.ElementActionDto;
import com.barak.websiteservice.entities.ElementActionEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IElementActionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.description", target = "description")
    @Mapping(source = "dto.actionType", target = "actionType")
    @Mapping(source = "dto.actionInput", target = "actionInput")
    @Mapping(target = "actionCondition", ignore = true)
    @Mapping(target = "webElements", ignore = true)
    ElementActionEntity dtoToElementActionUpdate(ElementActionDto dto, @MappingTarget ElementActionEntity entity);


    @Mapping(target = "id", ignore = true)
    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.description", target = "description")
    @Mapping(source = "dto.actionType", target = "actionType")
    @Mapping(source = "dto.actionInput", target = "actionInput")
    @Mapping(target = "actionCondition", ignore = true)
    @Mapping(target = "webElements", ignore = true)
    ElementActionEntity dtoToElementActionCreate(ElementActionDto dto);
}
