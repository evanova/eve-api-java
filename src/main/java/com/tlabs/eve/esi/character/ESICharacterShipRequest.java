package com.tlabs.eve.esi.character;

public final class ESICharacterShipRequest extends ESICharacterRequest<ESICharacterShipResponse> {

    public ESICharacterShipRequest(final long charID) {
        super(
                ESICharacterShipResponse.class,
                charID,
                "esi-location.read_ship_type.v1");
        putParam("charID", charID);
    }

}
