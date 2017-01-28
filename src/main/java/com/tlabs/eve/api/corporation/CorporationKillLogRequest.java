package com.tlabs.eve.api.corporation;

import com.tlabs.eve.api.mail.KillLogResponse;

public final class CorporationKillLogRequest extends CorporationRequest<KillLogResponse> {
    public static final long MASK = 256;

    public CorporationKillLogRequest(final long corporationID) {
        super(KillLogResponse.class, "/corp/KillLog.xml.aspx", MASK, corporationID);
    }
}
