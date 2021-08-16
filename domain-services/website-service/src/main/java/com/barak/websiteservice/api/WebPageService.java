package com.barak.websiteservice.api;


import com.barak.api.website.webpage_api.IWebPageService;
import com.barak.api.website.webpage_api.WebPageDto;
import com.barak.util.exceptions.ApplicationException;
import com.barak.websiteservice.logic.controllers.WebPageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebPageService implements IWebPageService {

    private WebPageController webPageController;

    @Autowired
    public WebPageService(WebPageController webPageController) {
        this.webPageController = webPageController;
    }

    @Override
    public void createWebPage(@RequestBody WebPageDto webPageDto) throws ApplicationException {
        webPageController.createWebPage(webPageDto);
    }

    @Override
    public void updateWebPage(@RequestBody WebPageDto webPageDto) throws ApplicationException {
        webPageController.updateWebPage(webPageDto);
    }

    @Override
    public void deleteWebPage(@PathVariable int webPageId) throws ApplicationException {
        webPageController.deleteWebPage(webPageId);
    }

    @Override
    public List<WebPageDto> getAllWebPages() throws ApplicationException {
        return webPageController.getAllWebPageDto();
    }

    @Override
    public WebPageDto getWebPage(@PathVariable int webPageId) throws ApplicationException {
        return webPageController.getWebPageDto(webPageId);
    }
}
