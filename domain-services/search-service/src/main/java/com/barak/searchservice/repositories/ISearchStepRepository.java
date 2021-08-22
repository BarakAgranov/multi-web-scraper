package com.barak.searchservice.repositories;

import com.barak.api.search.search_step_api.SearchStepDto;
import com.barak.searchservice.entities.SearchStepEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISearchStepRepository extends CrudRepository<SearchStepEntity, Long> {

    boolean existsByName(String name);

    @Query("select new com.barak.api.search.search_step_api.SearchStepDto(s.id, s.name, s.pageId, s.pageName, s.pageUrl, s.elementId, s.elementName, s.elementIdentifier, s.elementIdentifierType," +
            " s.actionId, s.actionName, s.actionType, s.actionInput, s.conditionId, s.conditionName, s.conditionType, s.millisecondsToWait, s.millisecondsToCheck) from SearchStepEntity s where s.name = ?1")
    SearchStepDto getDtoByName(String name);

    @Query("select new com.barak.api.search.search_step_api.SearchStepDto(s.id, s.name, s.pageId, s.pageName, s.pageUrl, s.elementId, s.elementName, s.elementIdentifier, s.elementIdentifierType," +
            " s.actionId, s.actionName, s.actionType, s.actionInput, s.conditionId, s.conditionName, s.conditionType, s.millisecondsToWait, s.millisecondsToCheck) from SearchStepEntity s where s.id = ?1")
    SearchStepDto getDtoById(long id);

    @Query("select new com.barak.api.search.search_step_api.SearchStepDto(s.id, s.name, s.pageId, s.pageName, s.pageUrl, s.elementId, s.elementName, s.elementIdentifier, s.elementIdentifierType," +
            " s.actionId, s.actionName, s.actionType, s.actionInput, s.conditionId, s.conditionName, s.conditionType, s.millisecondsToWait, s.millisecondsToCheck) from SearchStepEntity s")
    List<SearchStepDto> getAllDto();

}
