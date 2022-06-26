package com.caribou.bank.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Office entity;
 */

@Entity
@Table(name = "m_office", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"}, name = "name_UNIQUE"), @UniqueConstraint(columnNames = {"opening_date_UNIQUE"})})
@SequenceGenerator(name = "sequence-generator", initialValue = 1, sequenceName = "Office_sequence")
public class Office extends AbstractPersistableCustom implements Serializable {


    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "opening_Date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date openingDate;

    @Column(name = "external_id", length = 100)
    private String externalId;


    // self relationship
    //ye parent ba majmooei az child ha rabete dare
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private Set<Office> children = new HashSet<>();

    // many child ertebate manyToOne dare ba parent
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Office parent;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Set<Office> getChildren() {
        return children;
    }

    public void setChildren(Set<Office> children) {
        this.children = children;
    }

    public Office getParent() {
        return parent;
    }

    public void setParent(Office parent) {
        this.parent = parent;
    }
}
