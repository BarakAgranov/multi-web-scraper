package com.barak.api.website.web_element_api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "WebElementService", description =
        "REST API for operating CRUD operations on web element")
public interface IWebElementService {

    /**
     * Sample usage: "curl $HOST:$PORT/element/1".
     *
     * @param webElement A JSON representation of the new Element object
     */
    @Operation(
            summary = "${api.element-service.create-element.description}",
            description = "${api.element-service.create-element.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "801", description = "${api.responseCodes.alreadyExists.description}")
    })
    @PostMapping(
            value = "/element",
            produces = "application/json")
    void createWebElement(@RequestBody WebElementDto webElement);

    /**
     * Sample usage: "curl $HOST:$PORT/element/1".
     *
     * @param webElement A JSON representation of an updated Element
     */
    @Operation(
            summary = "${api.element-service.update-element.description}",
            description = "${api.element-service.update-element.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
    })
    @PutMapping(
            value = "/element",
            produces = "application/json")
    void updateWebElement(@RequestBody WebElementDto webElement);

    /**
     * Sample usage: "curl $HOST:$PORT/element/1".
     *
     * @param elementId id of the Element
     */
    @Operation(
            summary = "${api.element-service.delete-element.description}",
            description = "${api.element-service.delete-element.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "801", description = "${api.responseCodes.alreadyExists.description}")
    })
    @DeleteMapping(
            value = "/element/{elementId}",
            produces = "application/json")
    void deleteWebElement(@PathVariable int elementId);

    /**
     * Sample usage: "curl $HOST:$PORT/element".
     *
     * @return List of elements, if found, else null
     */
    @Operation(
            summary = "${api.element-service.get-element.description}",
            description = "${api.element-service.get-element.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
    })
    @GetMapping(
            value = "/element",
            produces = "application/json"
    )
    List<WebElementDto> getAllWebElement();

    /**
     * Sample usage: "curl $HOST:$PORT/element".
     *
     * @return element info, if found, else null
     */
    @Operation(
            summary = "${api.element-service.get-element.description}",
            description = "${api.element-service.get-element.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
    })
    @GetMapping(
            value = "/element/{elementId}",
            produces = "application/json"
    )
    WebElementDto getWebElement(@PathVariable int elementId);
}
