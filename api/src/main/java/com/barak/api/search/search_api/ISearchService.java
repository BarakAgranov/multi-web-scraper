package com.barak.api.search.search_api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ISearchService {

    @PostMapping(
            value = "/search",
            produces = "application/json")
    void createSearch(@RequestBody SearchDto search) throws Exception;

    @PutMapping(
            value = "/search",
            produces = "application/json")
    void updateSearch(@RequestBody SearchDto search) throws Exception;

    @DeleteMapping(
            value = "/search/{searchId}",
            produces = "application/json")
    void deleteSearch(@PathVariable int searchId) throws Exception;

    @GetMapping(
            value = "/search",
            produces = "application/json"
    )
    List<SearchDto> getAllSearches() throws Exception;

    @GetMapping(
            value = "/search/{searchId}",
            produces = "application/json"
    )
    SearchDto getSearch(@PathVariable int searchId) throws Exception;
}
