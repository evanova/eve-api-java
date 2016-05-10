package com.tlabs.eve.api;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.tlabs.eve.api.character.CharacterSheet;

/**@since Eve API V3 (30 Aug 2011*/
public class AccessInfo implements Serializable {

    private static final long serialVersionUID = -4920885693131283908L;

    public static final int UNKNOWN = -1;
    public static final int CHARACTER = 0;
    public static final int CORPORATION = 1;
    public static final int ACCOUNT = 2;

    private long accessMask = 0;

    private int type = UNKNOWN;

    private long expires = 0;

    private List<CharacterSheet> characters = new ArrayList<>();

    public AccessInfo() {
        super();
    }

    public final long getAccessMask() {
        return accessMask;
    }

    public final void setAccessMask(long accessMask) {
        this.accessMask = accessMask;
    }

    public final int getType() {
        return type;
    }

    public final void setType(String type) {
        if ("Account".equalsIgnoreCase(type)) {
            this.type = ACCOUNT;
            return;
        }
        if ("Character".equalsIgnoreCase(type)) {
            this.type = CHARACTER;
            return;
        }
        if ("Corporation".equalsIgnoreCase(type)) {
            this.type = CORPORATION;
            return;
        }

        this.type = UNKNOWN;
    }

    public final void setType(int type) {
        this.type = type;
    }

    public final long getExpires() {
        return expires;
    }

    public final void setExpires(long expires) {
        this.expires = expires;
    }

    public final void setExpires(String expires) {
        this.expires = EveAPI.parseDateTime(expires);
    }

    public void addCharacter(CharacterSheet c) {
        this.characters.add(c);
    }

    public List<CharacterSheet> getCharacters() {
        return this.characters;
    }

}
