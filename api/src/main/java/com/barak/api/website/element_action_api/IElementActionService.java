package com.barak.api.website.element_action_api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "ElementActionService", description =
        "REST API for operating CRUD operations on element action")
public interface IElementActionService {

    /**
     * Sample usage: "curl $HOST:$PORT/action/1".
     *
     * @param elementAction A JSON representation of the new Action object
     */
    @Operation(
            summary = "${api.action-service.create-action.description}",
            description = "${api.action-service.create-action.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "801", description = "${api.responseCodes.alreadyExists.description}")
    })
    @PostMapping(
            value = "/action",
            produces = "application/json")
    void createAction(@RequestBody ElementActionDto elementAction);

    /**
     * Sample usage: "curl $HOST:$PORT/action/1".
     *
     * @param elementAction A JSON representation of an updated Action
     */
    @Operation(
            summary = "${api.action-service.update-action.description}",
            description = "${api.action-service.update-action.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
    })
    @PutMapping(
            value = "/action",
            produces = "application/json")
    void updateAction(@RequestBody ElementActionDto elementAction);

    /**
     * Sample usage: "curl $HOST:$PORT/action/1".
     *
     * @param actionId id of the Action
     */
    @Operation(
            summary = "${api.action-service.delete-action.description}",
            description = "${api.action-service.delete-action.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "801", description = "${api.responseCodes.alreadyExists.description}")
    })
    @DeleteMapping(
            value = "/action/{actionId}",
            produces = "application/json")
    void deleteAction(@PathVariable int actionId);

    /**
     * Sample usage: "curl $HOST:$PORT/action".
     *
     * @return List of actions, if found, else null
     */
    @Operation(
            summary = "${api.action-service.get-action.description}",
            description = "${api.action-service.get-action.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
    })
    @GetMapping(
            value = "/action",
            produces = "application/json"
    )
    List<ElementActionDto> getAllActions();

    /**
     * Sample usage: "curl $HOST:$PORT/action".
     *
     * @return action info, if found, else null
     */
    @Operation(
            summary = "${api.action-service.get-action.description}",
            description = "${api.action-service.get-action.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
    })
    @GetMapping(
            value = "/action/{actionId}",
            produces = "application/json"
    )
    ElementActionDto getAction(@PathVariable int actionId);
}
