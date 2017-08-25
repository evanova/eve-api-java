package com.tlabs.eve.esi.character;

public final class ESICharacterShipRequest extends ESICharacterRequest<ESICharacterShipResponse> {

    public ESICharacterShipRequest(final long charID) {
        super(ESICharacterShipResponse.class, charID);
        putParam("charID", charID);
    }

}
