package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.AssetListResponse;

public class CorporationAssetsRequest extends CorporationRequest<AssetListResponse> {
    public static final long MASK = 2;

    public CorporationAssetsRequest(String corpID) {
        super(AssetListResponse.class, "/corp/AssetList.xml.aspx", MASK, corpID);
    }

}
