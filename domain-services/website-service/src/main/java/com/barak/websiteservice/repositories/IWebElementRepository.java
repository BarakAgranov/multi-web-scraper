package com.barak.websiteservice.repositories;

import com.barak.api.website.web_element_api.WebElementDto;
import com.barak.websiteservice.entities.WebElementEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWebElementRepository extends CrudRepository<WebElementEntity, Integer> {

    boolean existsByName(String name);

    @Query("select new com.barak.api.website.web_element_api.WebElementDto(w.id, w.name, w.description, w.identifier, w.identifierType, w.webPageEntity.id ) from WebElementEntity w where w.name = ?1")
    WebElementDto getDtoByName(String name);

    @Query("select new com.barak.api.website.web_element_api.WebElementDto(w.id, w.name, w.description, w.identifier, w.identifierType, w.webPageEntity.id ) from WebElementEntity w where w.id = ?1")
    WebElementDto getDtoById(int id);

    @Query("select new com.barak.api.website.web_element_api.WebElementDto(w.id, w.name, w.description, w.identifier, w.identifierType, w.webPageEntity.id ) from WebElementEntity w")
    List<WebElementDto> getAllDto();

    @Query("select new com.barak.api.website.web_element_api.WebElementDto(w.id, w.name, w.description, w.identifier, w.identifierType, w.webPageEntity.id ) from WebElementEntity w where w.webPageEntity.id = ?1")
    List<WebElementDto>getAllByPage(int id);
}
