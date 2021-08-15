package com.barak.websiteservice.logic.controllers;

import com.barak.api.website.action_condition_api.ActionConditionDto;
import com.barak.util.exceptions.ApplicationException;
import com.barak.util.exceptions.ErrorType;
import com.barak.websiteservice.entities.ActionConditionEntity;
import com.barak.websiteservice.logic.mappers.IActionConditionMapper;
import com.barak.websiteservice.repositories.IActionConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ActionConditionController {

    private IActionConditionRepository actionConditionRepository;
    private IActionConditionMapper actionConditionMapper;

    @Autowired
    public ActionConditionController(IActionConditionRepository actionConditionRepository, IActionConditionMapper actionConditionMapper) {
        this.actionConditionRepository = actionConditionRepository;
        this.actionConditionMapper = actionConditionMapper;
    }

    public void createActionCondition(ActionConditionDto actionConditionDto) throws ApplicationException {
        ActionConditionEntity actionConditionEntity = actionConditionMapper.dtoToActionConditionCreate(actionConditionDto);
        validateActionCondition(actionConditionEntity, false);
        try {
            actionConditionRepository.save(actionConditionEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }

    }

    public void updateActionCondition(ActionConditionDto actionConditionDto) throws ApplicationException {
        try {
            ActionConditionEntity actionConditionEntity = actionConditionRepository.findById(actionConditionDto.getId()).get();
            if (actionConditionEntity instanceof ActionConditionEntity) {
                ActionConditionEntity updatedWebElement = actionConditionMapper.dtoToActionConditionUpdate(actionConditionDto, actionConditionEntity);
                validateActionCondition(updatedWebElement, true);
                actionConditionRepository.save(updatedWebElement);
            } else
                throw new ApplicationException(ErrorType.CANNOT_BE_FOUND, "Action condition With this ID could not be found: " + actionConditionDto.getId());
        } catch (Exception e) {
            if (e instanceof ApplicationException) {
                throw e;
            } else
                throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public void deleteActionCondition(int actionConditionId) throws ApplicationException {
        try {
            actionConditionRepository.deleteById(actionConditionId);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public ActionConditionDto getActionConditionDto(int actionConditionId) throws ApplicationException {
        try {
            return actionConditionRepository.getDtoById(actionConditionId);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public List<ActionConditionDto> getAllActionConditionDto() throws ApplicationException {
        try {
            return actionConditionRepository.getAllDto();
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    private void validateActionCondition(ActionConditionEntity actionConditionEntity, boolean isUpdate) throws ApplicationException {
        if (actionConditionEntity.getName() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Action condition must have name");
        }
        if (actionConditionEntity.getDescription() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Action condition must have description");
        }
        if (actionConditionEntity.getConditionType() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Action condition must have action type");
        }
        if (actionConditionEntity.getMillisecondsToWait() < 0 ) {
            throw new ApplicationException(ErrorType.VALUE_LOWER_THAN_ZERO, "Milliseconds to wait for condition must be at least 0");
        }
        if (actionConditionEntity.getMillisecondsToCheck() < 0 ) {
            throw new ApplicationException(ErrorType.VALUE_LOWER_THAN_ZERO, "Milliseconds to wait between checks must be at least 0");
        }


    }

}
