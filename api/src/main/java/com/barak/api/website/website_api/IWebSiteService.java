package com.barak.api.website.website_api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IWebSiteService {

    @PostMapping(
            value = "/website",
            produces = "application/json")
    void createWebSite(@RequestBody WebSiteDto webSiteDto) throws Exception;

    @PutMapping(
            value = "/website",
            produces = "application/json")
    void updateWebSite(@RequestBody WebSiteDto webSiteDto) throws Exception;

    @DeleteMapping(
            value = "/website/{webSiteId}",
            produces = "application/json")
    void deleteWebSite(@PathVariable int webSiteId) throws Exception;

    @GetMapping(
            value = "/website",
            produces = "application/json"
    )
    List<WebSiteDto> getAllWebsites() throws Exception;

    @GetMapping(
            value = "/website/{webSiteId}",
            produces = "application/json")
    WebSiteDto getWebSite(@PathVariable int webSiteId) throws Exception;

}
