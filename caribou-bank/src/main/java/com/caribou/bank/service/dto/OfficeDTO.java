package com.caribou.bank.service.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * A DTO For {@link com.caribou.bank} Entity.
 */
public class OfficeDTO implements Serializable {

    private Long id;
    private String name;
    private Date openingDate;
    private String externalID;
    private Long parentID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getExternalID() {
        return externalID;
    }

    public void setExternalID(String externalID) {
        this.externalID = externalID;
    }
    public Long getParentID() {
        return parentID;
    }

    public void setParentID(Long parentID) {
        this.parentID = parentID;
    }

}
