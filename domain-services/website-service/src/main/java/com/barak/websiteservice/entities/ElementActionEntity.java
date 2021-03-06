package com.barak.websiteservice.entities;

import com.barak.api.website.element_action_api.ActionType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "element_actions")
public class ElementActionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version
    private Integer version;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "action_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ActionType actionType;

    @Column(name = "action_input")
    private String actionInput;

    @ManyToMany
    private List<ActionConditionEntity> actionCondition;

    @ManyToMany
    private List<WebElementEntity> webElements;

    public ElementActionEntity(int id, String name, String description, ActionType actionType, String actionInput) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.actionType = actionType;
        this.actionInput = actionInput;

    }

    public ElementActionEntity() {
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

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public String getActionInput() {
        return actionInput;
    }

    public void setActionInput(String actionInput) {
        this.actionInput = actionInput;
    }

    public List<ActionConditionEntity> getActionCondition() {
        return actionCondition;
    }

    public void setActionCondition(List<ActionConditionEntity> actionCondition) {
        this.actionCondition = actionCondition;
    }

    public List<WebElementEntity> getWebElements() {
        return webElements;
    }

    public void setWebElements(List<WebElementEntity> webElements) {
        this.webElements = webElements;
    }

    public Integer getVersion() {
        return version;
    }
}
