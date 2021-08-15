package com.barak.websiteservice.logic.controllers;

import com.barak.api.website.web_element_api.WebElementDto;
import com.barak.util.exceptions.ApplicationException;
import com.barak.util.exceptions.ErrorType;
import com.barak.websiteservice.entities.WebElementEntity;
import com.barak.websiteservice.logic.mappers.IWebElementMapper;
import com.barak.websiteservice.repositories.IWebElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class WebElementController {

    private IWebElementRepository webElementRepository;
    private IWebElementMapper elementMapper;

    @Autowired
    public WebElementController(IWebElementRepository webElementRepository, IWebElementMapper elementMapper) {
        this.webElementRepository = webElementRepository;
        this.elementMapper = elementMapper;
    }

    public void createWebElement(WebElementDto webElementDto) throws ApplicationException {
        WebElementEntity webElementEntity = elementMapper.dtoToWebElementCreate(webElementDto);
        validateWebElement(webElementEntity, false);
        try {
            webElementRepository.save(webElementEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }

    }

    public void updateWebElement(WebElementDto webElementDto) throws ApplicationException {
        try {
            WebElementEntity webElementEntity = webElementRepository.findById(webElementDto.getId()).get();
            if (webElementEntity instanceof WebElementEntity) {
                WebElementEntity updatedWebElement = elementMapper.dtoToWebElementUpdate(webElementDto, webElementEntity);
                validateWebElement(updatedWebElement, true);
                webElementRepository.save(updatedWebElement);
            } else
                throw new ApplicationException(ErrorType.CANNOT_BE_FOUND, "Web element With this ID could not be found: " + webElementDto.getId());
        } catch (Exception e) {
            if (e instanceof ApplicationException) {
                throw e;
            } else
                throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public void deleteWebElement(int webElementId) throws ApplicationException {
        try {
            webElementRepository.deleteById(webElementId);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public WebElementDto getWebElementDto(int webElementId) throws ApplicationException {
        try {
            return webElementRepository.getDtoById(webElementId);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public List<WebElementDto> getAllWebElementDto() throws ApplicationException {
        try {
            return webElementRepository.getAllDto();
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    private void validateWebElement(WebElementEntity webElementEntity, boolean isUpdate) throws ApplicationException {
        if (webElementEntity.getName() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Web element must have name");
        }
        if (webElementEntity.getDescription() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Web element must have description");
        }
        if (webElementEntity.getIdentifier() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Web element must have identifier");
        }
        if (webElementEntity.getIdentifierType() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Web element must have identifier type");
        }

    }

}
