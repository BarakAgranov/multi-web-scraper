package com.barak.api.website.webpage_api;

import com.barak.api.website.WebSiteComponent;

public class WebPageDto extends WebSiteComponent {

    private final int id;
    private final String name;
    private final String description;
    private final String url;
    private final int webSiteId;
    private String serviceAddress;

    public WebPageDto(int id, String name, String description, String url, int webSiteId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.webSiteId = webSiteId;

    }

    public WebPageDto() {
        this.id = 0;
        this.name = null;
        this.description = null;
        this.url = null;
        this.webSiteId = 0;
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

    public String getUrl() {
        return url;
    }

    public int getWebSiteId() {
        return webSiteId;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
}
