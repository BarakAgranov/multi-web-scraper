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

    /**
     * Sample usage: "curl $HOST:$PORT/search/1".
     *
     * @param search A JSON representation of the new Search object
     */
    @Operation(
            summary = "${api.search.search-service.get-search.description}",
            description = "${api.search.search-service.get-search.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "801", description = "${api.responseCodes.alreadyExists.description}")
    })
    @PostMapping(
            value = "/search",
            produces = "application/json")
    void createSearch(@RequestBody SearchDto search);

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
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "801", description = "${api.responseCodes.alreadyExists.description}")
    })
    @PutMapping(
            value = "/search",
            produces = "application/json")
    void updateSearch(@RequestBody SearchDto search);

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
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "801", description = "${api.responseCodes.alreadyExists.description}")
    })
    @DeleteMapping(
            value = "/search/{searchId}",
            produces = "application/json")
    void deleteSearch(@PathVariable int searchId);

    /**
     * Sample usage: "curl $HOST:$PORT/search".
     *
     * @return List of searches, if found, else null
     */
    @Operation(
            summary = "${api.search.search-service.get-search.description}",
            description = "${api.search.search-service.get-search.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
    })
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
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
    })
    @GetMapping(
            value = "/search/{searchId}",
            produces = "application/json"
    )
    SearchDto getSearch(@PathVariable int searchId);
}
