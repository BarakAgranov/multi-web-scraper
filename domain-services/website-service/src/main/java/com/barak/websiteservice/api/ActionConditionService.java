package com.barak.websiteservice.api;

import com.barak.api.website.action_condition_api.ActionConditionDto;
import com.barak.api.website.action_condition_api.IActionConditionService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActionConditionService implements IActionConditionService {

    @Override
    public void createCondition(ActionConditionDto actionConditionDto) {

    }

    @Override
    public void updateCondition(ActionConditionDto actionConditionDto) {

    }

    @Override
    public void deleteCondition(long conditionId) {

    }

    @Override
    public List<ActionConditionDto> getAllConditions() {
        return null;
    }

    @Override
    public ActionConditionDto getCondition(long conditionId) {
        return null;
    }
}
