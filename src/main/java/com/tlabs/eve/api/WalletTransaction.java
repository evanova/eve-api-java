package com.tlabs.eve.api;



import java.io.Serializable;

public class WalletTransaction implements Serializable {

    private static final long serialVersionUID = -4573230706972924920L;

    private long when;
    private long id;

    private long journalID;

    private String typeName;
    private long typeID;

    private String clientName;
    private long clientID;

    private String stationName;
    private long stationID;

    private double price;
    private long quantity;

    private String type;

    public final long getWhen() {
        return when;
    }

    public final void setWhen(long when) {
        this.when = when;
    }

    public final long getID() {
        return id;
    }

    public final void setID(long id) {
        this.id = id;
    }

    public final String getTypeName() {
        return typeName;
    }

    public final void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public final long getTypeID() {
        return typeID;
    }

    public final void setTypeID(long typeID) {
        this.typeID = typeID;
    }

    public final String getClientName() {
        return clientName;
    }

    public final void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public final long getClientID() {
        return clientID;
    }

    public final void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public final String getStationName() {
        return stationName;
    }

    public final void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public final long getStationID() {
        return stationID;
    }

    public final void setStationID(long stationID) {
        this.stationID = stationID;
    }

    public final double getPrice() {
        return price;
    }

    public final void setPrice(double price) {
        this.price = price;
    }

    public final long getQuantity() {
        return quantity;
    }

    public final void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public final String getType() {
        return type;
    }

    public final void setType(String type) {
        this.type = type;
    }

    public long getJournalID() {
        return journalID;
    }

    public void setJournalID(long journalId) {
        this.journalID = journalId;
    }
}
