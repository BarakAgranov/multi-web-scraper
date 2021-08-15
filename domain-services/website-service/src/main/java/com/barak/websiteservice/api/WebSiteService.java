package com.barak.websiteservice.api;


import com.barak.api.website.website_api.IWebSiteService;
import com.barak.api.website.website_api.WebSiteDto;
import com.barak.util.exceptions.ApplicationException;
import com.barak.websiteservice.logic.controllers.WebSiteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/website")
public class WebSiteService implements IWebSiteService {

    private WebSiteController webSiteController;

    @Autowired
    public WebSiteService(WebSiteController webSiteController) {
        this.webSiteController = webSiteController;
    }

    @Override
    public void createWebSite(@RequestBody WebSiteDto webSiteDto) throws ApplicationException {
        webSiteController.createWebSite(webSiteDto);
    }

    @Override
    public void updateWebSite(@RequestBody WebSiteDto webSiteDto) throws ApplicationException {
        webSiteController.updateWebSite(webSiteDto);
    }

    @Override
    public void deleteWebSite(@PathVariable int webSiteId) throws ApplicationException {
        webSiteController.deleteWebSite(webSiteId);
    }

    @Override
    public List<WebSiteDto> getAllWebsites() throws ApplicationException {
        return webSiteController.getAllWebSiteDto();
    }
    @GetMapping("/{webSiteId}")
    public WebSiteDto getWebSite(@PathVariable int webSiteId) throws ApplicationException {
        return webSiteController.getWebSiteDto(webSiteId);
    }
}
