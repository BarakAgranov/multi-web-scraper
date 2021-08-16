package com.barak.searchservice.api;

import com.barak.api.search.search_api.ISearchService;
import com.barak.api.search.search_api.SearchDto;
import com.barak.searchservice.logic.controllers.SearchController;
import com.barak.util.exceptions.ApplicationException;
import com.barak.util.http.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchService implements ISearchService {

    private final ServiceUtil serviceUtil;
    private SearchCompositeIntegration integration;
    private SearchController searchController;

    @Autowired
    public SearchService(ServiceUtil serviceUtil, SearchCompositeIntegration integration, SearchController searchController) {
        this.serviceUtil = serviceUtil;
        this.integration = integration;
        this.searchController = searchController;
    }

    @Override
    public void createSearch(SearchDto searchDto) throws ApplicationException {

        SearchDto searchToCreate = integration.getSearchComponents(searchDto);

        searchController.createSearch(searchToCreate);
    }

    @Override
    public void updateSearch(SearchDto searchDto) throws ApplicationException {

        SearchDto searchToUpdate = integration.getSearchComponents(searchDto);

        searchController.updateSearch(searchToUpdate);
    }

    @Override
    public void deleteSearch(int searchId) throws ApplicationException {

        searchController.deleteSearch(searchId);
    }

    @Override
    public List<SearchDto> getAllSearches() throws ApplicationException {

        return searchController.getAllSearchDto();
    }

    @Override
    public SearchDto getSearch(int searchId) throws ApplicationException {

        return searchController.getSearchDto(searchId);
    }
}
