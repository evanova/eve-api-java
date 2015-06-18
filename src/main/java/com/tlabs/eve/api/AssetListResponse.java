package com.tlabs.eve.api;



import java.util.LinkedList;
import java.util.List;

public class AssetListResponse extends EveAPIResponse {

    private static final long serialVersionUID = 3490157713158182612L;

    private List<Asset> assets;

    public AssetListResponse() {
        this.assets = new LinkedList<>();
    }

    public void addAsset(Asset item) {
        this.assets.add(item);
    }

    public List<Asset> getAssets() {
        return this.assets;
    }
}
