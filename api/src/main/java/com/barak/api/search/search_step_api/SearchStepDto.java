package com.barak.api.search.search_step_api;

public class SearchStepDto {

    private long id;
    private String name;
    private int pageId;
    private String pageName;
    private String pageUrl;
    private int elementId;
    private String elementName;
    private String elementIdentifier;
    private String elementIdentifierType;
    private int actionId;
    private String actionName;
    private String actionType;
    private String actionInput;
    private int conditionId;
    private String conditionName;
    private String conditionType;
    private int millisecondsToWait;
    private int millisecondsToCheck;
    private String serviceAddress;

    public SearchStepDto(long id, String name, int pageId, String pageName, String pageUrl, int elementId, String elementName, String elementIdentifier, String elementIdentifierType, int actionId, String actionName, String actionType, String actionInput, int conditionId, String conditionName, String conditionType, int millisecondsToWait, int millisecondsToCheck) {
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

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public void setElementIdentifier(String elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public void setElementIdentifierType(String elementIdentifierType) {
        this.elementIdentifierType = elementIdentifierType;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public void setActionInput(String actionInput) {
        this.actionInput = actionInput;
    }

    public void setConditionId(int conditionId) {
        this.conditionId = conditionId;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    public void setMillisecondsToWait(int millisecondsToWait) {
        this.millisecondsToWait = millisecondsToWait;
    }

    public void setMillisecondsToCheck(int millisecondsToCheck) {
        this.millisecondsToCheck = millisecondsToCheck;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
}
