/**
 * 
 */
package com.tlabs.eve.api.character;



//https://forums.eveonline.com/default.aspx?g=posts&m=4469997#post4469997
public final class PlanetaryRoutesRequest extends CharacterRequest<PlanetaryRoutesResponse> {
    public static final int MASK = 2;

    public PlanetaryRoutesRequest(final String charID, final String planetID) {
        super(PlanetaryRoutesResponse.class, "/char/PlanetaryRoutes.xml.aspx", MASK, charID);
        putParam("planetID", planetID);
    }
}
