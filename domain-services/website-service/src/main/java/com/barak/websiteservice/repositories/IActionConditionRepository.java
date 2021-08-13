package com.barak.websiteservice.repositories;

import com.barak.api.website.action_condition_api.ActionConditionDto;
import com.barak.websiteservice.entities.ActionConditionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActionConditionRepository extends CrudRepository<ActionConditionEntity, Integer> {

    boolean existsByName(String name);

    @Query("select new com.barak.api.website.action_condition_api.ActionConditionDto(a.id, a.name, a.description, a.conditionType, a.millisecondsToWait, a.millisecondsToCheck ) from ActionConditionEntity a where a.name = ?1")
    ActionConditionDto getDtoByName(String name);

    @Query("select new com.barak.api.website.action_condition_api.ActionConditionDto(a.id, a.name, a.description, a.conditionType, a.millisecondsToWait, a.millisecondsToCheck ) from ActionConditionEntity a where a.id = ?1")
    ActionConditionDto getDtoById(int id);

    @Query("select new com.barak.api.website.action_condition_api.ActionConditionDto(a.id, a.name, a.description, a.conditionType, a.millisecondsToWait, a.millisecondsToCheck ) from ActionConditionEntity a")
    List<ActionConditionDto> getAllDto();
}
