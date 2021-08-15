package com.barak.websiteservice.api;

import com.barak.api.website.action_condition_api.ActionConditionDto;
import com.barak.util.exceptions.ApplicationException;
import com.barak.websiteservice.logic.controllers.ActionConditionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/condition")
public class ActionConditionService {

    private ActionConditionController actionConditionController;

    @Autowired
    public ActionConditionService(ActionConditionController actionConditionController) {
        this.actionConditionController = actionConditionController;
    }

    @PostMapping
    public void createCondition(@RequestBody ActionConditionDto actionConditionDto) throws ApplicationException {
        actionConditionController.createActionCondition(actionConditionDto);
    }

    @PutMapping
    public void updateCondition(@RequestBody ActionConditionDto actionConditionDto) throws ApplicationException {
        actionConditionController.updateActionCondition(actionConditionDto);
    }

    @DeleteMapping("/{conditionId}")
    public void deleteCondition(@PathVariable int conditionId) throws ApplicationException {
        actionConditionController.deleteActionCondition(conditionId);
    }

    @GetMapping
    public List<ActionConditionDto> getAllConditions() throws ApplicationException {
        return actionConditionController.getAllActionConditionDto();
    }

    @GetMapping("/{conditionId}")
    public ActionConditionDto getCondition(@PathVariable int conditionId) throws ApplicationException {
        return actionConditionController.getActionConditionDto(conditionId);
    }
}
