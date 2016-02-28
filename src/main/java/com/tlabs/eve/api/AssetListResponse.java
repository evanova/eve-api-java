package com.tlabs.eve.api;


import java.util.ArrayList;
import java.util.List;

public class AssetListResponse extends EveAPIResponse {

    private static final long serialVersionUID = 3490157713158182612L;

    private List<Asset> assets;

    public AssetListResponse() {
        this.assets = new ArrayList<>();
    }

    public void addAsset(Asset item) {
        this.assets.add(item);
    }

    public List<Asset> getAssets() {
        return this.assets;
    }
}
