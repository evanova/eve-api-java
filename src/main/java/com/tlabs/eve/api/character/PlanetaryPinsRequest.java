/**
 * 
 */
package com.tlabs.eve.api.character;



//https://forums.eveonline.com/default.aspx?g=posts&m=4469997#post4469997
public final class PlanetaryPinsRequest extends CharacterRequest<PlanetaryPinsResponse> {
    public static final long MASK = 2;

    public PlanetaryPinsRequest(final long charID, final long planetID) {
        super(PlanetaryPinsResponse.class, "/char/PlanetaryPins.xml.aspx", MASK, charID);
        putParam("planetID", planetID);
    }
}
