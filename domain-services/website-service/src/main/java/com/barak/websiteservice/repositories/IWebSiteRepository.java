package com.barak.websiteservice.repositories;

import com.barak.api.website.website_api.WebSiteDto;
import com.barak.websiteservice.entities.WebSiteEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWebSiteRepository extends CrudRepository<WebSiteEntity, Integer> {

    boolean existsByName(String name);

    boolean existsByUrl(String url);

    @Query("select new com.barak.api.website.website_api.WebSiteDto(w.id, w.name, w.description, w.url, w.preferredBrowser ) from WebSiteEntity w where w.name = ?1")
    WebSiteDto getDtoByName(String name);

    @Query("select new com.barak.api.website.website_api.WebSiteDto(w.id, w.name, w.description, w.url, w.preferredBrowser ) from WebSiteEntity w where w.id = ?1")
    WebSiteDto getDtoById(int id);

    @Query("select new com.barak.api.website.website_api.WebSiteDto(w.id, w.name, w.description, w.url, w.preferredBrowser ) from WebSiteEntity w")
    List<WebSiteDto> getAllDto();




}
