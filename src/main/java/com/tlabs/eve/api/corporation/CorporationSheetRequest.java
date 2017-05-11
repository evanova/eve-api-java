package com.tlabs.eve.api.corporation;


//No or limited key
public final class CorporationSheetRequest extends CorporationRequest<CorporationSheetResponse> {
    public static final long MASK = 8;

    public CorporationSheetRequest(long corporationID) {
        super(CorporationSheetResponse.class, "/corp/CorporationSheet.xml.aspx", MASK, corporationID);
    }

}
