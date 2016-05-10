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

    public final long getAccessMask() {
        return this.accessInfo.getAccessMask();
    }

    public final void setAccessMask(long accessMask) {
        this.accessInfo.setAccessMask(accessMask);
    }

    public final int getType() {
        return this.accessInfo.getType();
    }

    public final void setType(String type) {
        this.accessInfo.setType(type);
    }

    public final long getExpires() {
        return this.accessInfo.getExpires();
    }

    public final void setExpires(long expires) {
        this.accessInfo.setExpires(expires);
    }

    public final void setExpires(String expires) {
        this.accessInfo.setExpires(expires);
    }

    public void addCharacter(CharacterSheet c) {
        this.accessInfo.addCharacter(c);
    }

    public List<CharacterSheet> getCharacters() {
        return this.accessInfo.getCharacters();
    }
}
