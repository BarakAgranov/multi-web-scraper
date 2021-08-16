package com.barak.api.website.website_api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IWebSiteService {

    @PostMapping(
            value = "/website",
            produces = "application/json")
    void createWebSite(@RequestBody WebSiteDto webSiteDto);

    @PutMapping(
            value = "/website",
            produces = "application/json")
    void updateWebSite(@RequestBody WebSiteDto webSiteDto);

    @DeleteMapping(
            value = "/website/{webSiteId}",
            produces = "application/json")
    void deleteWebSite(@PathVariable int webSiteId);

    @GetMapping(
            value = "/website",
            produces = "application/json"
    )
    List<WebSiteDto> getAllWebsites();

    @GetMapping(
            value = "/website/{webSiteId}",
            produces = "application/json")
    WebSiteDto getWebSite(@PathVariable int webSiteId);

}
