package com.tlabs.eve.api.character;



import com.tlabs.eve.api.AssetListResponse;

public final class CharacterAssetsRequest extends CharacterRequest<AssetListResponse> {

    public static final long MASK = 2;

    public CharacterAssetsRequest(long characterID) {
        super(AssetListResponse.class, "/char/AssetList.xml.aspx", MASK, characterID);
    }

    //undocumented feature - also returns corp assets according to CCP Zoetrope
    public CharacterAssetsRequest(long characterID, long corporationID) {
        this(characterID);
        putParam("corporationID", corporationID);
    }

}
