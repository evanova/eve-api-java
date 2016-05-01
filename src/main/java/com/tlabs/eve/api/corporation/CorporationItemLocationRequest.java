package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.EveAPI;
import com.tlabs.eve.api.ItemLocationResponse;

public final class CorporationItemLocationRequest extends CorporationRequest<ItemLocationResponse> {

    public static final long MASK = EveAPI.CORP_FULL; //FIXME CAK not known yet

    public CorporationItemLocationRequest(String corpID, long[] ids) {
        super(ItemLocationResponse.class, "/corp/Locations.xml.aspx", MASK, corpID);
        putParam("ids", filter(ids));//API rejects duplicates
    }

}
