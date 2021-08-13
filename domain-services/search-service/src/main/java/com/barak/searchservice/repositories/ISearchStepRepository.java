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

    @Query("select new com.barak.api.search.search_step_api.SearchStepDto(s.id, s.name, s.pageName, s.pageUrl, s.elementName, s.elementIdentifier, s.elementIdentifierType," +
            " s.actionName, s.actionType, s.actionInput, s.conditionName, s.conditionType, s.millisecondsToWait, s.millisecondsToCheck, s.search.id) from SearchStepEntity s where s.name = ?1")
    SearchStepDto getDtoByName(String name);

    @Query("select new com.barak.api.search.search_step_api.SearchStepDto(s.id, s.name, s.pageName, s.pageUrl, s.elementName, s.elementIdentifier, s.elementIdentifierType," +
            " s.actionName, s.actionType, s.actionInput, s.conditionName, s.conditionType, s.millisecondsToWait, s.millisecondsToCheck, s.search.id) from SearchStepEntity s where s.id = ?1")
    SearchStepDto getDtoById(long id);

    @Query("select new com.barak.api.search.search_step_api.SearchStepDto(s.id, s.name, s.pageName, s.pageUrl, s.elementName, s.elementIdentifier, s.elementIdentifierType," +
            " s.actionName, s.actionType, s.actionInput, s.conditionName, s.conditionType, s.millisecondsToWait, s.millisecondsToCheck, s.search.id) from SearchStepEntity s")
    List<SearchStepDto> getAllDto();

    @Query("select new com.barak.api.search.search_step_api.SearchStepDto(s.id, s.name, s.pageName, s.pageUrl, s.elementName, s.elementIdentifier, s.elementIdentifierType," +
            " s.actionName, s.actionType, s.actionInput, s.conditionName, s.conditionType, s.millisecondsToWait, s.millisecondsToCheck, s.search.id) from SearchStepEntity s where s.search.id = ?1")
    List<SearchStepDto> getAllBySearch(int id);

}
