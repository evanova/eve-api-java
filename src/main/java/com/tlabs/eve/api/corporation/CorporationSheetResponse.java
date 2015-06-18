package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.EveAPIResponse;

public class CorporationSheetResponse extends EveAPIResponse {

    private static final long serialVersionUID = 8697424725674115722L;

    private CorporationSheet corporationInfo;

    public CorporationSheetResponse() {
        super();
        this.corporationInfo = new CorporationSheet();
    }

    public CorporationSheet getCorporationInfo() {
        return corporationInfo;
    }

    public void setCorporationInfo(CorporationSheet corporationInfo) {
        this.corporationInfo = corporationInfo;
    }
}
