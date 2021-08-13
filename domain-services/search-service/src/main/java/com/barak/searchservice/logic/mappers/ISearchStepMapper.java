package com.barak.searchservice.logic.mappers;

import com.barak.api.search.search_step_api.SearchStepDto;
import com.barak.searchservice.entities.SearchStepEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ISearchStepMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "dto.name", target = "name")
    @Mapping(target = "pageId", ignore = true)
    @Mapping(source = "dto.pageName", target = "pageName")
    @Mapping(source = "dto.pageUrl", target = "pageUrl")
    @Mapping(target = "elementId", ignore = true)
    @Mapping(source = "dto.elementName", target = "elementName")
    @Mapping(source = "dto.elementIdentifier", target = "elementIdentifier")
    @Mapping(source = "dto.elementIdentifierType", target = "elementIdentifierType")
    @Mapping(target = "actionId", ignore = true)
    @Mapping(source = "dto.actionName", target = "actionName")
    @Mapping(source = "dto.actionType", target = "actionType")
    @Mapping(source = "dto.actionInput", target = "actionInput")
    @Mapping(target = "conditionId", ignore = true)
    @Mapping(source = "dto.conditionName", target = "conditionName")
    @Mapping(source = "dto.conditionType", target = "conditionType")
    @Mapping(source = "dto.millisecondsToWait", target = "millisecondsToWait")
    @Mapping(source = "dto.millisecondsToCheck", target = "millisecondsToCheck")
    @Mapping(target = "searches", ignore = true)
    SearchStepEntity dtoToSearchStepUpdate(SearchStepDto dto, @MappingTarget SearchStepEntity entity);


    @Mapping(target = "id", ignore = true)
    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.pageId", target = "pageId")
    @Mapping(source = "dto.pageName", target = "pageName")
    @Mapping(source = "dto.pageUrl", target = "pageUrl")
    @Mapping(source = "dto.elementId", target = "elementId")
    @Mapping(source = "dto.elementName", target = "elementName")
    @Mapping(source = "dto.elementIdentifier", target = "elementIdentifier")
    @Mapping(source = "dto.elementIdentifierType", target = "elementIdentifierType")
    @Mapping(source = "dto.actionId", target = "actionId")
    @Mapping(source = "dto.actionName", target = "actionName")
    @Mapping(source = "dto.actionType", target = "actionType")
    @Mapping(source = "dto.actionInput", target = "actionInput")
    @Mapping(source = "dto.conditionId", target = "conditionId")
    @Mapping(source = "dto.conditionName", target = "conditionName")
    @Mapping(source = "dto.conditionType", target = "conditionType")
    @Mapping(source = "dto.millisecondsToWait", target = "millisecondsToWait")
    @Mapping(source = "dto.millisecondsToCheck", target = "millisecondsToCheck")
    @Mapping(target = "searches", ignore = true)
    SearchStepEntity dtoToSearchStepCreate(SearchStepDto dto);


}
