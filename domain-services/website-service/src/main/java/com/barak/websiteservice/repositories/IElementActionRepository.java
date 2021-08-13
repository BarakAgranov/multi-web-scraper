package com.barak.websiteservice.repositories;

import com.barak.api.website.element_action_api.ElementActionDto;
import com.barak.websiteservice.entities.ElementActionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IElementActionRepository extends CrudRepository<ElementActionEntity, Integer> {

    boolean existsByName(String name);

    @Query("select new com.barak.api.website.element_action_api.ElementActionDto(e.id, e.name, e.description, e.actionType, e.actionInput) from ElementActionEntity e where e.name = ?1")
    ElementActionDto getDtoByName(String name);

    @Query("select new com.barak.api.website.element_action_api.ElementActionDto(e.id, e.name, e.description, e.actionType, e.actionInput) from ElementActionEntity e where e.id = ?1")
    ElementActionDto getDtoById(int id);

    @Query("select new com.barak.api.website.element_action_api.ElementActionDto(e.id, e.name, e.description,  e.actionType, e.actionInput) from ElementActionEntity e")
    List<ElementActionDto> getAllDto();
}
