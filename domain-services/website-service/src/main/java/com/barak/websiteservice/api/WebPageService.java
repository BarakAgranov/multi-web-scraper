package com.barak.websiteservice.api;


import com.barak.api.website.webpage_api.IWebPageService;
import com.barak.api.website.webpage_api.WebPageDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebPageService implements IWebPageService {

    @Override
    public void createWebPage(WebPageDto webPageDto) {

    }

    @Override
    public void updateWebPage(WebPageDto webPageDto) {

    }

    @Override
    public void deleteWebPage(long webPageId) {

    }

    @Override
    public List<WebPageDto> getAllWebPages() {
        return null;
    }

    @Override
    public WebPageDto getWebPage(long webPageId) {
        return null;
    }
}
