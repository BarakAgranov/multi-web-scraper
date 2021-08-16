package com.barak.searchservice.logic.controllers;

import com.barak.api.search.search_api.SearchDto;
import com.barak.api.website.website_api.WebSiteDto;
import com.barak.searchservice.entities.SearchEntity;
import com.barak.searchservice.logic.mappers.ISearchMapper;
import com.barak.searchservice.repositories.ISearchRepository;
import com.barak.util.exceptions.ApplicationException;
import com.barak.util.exceptions.ErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SearchController {

    private ISearchRepository searchRepository;
    private ISearchMapper searchMapper;

    @Autowired
    public SearchController(ISearchRepository searchRepository, ISearchMapper searchMapper) {
        this.searchRepository = searchRepository;
        this.searchMapper = searchMapper;
    }

    public void createSearch(SearchDto searchDto) throws ApplicationException {
        SearchEntity searchEntity = searchMapper.dtoToSearchCreate(searchDto);
        validateSearch(searchEntity, false);
        try {
            searchRepository.save(searchEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }

    }

    public void updateSearch(SearchDto searchDto) throws ApplicationException {
        try {
            SearchEntity searchEntity = searchRepository.findById(searchDto.getId()).get();
            if (searchEntity instanceof SearchEntity) {
                SearchEntity updatedSearch = searchMapper.dtoToSearchUpdate(searchDto, searchEntity);
                validateSearch(updatedSearch, true);
                searchRepository.save(updatedSearch);
            } else
                throw new ApplicationException(ErrorType.CANNOT_BE_FOUND, "Search With this ID could not be found: " + searchDto.getId());
        } catch (Exception e) {
            if (e instanceof ApplicationException) {
                throw e;
            } else
                throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public void deleteSearch(int searchId) throws ApplicationException {
        try {
            searchRepository.deleteById(searchId);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public SearchDto getSearchDto(int searchId) throws ApplicationException {
        try {
            return searchRepository.getDtoById(searchId);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public List<SearchDto> getAllSearchDto() throws ApplicationException {
        try {
            return searchRepository.getAllDto();
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    private void validateSearch(SearchEntity searchEntity, boolean isUpdate) throws ApplicationException {
        if (searchEntity.getName() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Search must have name");
        }
        if (searchEntity.getDescription() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Search must have description");
        }
        if (searchEntity.getWebsiteName() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Search must have website name");
        }
        if (searchEntity.getPreferredBrowser() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Search must have preferred browser");
        }
        if (searchEntity.getWebsiteUrl() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Search must have website url");
        }
        if (isUpdate == false) {
            try {
                if (searchRepository.existsByName(searchEntity.getName())) {
                    throw new ApplicationException(ErrorType.ALREADY_EXISTS, "Search name must be unique");
                }
            } catch (Exception e) {
                if (e instanceof ApplicationException) {
                    throw e;
                } else throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
            }
        }
    }

}
