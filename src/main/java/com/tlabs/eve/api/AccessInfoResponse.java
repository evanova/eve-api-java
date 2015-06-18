package com.tlabs.eve.api;



import com.tlabs.eve.api.character.CharacterSheet;

import java.util.List;

/**@since Eve API V3 (30 Aug 2011*/
public class AccessInfoResponse extends EveAPIResponse {

    private static final long serialVersionUID = -4592852922232440448L;

    private final AccessInfo accessInfo;

    public AccessInfoResponse() {
        super();
        this.accessInfo = new AccessInfo();
    }

    public AccessInfo getAccessInfo() {
        return accessInfo;
    }

    @Deprecated
    public final int getAccessMask() {
        return this.accessInfo.getAccessMask();
    }

    @Deprecated
    public final void setAccessMask(int accessMask) {
        this.accessInfo.setAccessMask(accessMask);
    }

    @Deprecated
    public final int getType() {
        return this.accessInfo.getType();
    }

    @Deprecated
    public final void setType(String type) {
        this.accessInfo.setType(type);
    }

    @Deprecated
    public final long getExpires() {
        return this.accessInfo.getExpires();
    }

    @Deprecated
    public final void setExpires(long expires) {
        this.accessInfo.setExpires(expires);
    }

    @Deprecated
    public final void setExpires(String expires) {
        this.accessInfo.setExpires(expires);
    }

    @Deprecated
    public final long getKeyID() {
        return this.accessInfo.getKeyID();
    }

    @Deprecated
    public final void setKeyID(long keyID) {
        this.accessInfo.setKeyID(keyID);
    }

    @Deprecated
    public void addCharacter(CharacterSheet c) {
        this.accessInfo.addCharacter(c);
    }

    @Deprecated
    public List<CharacterSheet> getCharacters() {
        return this.accessInfo.getCharacters();
    }
}
