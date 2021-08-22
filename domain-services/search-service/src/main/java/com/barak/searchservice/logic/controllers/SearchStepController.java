package com.barak.searchservice.logic.controllers;

import com.barak.api.search.search_step_api.SearchStepDto;
import com.barak.searchservice.entities.SearchStepEntity;
import com.barak.searchservice.logic.mappers.ISearchStepMapper;
import com.barak.searchservice.repositories.ISearchStepRepository;
import com.barak.util.exceptions.ApplicationException;
import com.barak.util.exceptions.ErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SearchStepController {

    private ISearchStepRepository searchStepRepository;
    private ISearchStepMapper searchStepMapper;

    @Autowired
    public SearchStepController(ISearchStepRepository searchStepRepository, ISearchStepMapper searchStepMapper) {
        this.searchStepRepository = searchStepRepository;
        this.searchStepMapper = searchStepMapper;
    }

    public void createSearchStep(SearchStepDto searchStepDto) throws ApplicationException {
        SearchStepEntity searchStepEntity = searchStepMapper.dtoToSearchStepCreate(searchStepDto);
        validateSearchStep(searchStepEntity, false);
        try {
            searchStepRepository.save(searchStepEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }

    }

    public void updateSearchStep(SearchStepDto searchStepDto) throws ApplicationException {
        try {
            SearchStepEntity searchStepEntity = searchStepRepository.findById(searchStepDto.getId()).get();
            if (searchStepEntity instanceof SearchStepEntity) {
                SearchStepEntity updatedSearchStep = searchStepMapper.dtoToSearchStepUpdate(searchStepDto, searchStepEntity);
                validateSearchStep(updatedSearchStep, true);
                searchStepRepository.save(updatedSearchStep);
            } else
                throw new ApplicationException(ErrorType.CANNOT_BE_FOUND, "Step With this ID could not be found: " + searchStepDto.getId());
        } catch (Exception e) {
            if (e instanceof ApplicationException) {
                throw e;
            } else
                throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public void deleteSearchStep(long searchStepId) throws ApplicationException {
        try {
            searchStepRepository.deleteById(searchStepId);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public SearchStepDto getSearchStepDto(long searchStepId) throws ApplicationException {
        try {
            return searchStepRepository.getDtoById(searchStepId);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public List<SearchStepDto> getAllSearchStepDto() throws ApplicationException {
        try {
            return searchStepRepository.getAllDto();
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    private void validateSearchStep(SearchStepEntity searchStepEntity, boolean isUpdate) throws ApplicationException {
        if (searchStepEntity.getName() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Search step must have name");
        }
        if (searchStepEntity.getActionName() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Search step must have description");
        }
        if (searchStepEntity.getConditionType() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Search step must have action type");
        }
        if (searchStepEntity.getMillisecondsToWait() < 0 ) {
            throw new ApplicationException(ErrorType.VALUE_LOWER_THAN_ZERO, "Milliseconds to wait for condition must be at least 0");
        }
        if (searchStepEntity.getMillisecondsToCheck() < 0 ) {
            throw new ApplicationException(ErrorType.VALUE_LOWER_THAN_ZERO, "Milliseconds to wait between checks must be at least 0");
        }
        if (isUpdate == false) {
            try {
                if (searchStepRepository.existsById(searchStepEntity.getId())) {
                    throw new ApplicationException(ErrorType.ALREADY_EXISTS, "Step with this ID already exist: " + searchStepEntity.getId());
                }
            } catch (Exception e) {
                if (e instanceof ApplicationException) {
                    throw e;
                } else throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
            }
        }


    }

}
