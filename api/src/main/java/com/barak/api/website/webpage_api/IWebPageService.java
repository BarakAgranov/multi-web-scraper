package com.barak.api.website.webpage_api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "WebPageService", description =
        "REST API for operating CRUD operations on web page")
public interface IWebPageService {

    /**
     * Sample usage: "curl $HOST:$PORT/page/1".
     *
     * @param webPage A JSON representation of the new Page object
     */
    @Operation(
            summary = "${api.page-service.create-page.description}",
            description = "${api.page-service.create-page.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "801", description = "${api.responseCodes.alreadyExists.description}")
    })
    @PostMapping(
            value = "/page",
            produces = "application/json")
    void createWebPage(@RequestBody WebPageDto webPage);

    /**
     * Sample usage: "curl $HOST:$PORT/page/1".
     *
     * @param webPage A JSON representation of an updated Page
     */
    @Operation(
            summary = "${api.page-service.update-page.description}",
            description = "${api.page-service.update-page.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
    })
    @PutMapping(
            value = "/page",
            produces = "application/json")
    void updateWebPage(@RequestBody WebPageDto webPage);

    /**
     * Sample usage: "curl $HOST:$PORT/page/1".
     *
     * @param webPageId id of the page
     */
    @Operation(
            summary = "${api.page-service.delete-page.description}",
            description = "${api.page-service.delete-page.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "801", description = "${api.responseCodes.alreadyExists.description}")
    })
    @DeleteMapping(
            value = "/page/{webPageId}",
            produces = "application/json")
    void deleteWebPage(@PathVariable int webPageId);

    /**
     * Sample usage: "curl $HOST:$PORT/page".
     *
     * @return List of pages, if found, else null
     */
    @Operation(
            summary = "${api.page-service.get-page.description}",
            description = "${api.page-service.get-page.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
    })
    @GetMapping(
            value = "/page",
            produces = "application/json"
    )
    List<WebPageDto> getAllWebPages();

    /**
     * Sample usage: "curl $HOST:$PORT/page".
     *
     * @return page info, if found, else null
     */
    @Operation(
            summary = "${api.page-service.get-page.description}",
            description = "${api.page-service.get-page.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
    })
    @GetMapping(
            value = "/page/{webPageId}",
            produces = "application/json"
    )
    WebPageDto getWebPage(@PathVariable int webPageId);
}
