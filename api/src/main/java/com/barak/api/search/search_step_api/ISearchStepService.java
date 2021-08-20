package com.barak.api.search.search_step_api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "SearchStepService", description =
        "REST API for composing website components into information about search steps.")
public interface ISearchStepService {

    @PostMapping(
            value = "/step",
            produces = "application/json")
    void createStep(@RequestBody SearchStepDto searchStepDto) throws Exception;

    @PutMapping(
            value = "/step",
            produces = "application/json")
    void updateStep(@RequestBody SearchStepDto searchStepDto) throws Exception;

    @DeleteMapping(
            value = "/step/{stepId}",
            produces = "application/json")
    void deleteStep(@PathVariable long stepId) throws Exception;

    @GetMapping(
            value = "/step",
            produces = "application/json"
    )
    List<SearchStepDto> getAllSteps() throws Exception;

    @GetMapping(
            value = "/step/{stepId}",
            produces = "application/json"
    )
    SearchStepDto getStep(@PathVariable long stepId) throws Exception;
}
