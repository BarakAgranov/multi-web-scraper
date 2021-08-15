package com.barak.api.search.search_api;

public class SearchDto {

    private int id;
    private String name;
    private String description;
    private int websiteId;
    private String websiteName;
    private String preferredBrowser;
    private String websiteUrl;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWebsiteId(int websiteId) {
        this.websiteId = websiteId;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public void setPreferredBrowser(String preferredBrowser) {
        this.preferredBrowser = preferredBrowser;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
}
