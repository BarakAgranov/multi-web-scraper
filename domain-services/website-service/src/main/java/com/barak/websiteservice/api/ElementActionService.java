package com.barak.websiteservice.api;

import com.barak.api.website.element_action_api.ElementActionDto;
import com.barak.api.website.element_action_api.IElementActionService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ElementActionService implements IElementActionService {

    @Override
    public void createAction(ElementActionDto elementActionDto) {

    }

    @Override
    public void updateAction(ElementActionDto elementActionDto) {

    }

    @Override
    public void deleteAction(long actionId) {

    }

    @Override
    public List<ElementActionDto> getAllActions() {
        return null;
    }

    @Override
    public ElementActionDto getAction(long actionId) {
        return null;
    }
}
