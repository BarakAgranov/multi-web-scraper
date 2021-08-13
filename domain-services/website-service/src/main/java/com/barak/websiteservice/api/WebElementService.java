package com.barak.websiteservice.api;


import com.barak.api.website.web_element_api.IWebElementService;
import com.barak.api.website.web_element_api.WebElementDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebElementService implements IWebElementService {

    @Override
    public void createWebElement(WebElementDto webElementDto) {

    }

    @Override
    public void updateWebElement(WebElementDto webElementDto) {

    }

    @Override
    public void deleteWebElement(long elementId) {

    }

    @Override
    public List<WebElementDto> getAllWebElement() {
        return null;
    }

    @Override
    public WebElementDto getWebElement(long elementId) {
        return null;
    }
}
