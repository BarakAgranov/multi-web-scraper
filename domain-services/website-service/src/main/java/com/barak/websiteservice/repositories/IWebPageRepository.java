package com.barak.websiteservice.repositories;

import com.barak.api.website.webpage_api.WebPageDto;
import com.barak.websiteservice.entities.WebPageEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWebPageRepository extends CrudRepository<WebPageEntity, Integer> {

    boolean existsByName(String name);

    boolean existsByUrl(String url);

    @Query("select new com.barak.api.website.webpage_api.WebPageDto(w.id, w.name, w.description, w.url, w.webSiteEntity.id) from WebPageEntity w where w.name = ?1")
    WebPageDto getDtoByName(String name);

    @Query("select new com.barak.api.website.webpage_api.WebPageDto(w.id, w.name, w.description, w.url, w.webSiteEntity.id) from WebPageEntity w where w.id = ?1")
    WebPageDto getDtoById(int id);

    @Query("select new com.barak.api.website.webpage_api.WebPageDto(w.id, w.name, w.description, w.url, w.webSiteEntity.id) from WebPageEntity w")
    List<WebPageDto> getAllDto();

    @Query("select new com.barak.api.website.webpage_api.WebPageDto(w.id, w.name, w.description, w.url, w.webSiteEntity.id) from WebPageEntity w where w.webSiteEntity.id = ?1")
    List<WebPageDto> getAllBySite(int id);
}
