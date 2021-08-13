package com.barak.api.website.web_element_api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IWebElementService {

    @PostMapping(
            value = "/element",
            produces = "application/json")
    void createWebElement(@RequestBody WebElementDto webElementDto);

    @PutMapping(
            value = "/element",
            produces = "application/json")
    void updateWebElement(@RequestBody WebElementDto webElementDto);

    @DeleteMapping(
            value = "/element/{elementId}",
            produces = "application/json")
    void deleteWebElement(@PathVariable long elementId);

    @GetMapping(
            value = "/element",
            produces = "application/json"
    )
    List<WebElementDto> getAllWebElement();

    @GetMapping(
            value = "/element/{elementId}",
            produces = "application/json"
    )
    WebElementDto getWebElement(@PathVariable long elementId);
}
