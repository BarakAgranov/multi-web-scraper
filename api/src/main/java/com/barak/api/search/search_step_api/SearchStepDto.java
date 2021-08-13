package com.barak.api.search.search_step_api;

public class SearchStepDto {

    private final long id;
    private final String name;
    private final int pageId;
    private final String pageName;
    private final String pageUrl;
    private final int elementId;
    private final String elementName;
    private final String elementIdentifier;
    private final String elementIdentifierType;
    private final int actionId;
    private final String actionName;
    private final String actionType;
    private final String actionInput;
    private final int conditionId;
    private final String conditionName;
    private final String conditionType;
    private final int millisecondsToWait;
    private final int millisecondsToCheck;
    private final int searchId;
    private String serviceAddress;

    public SearchStepDto(long id, String name, int pageId, String pageName, String pageUrl, int elementId, String elementName, String elementIdentifier, String elementIdentifierType, int actionId, String actionName, String actionType, String actionInput, int conditionId, String conditionName, String conditionType, int millisecondsToWait, int millisecondsToCheck, int searchId) {
        this.id = id;
        this.name = name;
        this.pageId = pageId;
        this.pageName = pageName;
        this.pageUrl = pageUrl;
        this.elementId = elementId;
        this.elementName = elementName;
        this.elementIdentifier = elementIdentifier;
        this.elementIdentifierType = elementIdentifierType;
        this.actionId = actionId;
        this.actionName = actionName;
        this.actionType = actionType;
        this.actionInput = actionInput;
        this.conditionId = conditionId;
        this.conditionName = conditionName;
        this.conditionType = conditionType;
        this.millisecondsToWait = millisecondsToWait;
        this.millisecondsToCheck = millisecondsToCheck;
        this.searchId = searchId;
    }

    public SearchStepDto() {
        this.id = 0;
        this.name = null;
        this.pageId = 0;
        this.pageName = null;
        this.pageUrl = null;
        this.elementId = 0;
        this.elementName = null;
        this.elementIdentifier = null;
        this.elementIdentifierType = null;
        this.actionId = 0;
        this.actionName = null;
        this.actionType = null;
        this.actionInput = null;
        this.conditionId = 0;
        this.conditionName = null;
        this.conditionType = null;
        this.millisecondsToWait = 0;
        this.millisecondsToCheck = 0;
        this.searchId = 0;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPageId() {
        return pageId;
    }

    public String getPageName() {
        return pageName;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public int getElementId() {
        return elementId;
    }

    public String getElementName() {
        return elementName;
    }

    public String getElementIdentifier() {
        return elementIdentifier;
    }

    public String getElementIdentifierType() {
        return elementIdentifierType;
    }

    public int getActionId() {
        return actionId;
    }

    public String getActionName() {
        return actionName;
    }

    public String getActionType() {
        return actionType;
    }

    public String getActionInput() {
        return actionInput;
    }

    public int getConditionId() {
        return conditionId;
    }

    public String getConditionName() {
        return conditionName;
    }

    public String getConditionType() {
        return conditionType;
    }

    public int getMillisecondsToWait() {
        return millisecondsToWait;
    }

    public int getMillisecondsToCheck() {
        return millisecondsToCheck;
    }

    public int getSearchId() {
        return searchId;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
}
