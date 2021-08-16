package com.barak.api.website.action_condition_api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IActionConditionService {

    @PostMapping(
            value = "/condition",
            produces = "application/json")
    void createCondition(@RequestBody ActionConditionDto actionConditionDto);

    @PutMapping(
            value = "/condition",
            produces = "application/json")
    void updateCondition(@RequestBody ActionConditionDto actionConditionDto);

    @DeleteMapping(
            value = "/condition/{conditionId}",
            produces = "application/json")
    void deleteCondition(@PathVariable int conditionId);

    @GetMapping(
            value = "/condition",
            produces = "application/json"
    )
    List<ActionConditionDto> getAllConditions();

    @GetMapping(
            value = "/condition/{conditionId}",
            produces = "application/json"
    )
    ActionConditionDto getCondition(@PathVariable int conditionId);
}
