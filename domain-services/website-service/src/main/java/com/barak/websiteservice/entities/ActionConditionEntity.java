package com.barak.websiteservice.entities;


import com.barak.api.website.action_condition_api.ConditionType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "action_conditions")
public class ActionConditionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version
    private Integer version;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "condition_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ConditionType conditionType;

    @Column(name = "milliseconds_to_wait")
    private short millisecondsToWait;

    @Column(name = "milliseconds_to_check")
    private short millisecondsToCheck;

    @ManyToMany
    private List<ElementActionEntity> elementActions;

    public ActionConditionEntity(int id, String name, String description, ConditionType conditionType, short millisecondsToWait, short millisecondsToCheck) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.conditionType = conditionType;
        this.millisecondsToWait = millisecondsToWait;
        this.millisecondsToCheck = millisecondsToCheck;
    }

    public ActionConditionEntity() {
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

    public ConditionType getConditionType() {
        return conditionType;
    }

    public void setConditionType(ConditionType conditionType) {
        this.conditionType = conditionType;
    }

    public short getMillisecondsToWait() {
        return millisecondsToWait;
    }

    public void setMillisecondsToWait(short millisecondsToWait) {
        this.millisecondsToWait = millisecondsToWait;
    }

    public short getMillisecondsToCheck() {
        return millisecondsToCheck;
    }

    public void setMillisecondsToCheck(short millisecondsToCheck) {
        this.millisecondsToCheck = millisecondsToCheck;
    }

    public List<ElementActionEntity> getElementActions() {
        return elementActions;
    }

    public void setElementActions(List<ElementActionEntity> elementActions) {
        this.elementActions = elementActions;
    }

    public Integer getVersion() {
        return version;
    }

}
