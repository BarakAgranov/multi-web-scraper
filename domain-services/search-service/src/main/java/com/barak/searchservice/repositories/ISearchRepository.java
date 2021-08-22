package com.barak.searchservice.repositories;

import com.barak.api.search.search_api.SearchDto;
import com.barak.searchservice.entities.SearchEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISearchRepository extends CrudRepository<SearchEntity, Integer> {

    boolean existsByName(String name);

    @Query("select new com.barak.api.search.search_api.SearchDto(s.id, s.name, s.description, s.websiteId, s.websiteName, s.preferredBrowser, s.websiteUrl) from SearchEntity s where s.name = ?1")
    SearchDto getDtoByName(String name);

    @Query("select new com.barak.api.search.search_api.SearchDto(s.id, s.name, s.description, s.websiteId, s.websiteName, s.preferredBrowser, s.websiteUrl) from SearchEntity s where s.id = ?1")
    SearchDto getDtoById(int id);

    @Query("select new com.barak.api.search.search_api.SearchDto(s.id, s.name, s.description, s.websiteId, s.websiteName, s.preferredBrowser, s.websiteUrl) from SearchEntity s")
    List<SearchDto> getAllDto();

    @Query("select new com.barak.api.search.search_api.SearchDto(s.id, s.name, s.description, s.websiteId, s.websiteName, s.preferredBrowser, s.websiteUrl) from SearchEntity s where s.websiteUrl = ?1")
    List<SearchDto> getAllByWebsiteUrl(String  url);
}
