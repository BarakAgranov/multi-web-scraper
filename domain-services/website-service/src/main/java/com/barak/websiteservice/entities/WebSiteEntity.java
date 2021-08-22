package com.barak.websiteservice.entities;

import com.barak.api.website.website_api.BrowserType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "web_sites")
public class WebSiteEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version
    private Integer version;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "url", nullable = false, unique = true)
    private String url;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "preferred_browser", nullable = false)
    @Enumerated(EnumType.STRING)
    private BrowserType preferredBrowser;

    @OneToMany(mappedBy = "webSiteEntity", cascade = CascadeType.REMOVE)
    private List<WebPageEntity> webPages;

    public WebSiteEntity(int id, String name, String url, String description, BrowserType preferredBrowser) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.description = description;
        this.preferredBrowser = preferredBrowser;

    }

    public WebSiteEntity() {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BrowserType getPreferredBrowser() {
        return preferredBrowser;
    }

    public void setPreferredBrowser(BrowserType preferredBrowser) {
        this.preferredBrowser = preferredBrowser;
    }

    public List<WebPageEntity> getWebPages() {
        return webPages;
    }

    public void setWebPages(List<WebPageEntity> webPages) {
        this.webPages = webPages;
    }

    public Integer getVersion() {
        return version;
    }
}
