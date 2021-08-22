package com.barak.websiteservice.logic.controllers;

import com.barak.api.website.element_action_api.ElementActionDto;
import com.barak.util.exceptions.ApplicationException;
import com.barak.util.exceptions.ErrorType;
import com.barak.websiteservice.entities.ElementActionEntity;
import com.barak.websiteservice.logic.mappers.IElementActionMapper;
import com.barak.websiteservice.repositories.IElementActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ElementActionController {

    private IElementActionRepository elementActionRepository;
    private IElementActionMapper elementActionMapper;

    @Autowired
    public ElementActionController(IElementActionRepository elementActionRepository, IElementActionMapper elementActionMapper) {
        this.elementActionRepository = elementActionRepository;
        this.elementActionMapper = elementActionMapper;
    }

    public void createElementAction(ElementActionDto elementActionDto) throws ApplicationException {
        ElementActionEntity elementActionEntity = elementActionMapper.dtoToElementActionCreate(elementActionDto);
        validateElementAction(elementActionEntity, false);
        try {
            elementActionRepository.save(elementActionEntity);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }

    }

    public void updateElementAction(ElementActionDto elementActionDto) throws ApplicationException {
        try {
            ElementActionEntity elementActionEntity = elementActionRepository.findById(elementActionDto.getId()).get();
            if (elementActionEntity instanceof ElementActionEntity) {
                ElementActionEntity updatedElementAction = elementActionMapper.dtoToElementActionUpdate(elementActionDto, elementActionEntity);
                validateElementAction(updatedElementAction, true);
                elementActionRepository.save(updatedElementAction);
            } else throw new ApplicationException(ErrorType.CANNOT_BE_FOUND, "Element action With this ID could not be found: " + elementActionDto.getId());
        } catch (Exception e) {
            if (e instanceof ApplicationException) {
                throw e;
            } else
                throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public void deleteElementAction(int elementActionId) throws ApplicationException {
        try {
            elementActionRepository.deleteById(elementActionId);
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public ElementActionDto getElementActionDto(int elementActionId) throws ApplicationException {
        try {
            return elementActionRepository.getDtoById(elementActionId);
        } catch (Exception e) {
             throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    public List<ElementActionDto> getAllElementActionDto() throws ApplicationException {
        try {
            return elementActionRepository.getAllDto();
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
        }
    }

    private void validateElementAction(ElementActionEntity elementActionEntity, boolean isUpdate) throws ApplicationException {
        if (elementActionEntity.getName() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Element action must have name");
        }
        if (elementActionEntity.getDescription() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Element action must have description");
        }
        if (elementActionEntity.getActionType() == null) {
            throw new ApplicationException(ErrorType.MUST_HAVE_A_VALUE, "Element action must have action type");
        }
        if (isUpdate == false) {
            try {
                if (elementActionRepository.existsById(elementActionEntity.getId())) {
                    throw new ApplicationException(ErrorType.ALREADY_EXISTS, "Action with this ID already exist: " + elementActionEntity.getId());
                }
            } catch (Exception e) {
                if (e instanceof ApplicationException) {
                    throw e;
                } else throw new ApplicationException(ErrorType.SQL_ERROR, ErrorType.SQL_ERROR.getErrorMessage());
            }
        }

    }

}
