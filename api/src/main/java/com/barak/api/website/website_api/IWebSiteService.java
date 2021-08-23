package com.barak.api.website.website_api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "WebSiteService", description =
        "REST API for operating CRUD operations on website")
public interface IWebSiteService {

    /**
     * Sample usage: "curl $HOST:$PORT/website/1".
     *
     * @param webSite A JSON representation of the new Website object
     */
    @Operation(
            summary = "${api.website-service.create-website.description}",
            description = "${api.website-service.create-website.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "801", description = "${api.responseCodes.alreadyExists.description}")
    })
    @PostMapping(
            value = "/website",
            produces = "application/json")
    void createWebSite(@RequestBody WebSiteDto webSite);

    /**
     * Sample usage: "curl $HOST:$PORT/website/1".
     *
     * @param webSite A JSON representation of an updated website
     */
    @Operation(
            summary = "${api.website-service.update-website.description}",
            description = "${api.website-service.update-website.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
    })
    @PutMapping(
            value = "/website",
            produces = "application/json")
    void updateWebSite(@RequestBody WebSiteDto webSite);

    /**
     * Sample usage: "curl $HOST:$PORT/website/1".
     *
     * @param webSiteId id of the website
     */
    @Operation(
            summary = "${api.website-service.delete-website.description}",
            description = "${api.website-service.delete-website.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "801", description = "${api.responseCodes.alreadyExists.description}")
    })
    @DeleteMapping(
            value = "/website/{webSiteId}",
            produces = "application/json")
    void deleteWebSite(@PathVariable int webSiteId);

    /**
     * Sample usage: "curl $HOST:$PORT/website".
     *
     * @return List of websites, if found, else null
     */
    @Operation(
            summary = "${api.website-service.get-website.description}",
            description = "${api.website-service.get-website.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
    })
    @GetMapping(
            value = "/website",
            produces = "application/json"
    )
    List<WebSiteDto> getAllWebsites();

    /**
     * Sample usage: "curl $HOST:$PORT/website".
     *
     * @return website info, if found, else null
     */
    @Operation(
            summary = "${api.website-service.get-website.description}",
            description = "${api.website-service.get-website.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
    })
    @GetMapping(
            value = "/website/{webSiteId}",
            produces = "application/json")
    WebSiteDto getWebSite(@PathVariable int webSiteId);

}
