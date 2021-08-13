package com.barak.api.website.webpage_api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IWebPageService {

    @PostMapping(
            value = "/webpage",
            produces = "application/json")
    void createWebPage(@RequestBody WebPageDto webPageDto);

    @PutMapping(
            value = "/webpage",
            produces = "application/json")
    void updateWebPage(@RequestBody WebPageDto webPageDto);

    @DeleteMapping(
            value = "/webpage/{webPageId}",
            produces = "application/json")
    void deleteWebPage(@PathVariable long webPageId);

    @GetMapping(
            value = "/webpage",
            produces = "application/json"
    )
    List<WebPageDto> getAllWebPages();

    @GetMapping(
            value = "/webpage/{webPageId}",
            produces = "application/json"
    )
    WebPageDto getWebPage(@PathVariable long webPageId);
}
