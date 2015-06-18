package com.tlabs.eve.api.character;



import com.tlabs.eve.api.AssetListResponse;

import junit.framework.Assert;

import org.junit.Test;

public final class CharacterAssetTest extends CharacterApiTest {

    @Test(timeout = 10000)
    public void testCharacterAssets() throws Exception {
        AssetListResponse assets = apiCall(new CharacterAssetsRequest(characterKey.id));
        Assert.assertNotNull("AssetListResponse returned null Assets", assets.getAssets());
        Assert.assertTrue("AssetListResponse returned no Assets", assets.getAssets().size() > 0);
    }

}
