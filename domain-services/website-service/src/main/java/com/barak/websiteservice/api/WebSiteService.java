package com.barak.websiteservice.api;


import com.barak.api.website.website_api.IWebSiteService;
import com.barak.api.website.website_api.WebSiteDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebSiteService implements IWebSiteService {
    @Override
    public void createWebSite(WebSiteDto webSiteDto) {

    }

    @Override
    public void updateWebSite(WebSiteDto webSiteDto) {

    }

    @Override
    public void deleteWebSite(long webSiteId) {

    }

    @Override
    public List<WebSiteDto> getAllWebsites() {
        return null;
    }

    @Override
    public WebSiteDto getWebSite(long webSiteId) {
        return null;
    }
}
