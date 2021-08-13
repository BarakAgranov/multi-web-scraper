package com.barak.searchservice.entities;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "searches")
public class SearchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "website_id", nullable = false)
    private int websiteId;

    @Column(name = "website_name", nullable = false)
    private String websiteName;

    @Column(name = "preferred_browser", nullable = false)
    private String preferredBrowser;

    @Column(name = "website_url", nullable = false)
    private String websiteUrl;

    @ManyToMany
    private List<SearchStepEntity> searchSteps;

    public SearchEntity(int id, String name, String description,int websiteId, String websiteName, String preferredBrowser, String websiteUrl, List<SearchStepEntity> searchSteps) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.websiteId = websiteId;
        this.websiteName = websiteName;
        this.preferredBrowser = preferredBrowser;
        this.websiteUrl = websiteUrl;
        this.searchSteps = searchSteps;
    }

    public SearchEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getPreferredBrowser() {
        return preferredBrowser;
    }

    public void setPreferredBrowser(String preferredBrowser) {
        this.preferredBrowser = preferredBrowser;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public List<SearchStepEntity> getSearchSteps() {
        return searchSteps;
    }

    public void setSearchSteps(List<SearchStepEntity> searchSteps) {
        this.searchSteps = searchSteps;
    }

    public int getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(int websiteId) {
        this.websiteId = websiteId;
    }
}
