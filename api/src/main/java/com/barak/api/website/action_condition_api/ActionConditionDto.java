package com.barak.api.website.action_condition_api;

import com.barak.api.website.WebSiteComponent;

public class ActionConditionDto extends WebSiteComponent {

    private final int id;
    private final String name;
    private final String description;
    private final String  conditionType;
    private final short millisecondsToWait;
    private final short millisecondsToCheck;
    private String serviceAddress;

    public ActionConditionDto(int id, String name, String description, String conditionType, short millisecondsToWait, short millisecondsToCheck) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.conditionType = conditionType;
        this.millisecondsToWait = millisecondsToWait;
        this.millisecondsToCheck = millisecondsToCheck;
    }

    public ActionConditionDto() {
        this.id = 0;
        this.name = null;
        this.description = null;
        this.conditionType = null;
        this.millisecondsToWait = 0;
        this.millisecondsToCheck = 0;
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

    public String getConditionType() {
        return conditionType;
    }

    public short getMillisecondsToWait() {
        return millisecondsToWait;
    }

    public short getMillisecondsToCheck() {
        return millisecondsToCheck;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
}
