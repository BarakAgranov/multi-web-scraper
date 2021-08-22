package com.barak.api.search.search_step_api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "SearchStepService", description =
        "REST API for composing website components into information about search steps.")
public interface ISearchStepService {

    /**
     * Sample usage: "curl $HOST:$PORT/search/1".
     *
     * @param searchStep A JSON representation of the new Search object
     */
    @Operation(
            summary = "${api.search.search-step-service.create-search-step.description}",
            description = "${api.search.search-step-service.create-search-step.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "801", description = "${api.responseCodes.alreadyExists.description}")
    })
    @PostMapping(
            value = "/step",
            consumes = "application/json")
    void createStep(@RequestBody SearchStepDto searchStep) throws Exception;

    /**
     * Sample usage: "curl $HOST:$PORT/search/1".
     *
     * @param searchStep A JSON representation of a an updated search
     */
    @Operation(
            summary = "${api.search.search-step-service.update-search-step.description}",
            description = "${api.search.search-step-service.update-search-step.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
    })
    @PutMapping(
            value = "/step",
            consumes = "application/json")
    void updateStep(@RequestBody SearchStepDto searchStep) throws Exception;

    /**
     * Sample usage: "curl $HOST:$PORT/search/1".
     *
     * @param stepId id of the search
     */
    @Operation(
            summary = "${api.search.search-step-service.delete-search-step.description}",
            description = "${api.search.search-step-service.delete-search-step.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "801", description = "${api.responseCodes.alreadyExists.description}")
    })
    @DeleteMapping(
            value = "/step/{stepId}")
    void deleteStep(@PathVariable long stepId) throws Exception;

    /**
     * Sample usage: "curl $HOST:$PORT/search".
     *
     * @return List of searches, if found, else null
     */
    @Operation(
            summary = "${api.search.search-step-service.get-search-step.description}",
            description = "${api.search.search-step-service.get-search-step.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
    })
    @GetMapping(
            value = "/step",
            produces = "application/json"
    )
    List<SearchStepDto> getAllSteps() throws Exception;

    /**
     * Sample usage: "curl $HOST:$PORT/search".
     *
     * @return List of searches, if found, else null
     */
    @Operation(
            summary = "${api.search.search-step-service.get-search-step.description}",
            description = "${api.search.search-step-service.get-search-step.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
    })
    @GetMapping(
            value = "/step/{stepId}",
            produces = "application/json"
    )
    SearchStepDto getStep(@PathVariable long stepId) throws Exception;
}
