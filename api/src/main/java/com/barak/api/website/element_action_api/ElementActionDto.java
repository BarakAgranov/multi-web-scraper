package com.barak.api.website.element_action_api;

public class ElementActionDto {

    private final int id;
    private final String name;
    private final String description;
    private final String actionType;
    private final String actionInput;
    private String serviceAddress;

    public ElementActionDto(int id, String name, String description, String actionType, String actionInput) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.actionType = actionType;
        this.actionInput = actionInput;
    }

    public ElementActionDto(int id, String name, String description, ActionType actionType, String actionInput) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.actionType = actionType.name();
        this.actionInput = actionInput;
    }

    public ElementActionDto() {
        this.id = 0;
        this.name = null;
        this.description = null;
        this.actionType = null;
        this.actionInput = null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getActionType() {
        return actionType;
    }

    public String getActionInput() {
        return actionInput;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
}
