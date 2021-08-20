package com.barak.searchservice.entities;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "search_steps")
public class SearchStepEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Version
    private Integer version;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "page_id", nullable = false)
    private int pageId;

    @Column(name = "page_name", nullable = false)
    private String pageName;

    @Column(name = "page_url", nullable = false)
    private String pageUrl;

    @Column(name = "element_id", nullable = false)
    private int elementId;

    @Column(name = "element_name", nullable = false)
    private String elementName;

    @Column(name = "element_identifier", nullable = false)
    private String elementIdentifier;

    @Column(name = "element_identifier_type", nullable = false)
    private String elementIdentifierType;

    @Column(name = "action_id", nullable = false)
    private int actionId;

    @Column(name = "action_name", nullable = false)
    private String actionName;

    @Column(name = "action_type", nullable = false)
    private String actionType;

    @Column(name = "action_input", nullable = false)
    private String actionInput;

    @Column(name = "condition_id", nullable = false)
    private int conditionId;

    @Column(name = "condition_name", nullable = false)
    private String conditionName;

    @Column(name = "condition_type", nullable = false)
    private String conditionType;

    @Column(name = "milliseconds_to_wait", nullable = false)
    private int millisecondsToWait;

    @Column(name = "milliseconds_to_check", nullable = false)
    private int millisecondsToCheck;

    @ManyToMany
    private List<SearchEntity> searches;

    public SearchStepEntity(long id, String name, int pageId, String pageName, String pageUrl, int elementId, String elementName, String elementIdentifier, String elementIdentifierType, int actionId, String actionName, String actionType, String actionInput, int conditionId, String conditionName, String conditionType, int millisecondsToWait, int millisecondsToCheck, List<SearchEntity> searches) {
        this.id = id;
        this.name = name;
        this.pageId = pageId;
        this.pageName = pageName;
        this.pageUrl = pageUrl;
        this.elementId = elementId;
        this.elementName = elementName;
        this.elementIdentifier = elementIdentifier;
        this.elementIdentifierType = elementIdentifierType;
        this.actionId = actionId;
        this.actionName = actionName;
        this.actionType = actionType;
        this.actionInput = actionInput;
        this.conditionId = conditionId;
        this.conditionName = conditionName;
        this.conditionType = conditionType;
        this.millisecondsToWait = millisecondsToWait;
        this.millisecondsToCheck = millisecondsToCheck;
        this.searches = searches;
    }

    public SearchStepEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getElementIdentifier() {
        return elementIdentifier;
    }

    public void setElementIdentifier(String elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public String getElementIdentifierType() {
        return elementIdentifierType;
    }

    public void setElementIdentifierType(String elementIdentifierType) {
        this.elementIdentifierType = elementIdentifierType;
    }

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getActionInput() {
        return actionInput;
    }

    public void setActionInput(String actionInput) {
        this.actionInput = actionInput;
    }

    public int getConditionId() {
        return conditionId;
    }

    public void setConditionId(int conditionId) {
        this.conditionId = conditionId;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    public int getMillisecondsToWait() {
        return millisecondsToWait;
    }

    public void setMillisecondsToWait(int millisecondsToWait) {
        this.millisecondsToWait = millisecondsToWait;
    }

    public int getMillisecondsToCheck() {
        return millisecondsToCheck;
    }

    public void setMillisecondsToCheck(int millisecondsToCheck) {
        this.millisecondsToCheck = millisecondsToCheck;
    }

    public List<SearchEntity> getSearches() {
        return searches;
    }

    public void setSearches(List<SearchEntity> searches) {
        this.searches = searches;
    }
}
