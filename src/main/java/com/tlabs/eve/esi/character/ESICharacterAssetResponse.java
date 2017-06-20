package com.tlabs.eve.esi.character;

import com.tlabs.eve.EveTime;
import com.tlabs.eve.esi.model.ESIAsset;

import java.util.List;

public final class ESICharacterAssetResponse extends ESICharacterResponse {

    private List<ESIAsset> assets;

    public ESICharacterAssetResponse() {
        setCachedUntil(EveTime.now() + 3600 * 1000);
    }

    public List<ESIAsset> getAssets() {
        return assets;
    }

    public ESICharacterAssetResponse setAssets(List<ESIAsset> assets) {
        this.assets = assets;
        return this;
    }
}
