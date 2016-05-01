/**
 * 
 */
package com.tlabs.eve.api.character;



//https://forums.eveonline.com/default.aspx?g=posts&m=4469997#post4469997
public final class PlanetaryColoniesRequest extends CharacterRequest<PlanetaryColoniesResponse> {
    public static final long MASK = 2;

    public PlanetaryColoniesRequest(String charID) {
        super(PlanetaryColoniesResponse.class, "/char/PlanetaryColonies.xml.aspx", MASK, charID);
    }

}
