package com.tlabs.eve.api.corporation;

import com.tlabs.eve.api.KillLogResponse;

public final class CorporationKillLogRequest extends CorporationRequest<KillLogResponse> {
    public static final int MASK = 256;
    
    public CorporationKillLogRequest(final String corporationID) {
        super(KillLogResponse.class, "/corp/KillLog.xml.aspx", MASK,  corporationID);
    }
}
