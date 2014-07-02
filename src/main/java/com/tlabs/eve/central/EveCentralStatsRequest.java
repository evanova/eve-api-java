package com.tlabs.eve.central;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * %%
 * Copyright (C) 2010 - 2012 Evanova (Traquenard Labs)
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

//http://api.eve-central.com/api/marketstat?typeid=34&typeid=35&regionlimit=10000002
public class EveCentralStatsRequest extends EveCentralRequest<EveCentralStatsResponse> {

    private final long regionID;

    public EveCentralStatsRequest(final long[] types) {
        this(types, -1);
    }

    public EveCentralStatsRequest(final long[] types, long region) {
        super(EveCentralStatsResponse.class, "/api/marketstat");
        this.regionID = region;

        if (region > 0) {
            putParam("regionlimit", Long.toString(region));
        }

        String p = "";
        for (long id : types) {
            if (p.length() == 0) {
                p = "" + id;
            }
            else {
                p = p + "&typeid=" + id;
            }
        }
        putParam("typeid", p);
    }

    public final long getRegionID() {
        return regionID;
    }
}
