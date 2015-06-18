package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.EveAPIRequest.Public;

//No or limited key
public final class CorporationSheetRequest extends CorporationRequest<CorporationSheetResponse> implements Public {
    public static final int MASK = 8;

    public CorporationSheetRequest(String corporationID) {
        super(CorporationSheetResponse.class, "/corp/CorporationSheet.xml.aspx", MASK, corporationID);
    }

}
