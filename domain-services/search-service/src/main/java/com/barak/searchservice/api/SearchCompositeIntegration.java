package com.barak.searchservice.api;

import com.barak.api.search.search_api.SearchDto;
import com.barak.api.search.search_step_api.SearchStepDto;
import com.barak.api.website.action_condition_api.ActionConditionDto;
import com.barak.api.website.element_action_api.ElementActionDto;
import com.barak.api.website.web_element_api.WebElementDto;
import com.barak.api.website.webpage_api.WebPageDto;
import com.barak.api.website.website_api.WebSiteDto;
import com.barak.util.exceptions.ApplicationException;
import com.barak.util.exceptions.ErrorType;
import com.barak.util.http.HttpErrorInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


@Component
public class SearchCompositeIntegration {

    private static final Logger LOG = LoggerFactory.getLogger(SearchCompositeIntegration.class);

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    private final String webSiteServiceUrl;
    private final String webPageServiceUrl;
    private final String webElementServiceUrl;
    private final String elementActionServiceUrl;
    private final String actionConditionServiceUrl;

    public SearchCompositeIntegration(RestTemplate restTemplate,
                                      ObjectMapper objectMapper,

                                      @Value("$app.website-service.host") String webSiteServiceHost,
                                      @Value("$app.website-service.host") String webSiteServicePort
    ) {

        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;

        this.webSiteServiceUrl = "http://" + webSiteServiceHost + ":" + webSiteServicePort + "/website/";
        this.webPageServiceUrl = "http://" + webSiteServiceHost + ":" + webSiteServicePort + "/page/";
        this.webElementServiceUrl = "http://" + webSiteServiceHost + ":" + webSiteServicePort + "/element/";
        this.elementActionServiceUrl = "http://" + webSiteServiceHost + ":" + webSiteServicePort + "/action/";
        this.actionConditionServiceUrl = "http://" + webSiteServiceHost + ":" + webSiteServicePort + "/condition/";
    }

    public WebSiteDto getWebSite(int websiteId) throws ApplicationException {
        try {
            String url = webSiteServiceUrl + websiteId;
            LOG.debug("Will call getWebSite API on URL: {}", url);

            WebSiteDto webSiteDto = restTemplate.getForObject(url, WebSiteDto.class);
            LOG.debug("Found website with ID: {}", webSiteDto.getId());

            return webSiteDto;
        } catch (HttpClientErrorException e) {

            Exception exception = handleHttpClientException(e);

            if (exception instanceof ApplicationException) {
                throw e;
            } else {
                LOG.warn("Got an unexpected HTTP error: {}, will rethrow it", e.getMessage());
                LOG.warn("Error body: {}", e.getMessage());
                throw new ApplicationException(ErrorType.GENERAL_ERROR, e.getMessage());
            }
        }
    }

    public WebPageDto getWebPage(int pageId) throws ApplicationException {
        try {
            String url = webPageServiceUrl + pageId;
            LOG.debug("Will call getWebPage API on URL: {}", url);

            WebPageDto webPageDto = restTemplate.getForObject(url, WebPageDto.class);
            LOG.debug("Found page with ID: {}", webPageDto.getId());

            return webPageDto;
        } catch (HttpClientErrorException e) {

            Exception exception = handleHttpClientException(e);

            if (exception instanceof ApplicationException) {
                throw e;
            } else {
                LOG.warn("Got an unexpected HTTP error: {}, will rethrow it", e.getMessage());
                LOG.warn("Error body: {}", e.getMessage());
                throw new ApplicationException(ErrorType.GENERAL_ERROR, e.getMessage());
            }
        }
    }

    public WebElementDto getWebElement(int elementId) throws ApplicationException {
        try {
            String url = webElementServiceUrl + elementId;
            LOG.debug("Will call getWebElement API on URL: {}", url);

            WebElementDto webElementDto = restTemplate.getForObject(url, WebElementDto.class);
            LOG.debug("Found element with ID: {}", webElementDto.getId());

            return webElementDto;
        } catch (HttpClientErrorException e) {

            Exception exception = handleHttpClientException(e);

            if (exception instanceof ApplicationException) {
                throw e;
            } else {
                LOG.warn("Got an unexpected HTTP error: {}, will rethrow it", e.getMessage());
                LOG.warn("Error body: {}", e.getMessage());
                throw new ApplicationException(ErrorType.GENERAL_ERROR, e.getMessage());
            }
        }
    }

    public ElementActionDto getElementAction(int actionId) throws ApplicationException {
        try {
            String url = elementActionServiceUrl + actionId;
            LOG.debug("Will call getElementAction API on URL: {}", url);

            ElementActionDto elementActionDto = restTemplate.getForObject(url, ElementActionDto.class);
            LOG.debug("Found action with ID: {}", elementActionDto.getId());

            return elementActionDto;
        } catch (HttpClientErrorException e) {

            Exception exception = handleHttpClientException(e);

            if (exception instanceof ApplicationException) {
                throw e;
            } else {
                LOG.warn("Got an unexpected HTTP error: {}, will rethrow it", e.getMessage());
                LOG.warn("Error body: {}", e.getMessage());
                throw new ApplicationException(ErrorType.GENERAL_ERROR, e.getMessage());
            }
        }
    }


    public ActionConditionDto getActionCondition(int conditionId) throws ApplicationException {
        try {
            String url = actionConditionServiceUrl + conditionId;
            LOG.debug("Will call getActionCondition API on URL: {}", url);

            ActionConditionDto actionConditionDto = restTemplate.getForObject(url, ActionConditionDto.class);
            LOG.debug("Found action with ID: {}", actionConditionDto.getId());

            return actionConditionDto;

        } catch (HttpClientErrorException e) {

            Exception exception = handleHttpClientException(e);

            if (exception instanceof ApplicationException) {
                throw e;
            } else {
                LOG.warn("Got an unexpected HTTP error: {}, will rethrow it", e.getMessage());
                LOG.warn("Error body: {}", e.getMessage());
                throw new ApplicationException(ErrorType.GENERAL_ERROR, e.getMessage());
            }

        }

    }


    public SearchStepDto getSearchStepComponents(SearchStepDto searchStepDto) throws ApplicationException {

        WebPageDto webPageDto = getWebPage(searchStepDto.getPageId());
        WebElementDto elementDto = getWebElement(searchStepDto.getElementId());
        ElementActionDto actionDto = getElementAction(searchStepDto.getActionId());
        ActionConditionDto conditionDto = getActionCondition(searchStepDto.getConditionId());

        searchStepDto.setPageName(webPageDto.getName());
        searchStepDto.setPageUrl(webPageDto.getUrl());

        searchStepDto.setElementName(elementDto.getName());
        searchStepDto.setElementIdentifier(elementDto.getIdentifier());
        searchStepDto.setElementIdentifierType(elementDto.getIdentifierType());

        searchStepDto.setActionName(actionDto.getName());
        searchStepDto.setActionType(actionDto.getActionType());
        searchStepDto.setActionInput(actionDto.getActionInput());

        searchStepDto.setConditionName(conditionDto.getName());
        searchStepDto.setConditionType(conditionDto.getConditionType());
        searchStepDto.setMillisecondsToCheck(conditionDto.getMillisecondsToCheck());
        searchStepDto.setMillisecondsToWait(conditionDto.getMillisecondsToWait());

        return searchStepDto;
    }

    public SearchDto getSearchComponents(SearchDto searchDto) throws ApplicationException {

        WebSiteDto webSiteDto = getWebSite(searchDto.getWebsiteId());

        searchDto.setWebsiteName(webSiteDto.getName());
        searchDto.setWebsiteUrl(webSiteDto.getUrl());
        searchDto.setPreferredBrowser(webSiteDto.getPreferredBrowser());

        return searchDto;
    }

    private RuntimeException handleHttpClientException(HttpClientErrorException e) {

        HttpErrorInfo errorInfo = getErrorInfo(e);
        LOG.warn("Got a unexpected HTTP error: {}, will rethrow it", e.getStatusCode());
        LOG.warn("Error body: {}", e.getResponseBodyAsString());
        return new ApplicationException(ErrorType.valueOf(errorInfo.getErrorName()), errorInfo.getMessage());

    }


    private HttpErrorInfo getErrorInfo(HttpClientErrorException e) {
        try {
            return objectMapper.readValue(e.getResponseBodyAsString(), HttpErrorInfo.class);
        } catch (IOException ioex) {
            throw  e;
        }
    }
}
