/**
 * 
 */
package com.tlabs.eve.api.character;



//https://forums.eveonline.com/default.aspx?g=posts&m=4469997#post4469997
public final class PlanetaryLinksRequest extends CharacterRequest<PlanetaryLinksResponse> {
    public static final int MASK = 2;

    public PlanetaryLinksRequest(final String charID, final String planetID) {
        super(PlanetaryLinksResponse.class, "/char/PlanetaryLinks.xml.aspx", MASK, charID);
        putParam("planetID", planetID);
    }

}
