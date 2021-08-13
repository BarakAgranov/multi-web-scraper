package com.barak.api.search.search_api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ISearchService {

    @PostMapping(
            value = "/search",
            produces = "application/json")
    void createSearch(@RequestBody SearchDto search);

    @PutMapping(
            value = "/search",
            produces = "application/json")
    void updateSearch(@RequestBody SearchDto search);

    @DeleteMapping(
            value = "/search/{searchId}",
            produces = "application/json")
    void deleteSearch(@PathVariable long searchId);

    @GetMapping(
            value = "/search",
            produces = "application/json"
    )
    List<SearchDto> getAllSearches();

    @GetMapping(
            value = "/search/{searchId}",
            produces = "application/json"
    )
    SearchDto getSearch(@PathVariable long searchId);
}
