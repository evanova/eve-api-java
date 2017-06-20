package com.tlabs.eve.evemon;

public class EveMonAccount {

    /*propertyMap = new HashMap<>();
    propertyMap.put("id", "keyID");
    propertyMap.put("vCode", "key");
    propertyMap.put("accessMask", "accessMask");
    propertyMap.put("type", "type");*/

    private String keyID;
    private String keyValue;

    private long accessMask;
    private int type;

    public String getKeyID() {
        return keyID;
    }

    public void setKeyID(String keyID) {
        this.keyID = keyID;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public long getAccessMask() {
        return accessMask;
    }

    public void setAccessMask(long accessMask) {
        this.accessMask = accessMask;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
