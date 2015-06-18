package com.tlabs.eve.api.corporation;



import java.io.Serializable;

public class CorporationRole implements Serializable {

    private static final long serialVersionUID = -6935531269888699875L;

    public static final int AT_CORP = 0;
    public static final int AT_HQ = 1;
    public static final int AT_BASE = 2;
    public static final int AT_OTHER = 3;

    private int type;
    private long roleID;
    private String roleName;

    public CorporationRole(int type) {
        this.type = type;
    }

    public long getRoleID() {
        return roleID;
    }

    public void setRoleID(long roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getType() {
        return type;
    }

}
