package com.barak.websiteservice.api;


import com.barak.api.website.web_element_api.IWebElementService;
import com.barak.api.website.web_element_api.WebElementDto;
import com.barak.util.exceptions.ApplicationException;
import com.barak.websiteservice.logic.controllers.WebElementController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebElementService implements IWebElementService {

    private WebElementController webElementController;

    @Autowired
    public WebElementService(WebElementController webElementController) {
        this.webElementController = webElementController;
    }

    @Override
    public void createWebElement(@RequestBody WebElementDto webElementDto) throws ApplicationException {
        webElementController.createWebElement(webElementDto);
    }

    @Override
    public void updateWebElement(@RequestBody WebElementDto webElementDto) throws ApplicationException {
        webElementController.updateWebElement(webElementDto);
    }

    @Override
    public void deleteWebElement(@PathVariable int elementId) throws ApplicationException {
        webElementController.deleteWebElement(elementId);
    }

    @Override
    public List<WebElementDto> getAllWebElement() throws ApplicationException {
        return webElementController.getAllWebElementDto();
    }

    @Override
    public WebElementDto getWebElement(@PathVariable int elementId) throws ApplicationException {
        return webElementController.getWebElementDto(elementId);
    }
}
