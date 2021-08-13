package com.barak.websiteservice.logic.controllers;

import com.barak.api.website.webpage_api.WebPageDto;
import com.barak.websiteservice.entities.WebPageEntity;
import com.barak.websiteservice.enums.ErrorType;
import com.barak.websiteservice.exceptions.ApplicationException;
import com.barak.websiteservice.logic.mappers.IWebPageMapper;
import com.barak.websiteservice.repositories.IWebPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class WebPageController {

    private IWebPageRepository webPageRepository;
    private IWebPageMapper webPageMapper;

    @Autowired
    public WebPageController(IWebPageRepository webPageRepository, IWebPageMapper webPageMapper) {
        this.webPageRepository = webPageRepository;
        this.webPageMapper = webPageMapper;
    }

    public void createWebPage(WebPageDto webPageDto) throws ApplicationException {
        WebPageEntity webPageEntity = webPageMapper.dtoToWebPageCreate(webPageDto);
        validateWebPage(webPageEntity, false);
        try {
            webPageRepository.save(webPageEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }

    }

    public void updateWebPage(WebPageDto webPageDto) throws ApplicationException {
        try {
            WebPageEntity webPageEntity = webPageRepository.findById(webPageDto.getId()).get();
            if (webPageEntity instanceof WebPageEntity) {
                WebPageEntity updatedWebPage = webPageMapper.dtoToWebPageUpdate(webPageDto, webPageEntity);
                validateWebPage(updatedWebPage, true);
                webPageRepository.save(updatedWebPage);
            } else
                throw new ApplicationException(ErrorType.CANNOT_BE_FOUND, "Web page With this ID could not be found: " + webPageDto.getId());
        } catch (Exception e) {
            if (e instanceof ApplicationException) {
                throw e;
            } else
                throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public void deleteWebPage(int webPageId) throws ApplicationException {
        try {
            webPageRepository.deleteById(webPageId);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public WebPageDto getWebPageDto(int webPageId) throws ApplicationException {
        try {
            return webPageRepository.getDtoById(webPageId);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public List<WebPageDto> getAllWebPageDto() throws ApplicationException {
        try {
            return webPageRepository.getAllDto();
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }


    private void validateWebPage(WebPageEntity webPageEntity, boolean isUpdate) throws ApplicationException {
        if (webPageEntity.getName() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Web page must have a name");
        }
        if (webPageEntity.getUrl() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Web page must have a url");
        }
        if (webPageEntity.getDescription() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Web page must have a description");
        }
        if (isUpdate == false) {
            try {
                if (webPageRepository.existsByName(webPageEntity.getName())) {
                    throw new ApplicationException(ErrorType.ALREADY_EXISTS, "Web page with this name already exist" + webPageEntity.getName());
                }
                if (webPageRepository.existsByUrl(webPageEntity.getUrl())) {
                    throw new ApplicationException(ErrorType.ALREADY_EXISTS, "Web page with this url already exist" + webPageEntity.getUrl());
                }
            } catch (Exception e) {
                if (e instanceof ApplicationException) {
                    throw e;
                } else throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
            }

        }
    }

}

