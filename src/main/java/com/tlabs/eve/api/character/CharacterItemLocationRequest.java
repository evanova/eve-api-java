package com.tlabs.eve.api.character;



import com.tlabs.eve.api.EveAPI;
import com.tlabs.eve.api.ItemLocationResponse;

public final class CharacterItemLocationRequest extends CharacterRequest<ItemLocationResponse> {

    public static final int MASK = EveAPI.CHAR_FULL; //FIXME CAK not known yet

    public CharacterItemLocationRequest(String charID, long[] ids) {
        super(ItemLocationResponse.class, "/char/Locations.xml.aspx", MASK, charID);
        putParam("ids", filter(ids));//API rejects duplicates
    }

}
