package com.barak.websiteservice.logic.controllers;

import com.barak.api.website.website_api.WebSiteDto;
import com.barak.util.exceptions.ApplicationException;
import com.barak.util.exceptions.ErrorType;
import com.barak.websiteservice.entities.WebSiteEntity;
import com.barak.websiteservice.logic.mappers.IWebSiteMapper;
import com.barak.websiteservice.repositories.IWebSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class WebSiteController {

    private IWebSiteRepository webSiteRepository;
    private IWebSiteMapper webSiteMapper;

    @Autowired
    public WebSiteController(IWebSiteRepository webSiteRepository, IWebSiteMapper webSiteMapper) {
        this.webSiteRepository = webSiteRepository;
        this.webSiteMapper = webSiteMapper;
    }

    public void createWebSite(WebSiteDto webSiteDto) throws ApplicationException {
        WebSiteEntity webSiteEntity = webSiteMapper.dtoToWebSiteCreate(webSiteDto);
        validateWebSite(webSiteEntity, false);
        try {
            webSiteRepository.save(webSiteEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }

    }

    public void updateWebSite(WebSiteDto webSiteDto) throws ApplicationException {
        try {
            WebSiteEntity webSiteEntity = webSiteRepository.findById(webSiteDto.getId()).get();
            if (webSiteEntity instanceof WebSiteEntity) {
                WebSiteEntity updatedWebSite = webSiteMapper.dtoToWebSiteUpdate(webSiteDto, webSiteEntity);
                validateWebSite(updatedWebSite, true);
                webSiteRepository.save(updatedWebSite);
            } else
                throw new ApplicationException(ErrorType.CANNOT_BE_FOUND, "Website With this ID could not be found: " + webSiteDto.getId());
        } catch (Exception e) {
            if (e instanceof ApplicationException) {
                throw e;
            } else
                throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public void deleteWebSite(int webSiteId) throws ApplicationException {
        try {
            webSiteRepository.deleteById(webSiteId);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public WebSiteDto getWebSiteDto(int webSiteId) throws ApplicationException {
        try {
            return webSiteRepository.getDtoById(webSiteId);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public List<WebSiteDto> getAllWebSiteDto() throws ApplicationException {
        try {
            return webSiteRepository.getAllDto();
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }


    private void validateWebSite(WebSiteEntity webSiteEntity, boolean isUpdate) throws ApplicationException {
        if (webSiteEntity.getName() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Website must have a name");
        }
        if (webSiteEntity.getUrl() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Website must have a url");
        }
        if (webSiteEntity.getDescription() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Website must have a description");
        }
        if (webSiteEntity.getPreferredBrowser() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Website must have a preferred browser");
        }
        if (isUpdate == false) {
            try {
                if (webSiteRepository.existsByName(webSiteEntity.getName())) {
                    throw new ApplicationException(ErrorType.ALREADY_EXISTS, "Website with this name already exist" + webSiteEntity.getName());
                }
                if (webSiteRepository.existsByUrl(webSiteEntity.getUrl())) {
                    throw new ApplicationException(ErrorType.ALREADY_EXISTS, "Website with this url already exist" + webSiteEntity.getUrl());
                }
            } catch (Exception e) {
                if (e instanceof ApplicationException) {
                    throw e;
                } else throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
            }
        }
    }
}
