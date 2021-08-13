package com.barak.websiteservice.logic.mappers;

import com.barak.api.website.action_condition_api.ActionConditionDto;
import com.barak.websiteservice.entities.ActionConditionEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IActionConditionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.description", target = "description")
    @Mapping(source = "dto.conditionType", target = "conditionType")
    @Mapping(source = "dto.millisecondsToWait", target = "millisecondsToWait")
    @Mapping(source = "dto.millisecondsToCheck", target = "millisecondsToCheck")
    @Mapping(target = "elementActions", ignore = true)
    ActionConditionEntity dtoToActionConditionUpdate(ActionConditionDto dto, @MappingTarget ActionConditionEntity entity);


    @Mapping(target = "id", ignore = true)
    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.description", target = "description")
    @Mapping(source = "dto.conditionType", target = "conditionType")
    @Mapping(source = "dto.millisecondsToWait", target = "millisecondsToWait")
    @Mapping(source = "dto.millisecondsToCheck", target = "millisecondsToCheck")
    @Mapping(target = "elementActions", ignore = true)
    ActionConditionEntity dtoToActionConditionCreate(ActionConditionDto dto);


}
