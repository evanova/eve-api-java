package com.tlabs.eve.api;



//This can actually query item names, ids, stations, etc.
//@see http://wiki.eve-id.net/APIv2_Eve_CharacterName_XML
//@see http://wiki.eve-id.net/APIv2_Eve_CharacterID_XML
@Deprecated //since ESI
public final class NamesRequest extends EveAPIRequest<NamesResponse> {

    public NamesRequest(String[] names) {
        super(NamesResponse.class, "/eve/CharacterID.xml.aspx", 0);
        putParam("names", filter(names));//API rejects duplicates
    }

    public NamesRequest(long[] ids) {
        super(NamesResponse.class, "/eve/CharacterName.xml.aspx", 0);
        putParam("ids", filter(ids));//API rejects duplicates
    }

    public NamesRequest(Long[] ids) {
        super(NamesResponse.class, "/eve/CharacterName.xml.aspx", 0);
        putParam("ids", filter(ids));//API rejects duplicates
    }

}
