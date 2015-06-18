package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.AssetListResponse;

import org.junit.Test;

public final class CorporationAssetTest extends CorporationApiTest {

    @Test(timeout = 10000)
    public void testFullAssets() throws Exception {
        AssetListResponse assets = apiCall(new CorporationAssetsRequest(corporationKey.id));
        /*for (Asset a: assets.getAssets()) {
            System.out.println(ToStringBuilder.reflectionToString(a, ToStringStyle.MULTI_LINE_STYLE));
            for (Asset c: a.getAssets()) {
                System.out.println(ToStringBuilder.reflectionToString(c, ToStringStyle.MULTI_LINE_STYLE));
            }
        }   */
    }
}
