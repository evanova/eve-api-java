package com.tlabs.eve.esi.impl;

import com.tlabs.eve.esi.model.ESIAsset;
import org.devfleet.esi.model.GetCharactersCharacterIdAssets200Ok;

final class AssetTransformer {

    private AssetTransformer() {

    }

    public static ESIAsset transform(final GetCharactersCharacterIdAssets200Ok object) {
        final ESIAsset asset = new ESIAsset();
        asset.setItemId(object.getItemId());
        asset.setLocationId(object.getLocationId());
        asset.setLocationFlag(Enum.valueOf(ESIAsset.LocationFlag.class, object.getLocationFlag().name()));
        asset.setLocationType(Enum.valueOf(ESIAsset.LocationType.class, object.getLocationType().name()));
        asset.setQuantity(object.getQuantity());
        asset.setSingleton(object.getIsSingleton());
        asset.setTypeId(object.getTypeId());
        return asset;

    }
}
