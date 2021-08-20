package com.barak.api.search.search_api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "search-service", description =
        "REST API for composing website information into details about a search.")
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
    void deleteSearch(@PathVariable int searchId);

    @GetMapping(
            value = "/search",
            produces = "application/json"
    )
    List<SearchDto> getAllSearches();

    /**
     * Sample usage: "curl $HOST:$PORT/search/1".
     *
     * @param searchId id of the search
     * @return the search info, if found, else null
     */
    @Operation(
            summary = "${api.search.search-service.get-search.description}",
            description = "${api.search.search-service.get-search.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.badRequest.description}"),
            @ApiResponse(responseCode = "801", description = "${api.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "802", description = "${api.responseCodes.unprocessableEntity.description}")
    })
    @GetMapping(
            value = "/search/{searchId}",
            produces = "application/json"
    )
    SearchDto getSearch(@PathVariable int searchId);
}
