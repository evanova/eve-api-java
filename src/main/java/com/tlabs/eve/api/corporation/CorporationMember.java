package com.tlabs.eve.api.corporation;



import java.io.Serializable;

public class CorporationMember implements Serializable {

    private static final long serialVersionUID = -6308580576878031835L;

    private long characterID;

    private String name;

    private long startDateTime;

    private long baseID;

    private String base;

    private String title;

    private long logonDateTime;

    private long logoffDateTime;

    private long locationID;

    private String location;

    private int shipTypeID;

    private String shipType;

    private long roles;

    private long grantableRoles;

    public CorporationMember() {
        super();
    }

    public long getCharacterID() {
        return characterID;
    }

    public void setCharacterID(long characterID) {
        this.characterID = characterID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(long startDateTime) {
        this.startDateTime = startDateTime;
    }

    public long getBaseID() {
        return baseID;
    }

    public void setBaseID(long baseID) {
        this.baseID = baseID;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getLogonDateTime() {
        return logonDateTime;
    }

    public void setLogonDateTime(long logonDateTime) {
        this.logonDateTime = logonDateTime;
    }

    public long getLogoffDateTime() {
        return logoffDateTime;
    }

    public void setLogoffDateTime(long logoffDateTime) {
        this.logoffDateTime = logoffDateTime;
    }

    public long getLocationID() {
        return locationID;
    }

    public void setLocationID(long locationID) {
        this.locationID = locationID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getShipTypeID() {
        return shipTypeID;
    }

    public void setShipTypeID(int shipTypeID) {
        this.shipTypeID = shipTypeID;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public long getRoles() {
        return roles;
    }

    public void setRoles(long roles) {
        this.roles = roles;
    }

    public long getGrantableRoles() {
        return grantableRoles;
    }

    public void setGrantableRoles(long grantableRoles) {
        this.grantableRoles = grantableRoles;
    }

}
