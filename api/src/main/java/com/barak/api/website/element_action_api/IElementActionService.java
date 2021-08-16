package com.barak.api.website.element_action_api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IElementActionService {

    @PostMapping(
            value = "/action",
            produces = "application/json")
    void createAction(@RequestBody ElementActionDto elementActionDto);

    @PutMapping(
            value = "/action",
            produces = "application/json")
    void updateAction(@RequestBody ElementActionDto elementActionDto);

    @DeleteMapping(
            value = "/action/{actionId}",
            produces = "application/json")
    void deleteAction(@PathVariable int actionId);

    @GetMapping(
            value = "/action",
            produces = "application/json"
    )
    List<ElementActionDto> getAllActions();

    @GetMapping(
            value = "/action/{actionId}",
            produces = "application/json"
    )
    ElementActionDto getAction(@PathVariable int actionId);
}
