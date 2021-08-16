package com.barak.websiteservice.api;

import com.barak.api.website.element_action_api.ElementActionDto;
import com.barak.api.website.element_action_api.IElementActionService;
import com.barak.util.exceptions.ApplicationException;
import com.barak.websiteservice.logic.controllers.ElementActionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ElementActionService implements IElementActionService {

    private ElementActionController elementActionController;

    @Autowired
    public ElementActionService(ElementActionController elementActionController) {
        this.elementActionController = elementActionController;
    }

    @Override
    public void createAction(@RequestBody ElementActionDto elementActionDto) throws ApplicationException {
        elementActionController.createElementAction(elementActionDto);
    }

    @Override
    public void updateAction(@RequestBody ElementActionDto elementActionDto) throws ApplicationException {
        elementActionController.updateElementAction(elementActionDto);
    }

    @Override
    public void deleteAction(@PathVariable int actionId) throws ApplicationException {
        elementActionController.deleteElementAction(actionId);
    }

    @Override
    public List<ElementActionDto> getAllActions() throws ApplicationException {
        return elementActionController.getAllElementActionDto();
    }

    @Override
    public ElementActionDto getAction(@PathVariable int actionId) throws ApplicationException {
        return elementActionController.getElementActionDto(actionId);
    }
}
