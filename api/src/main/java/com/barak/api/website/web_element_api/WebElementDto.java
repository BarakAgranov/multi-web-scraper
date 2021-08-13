package com.barak.api.website.web_element_api;

public class WebElementDto {

    private final int id;
    private final String name;
    private final String description;
    private final String identifier;
    private final String identifierType;
    private final int pageId;
    private String serviceAddress;

    public WebElementDto(int id, String name, String description, String identifier, String identifierType, int pageId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.identifier = identifier;
        this.identifierType = identifierType;
        this.pageId = pageId;
    }

    public WebElementDto() {
        this.id = 0;
        this.name = null;
        this.description = null;
        this.identifier = null;
        this.identifierType = null;
        this.pageId = 0;
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

    public String getIdentifier() {
        return identifier;
    }

    public String getIdentifierType() {
        return identifierType;
    }

    public int getPageId() {
        return pageId;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
}
