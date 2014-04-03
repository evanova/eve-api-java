package com.tlabs.eve.api.corporation;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * 
 * ------------------------------------------------------------------------
 * %%
 * Copyright (C) 2011 - 2012 Traquenard Labs
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import org.junit.Test;

import com.tlabs.eve.api.AssetListResponse;

public final class CorporationAssetTest extends CorporationApiTest {

    @Test(timeout=10000)
    public void testFullAssets() throws Exception {
        AssetListResponse assets = 
            apiCall(new CorporationAssetsRequest(corporationKey.id));
        /*for (Asset a: assets.getAssets()) {
            System.out.println(ToStringBuilder.reflectionToString(a, ToStringStyle.MULTI_LINE_STYLE));
            for (Asset c: a.getAssets()) {
                System.out.println(ToStringBuilder.reflectionToString(c, ToStringStyle.MULTI_LINE_STYLE));
            }
        }   */
    }   
}
