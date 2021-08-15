package com.barak.api.website.element_action_api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IElementActionService {

    @PostMapping(
            value = "/action",
            produces = "application/json")
    void createAction(@RequestBody ElementActionDto elementActionDto) throws Exception;

    @PutMapping(
            value = "/action",
            produces = "application/json")
    void updateAction(@RequestBody ElementActionDto elementActionDto) throws Exception;

    @DeleteMapping(
            value = "/action/{actionId}",
            produces = "application/json")
    void deleteAction(@PathVariable long actionId) throws Exception;

    @GetMapping(
            value = "/action",
            produces = "application/json"
    )
    List<ElementActionDto> getAllActions() throws Exception;

    @GetMapping(
            value = "/action/{actionId}",
            produces = "application/json"
    )
    ElementActionDto getAction(@PathVariable long actionId) throws Exception;
}
