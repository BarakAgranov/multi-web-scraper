package com.barak.websiteservice.api;

import com.barak.api.website.action_condition_api.ActionConditionDto;
import com.barak.api.website.action_condition_api.IActionConditionService;
import com.barak.util.exceptions.ApplicationException;
import com.barak.websiteservice.logic.controllers.ActionConditionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActionConditionService implements IActionConditionService {

    private ActionConditionController actionConditionController;

    @Autowired
    public ActionConditionService(ActionConditionController actionConditionController) {
        this.actionConditionController = actionConditionController;
    }

    @Override
    public void createCondition(ActionConditionDto actionConditionDto) throws ApplicationException {
        actionConditionController.createActionCondition(actionConditionDto);
    }

    @Override
    public void updateCondition(@RequestBody ActionConditionDto actionConditionDto) throws ApplicationException {
        actionConditionController.updateActionCondition(actionConditionDto);
    }

    @Override
    public void deleteCondition(@PathVariable int conditionId) throws ApplicationException {
        actionConditionController.deleteActionCondition(conditionId);
    }

    @Override
    public List<ActionConditionDto> getAllConditions() throws ApplicationException {
        return actionConditionController.getAllActionConditionDto();
    }

    @Override
    public ActionConditionDto getCondition(@PathVariable int conditionId) throws ApplicationException {
        return actionConditionController.getActionConditionDto(conditionId);
    }
}
