package com.barak.api.website.website_api;

public class WebSiteDto {

    private final int id;
    private final String name;
    private final String description;
    private final String url;
    private final String preferredBrowser;
    private String serviceAddress;

    public WebSiteDto() {
        this.id = 0;
        this.name = null;
        this.description = null;
        this.url = null;
        this.preferredBrowser = null;
    }

    public WebSiteDto(int id, String name, String description, String url, BrowserType preferredBrowser) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.preferredBrowser = preferredBrowser.name();

    }

    public WebSiteDto(int id, String name, String description, String url, String preferredBrowser) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.preferredBrowser = preferredBrowser;

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

    public String getPreferredBrowser() {
        return preferredBrowser;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
}
