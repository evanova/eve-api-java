package com.tlabs.eve.api.character;

import com.tlabs.eve.api.KillLogResponse;

public final class CharacterKillLogRequest extends CharacterRequest<KillLogResponse>{
    public static final int MASK = 256;
    
    public CharacterKillLogRequest(final String charID) {
        super(KillLogResponse.class, "/char/KillLog.xml.aspx", MASK,  charID);
    }
}
