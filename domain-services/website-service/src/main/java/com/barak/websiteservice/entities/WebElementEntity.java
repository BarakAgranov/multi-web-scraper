package com.barak.websiteservice.entities;

import com.barak.api.website.web_element_api.ElementIdentifierType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "web_elements")
public class WebElementEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version
    private Integer version;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "identifier", nullable = false)
    private String identifier;

    @Column(name = "identifier_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ElementIdentifierType identifierType;

    @ManyToOne
    private WebPageEntity webPageEntity;

    @ManyToMany
    private List<ElementActionEntity> actionEntities;

    public WebElementEntity(int id, String name, String description, String identifier, ElementIdentifierType identifierType, WebPageEntity webPageEntity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.identifier = identifier;
        this.identifierType = identifierType;
        this.webPageEntity = webPageEntity;
    }

    public WebElementEntity() {
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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public ElementIdentifierType getIdentifierType() {
        return identifierType;
    }

    public void setIdentifierType(ElementIdentifierType identifierType) {
        this.identifierType = identifierType;
    }

    public WebPageEntity getWebPageEntity() {
        return webPageEntity;
    }

    public void setWebPageEntity(WebPageEntity webPageEntity) {
        this.webPageEntity = webPageEntity;
    }

    public List<ElementActionEntity> getActionEntities() {
        return actionEntities;
    }

    public void setActionEntities(List<ElementActionEntity> actionEntities) {
        this.actionEntities = actionEntities;
    }

    public Integer getVersion() {
        return version;
    }
}
