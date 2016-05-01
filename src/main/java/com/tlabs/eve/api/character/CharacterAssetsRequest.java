package com.tlabs.eve.api.character;



import com.tlabs.eve.api.AssetListResponse;

public final class CharacterAssetsRequest extends CharacterRequest<AssetListResponse> {

    public static final long MASK = 2;

    public CharacterAssetsRequest(String characterID) {
        super(AssetListResponse.class, "/char/AssetList.xml.aspx", MASK, characterID);
    }

}
