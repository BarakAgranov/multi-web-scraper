package com.barak.websiteservice.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "web_pages")
public class WebPageEntity implements Serializable {

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

    @ManyToOne
    private WebSiteEntity webSiteEntity;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "webPageEntity")
    private List<WebElementEntity> webElementEntities;

    public WebPageEntity(int id, String name, String url, String description, WebSiteEntity webSiteEntity) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.description = description;
        this.webSiteEntity = webSiteEntity;

    }

    public WebPageEntity() {
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

    public WebSiteEntity getWebSiteEntity() {
        return webSiteEntity;
    }

    public void setWebSiteEntity(WebSiteEntity webSiteEntity) {
        this.webSiteEntity = webSiteEntity;
    }

    public List<WebElementEntity> getWebElementEntities() {
        return webElementEntities;
    }

    public void setWebElementEntities(List<WebElementEntity> webElementEntities) {
        this.webElementEntities = webElementEntities;
    }

    public Integer getVersion() {
        return version;
    }
}
