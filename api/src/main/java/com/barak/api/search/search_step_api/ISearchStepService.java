package com.barak.api.search.search_step_api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ISearchStepService {

    @PostMapping(
            value = "/step",
            produces = "application/json")
    void createStep(@RequestBody SearchStepDto searchStepDto);

    @PutMapping(
            value = "/step",
            produces = "application/json")
    void updateStep(@RequestBody SearchStepDto searchStepDto);

    @DeleteMapping(
            value = "/step/{stepId}",
            produces = "application/json")
    void deleteStep(@PathVariable long stepId);

    @GetMapping(
            value = "/step",
            produces = "application/json"
    )
    List<SearchStepDto> getAllSteps();

    @GetMapping(
            value = "/step/{stepId}",
            produces = "application/json"
    )
    SearchStepDto getStep(@PathVariable long stepId);
}
