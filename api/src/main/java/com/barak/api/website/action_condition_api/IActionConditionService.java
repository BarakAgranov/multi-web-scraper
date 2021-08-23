package com.barak.api.website.action_condition_api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "ActionConditionService", description =
        "REST API for operating CRUD operations on action condition")
public interface IActionConditionService {

    /**
     * Sample usage: "curl $HOST:$PORT/condition/1".
     *
     * @param actionCondition A JSON representation of the new Condition object
     */
    @Operation(
            summary = "${api.condition-service.create-condition.description}",
            description = "${api.condition-service.create-condition.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "801", description = "${api.responseCodes.alreadyExists.description}")
    })
    @PostMapping(
            value = "/condition",
            produces = "application/json")
    void createCondition(@RequestBody ActionConditionDto actionCondition);

    /**
     * Sample usage: "curl $HOST:$PORT/condition/1".
     *
     * @param actionCondition A JSON representation of an updated Condition
     */
    @Operation(
            summary = "${api.condition-service.update-condition.description}",
            description = "${api.condition-service.update-condition.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
    })
    @PutMapping(
            value = "/condition",
            produces = "application/json")
    void updateCondition(@RequestBody ActionConditionDto actionCondition);

    /**
     * Sample usage: "curl $HOST:$PORT/condition/1".
     *
     * @param conditionId id of the Condition
     */
    @Operation(
            summary = "${api.condition-service.delete-condition.description}",
            description = "${api.condition-service.delete-condition.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
            @ApiResponse(responseCode = "801", description = "${api.responseCodes.alreadyExists.description}")
    })
    @DeleteMapping(
            value = "/condition/{conditionId}",
            produces = "application/json")
    void deleteCondition(@PathVariable int conditionId);

    /**
     * Sample usage: "curl $HOST:$PORT/condition".
     *
     * @return List of conditions, if found, else null
     */
    @Operation(
            summary = "${api.condition-service.get-condition.description}",
            description = "${api.condition-service.get-condition.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
    })
    @GetMapping(
            value = "/condition",
            produces = "application/json"
    )
    List<ActionConditionDto> getAllConditions();

    /**
     * Sample usage: "curl $HOST:$PORT/condition".
     *
     * @return condition info, if found, else null
     */
    @Operation(
            summary = "${api.condition-service.get-condition.description}",
            description = "${api.condition-service.get-condition.notes}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${api.responseCodes.ok.description}"),
            @ApiResponse(responseCode = "800", description = "${api.responseCodes.generalError.description}"),
            @ApiResponse(responseCode = "803", description = "${api.responseCodes.notFound.description}"),
    })
    @GetMapping(
            value = "/condition/{conditionId}",
            produces = "application/json"
    )
    ActionConditionDto getCondition(@PathVariable int conditionId);
}
