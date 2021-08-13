package com.barak.api.search.search_api;

public class SearchDto {

    private final int id;
    private final String name;
    private final String description;
    private final int websiteId;
    private final String websiteName;
    private final String preferredBrowser;
    private final String websiteUrl;
    private String serviceAddress;

    public SearchDto(int id, String name, String description, int websiteId, String websiteName, String preferredBrowser, String websiteUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.websiteId = websiteId;
        this.websiteName = websiteName;
        this.preferredBrowser = preferredBrowser;
        this.websiteUrl = websiteUrl;
    }

    public SearchDto() {
        this.id = 0;
        this.name = null;
        this.description = null;
        this.websiteId = 0;
        this.websiteName = null;
        this.preferredBrowser = null;
        this.websiteUrl = null;
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

    public int getWebsiteId() {
        return websiteId;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public String getPreferredBrowser() {
        return preferredBrowser;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
}
