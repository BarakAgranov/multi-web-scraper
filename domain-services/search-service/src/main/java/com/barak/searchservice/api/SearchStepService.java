package com.barak.searchservice.api;

import com.barak.api.search.search_step_api.ISearchStepService;
import com.barak.api.search.search_step_api.SearchStepDto;
import com.barak.searchservice.logic.controllers.SearchStepController;
import com.barak.util.exceptions.ApplicationException;
import com.barak.util.http.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchStepService implements ISearchStepService {

    private final ServiceUtil serviceUtil;
    private SearchCompositeIntegration integration;
    private SearchStepController searchStepController;

    @Autowired
    public SearchStepService(ServiceUtil serviceUtil, SearchCompositeIntegration integration, SearchStepController searchStepController) {
        this.serviceUtil = serviceUtil;
        this.integration = integration;
        this.searchStepController = searchStepController;
    }

    @Override
    public void createStep(SearchStepDto searchStepDto) throws ApplicationException {

        SearchStepDto stepToCreate = integration.getWebSiteComponents(searchStepDto);

        searchStepController.createSearchStep(searchStepDto);
    }

    @Override
    public void updateStep(SearchStepDto searchStepDto) throws ApplicationException {

        SearchStepDto stepToUpdate = integration.getWebSiteComponents(searchStepDto);

        searchStepController.updateSearchStep(stepToUpdate);
    }

    @Override
    public void deleteStep(long stepId) throws ApplicationException {

        searchStepController.deleteSearchStep(stepId);
    }

    @Override
    public List<SearchStepDto> getAllSteps() throws ApplicationException {

        return searchStepController.getAllSearchStepDto();
    }

    @Override
    public SearchStepDto getStep(long stepId) throws ApplicationException {

        return searchStepController.getSearchStepDto(stepId);
    }
}
