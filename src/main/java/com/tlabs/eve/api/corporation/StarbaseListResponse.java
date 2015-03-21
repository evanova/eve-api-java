package com.tlabs.eve.api.corporation;

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

import com.tlabs.eve.api.EveAPIResponse;

import java.util.ArrayList;
import java.util.List;

public final class StarbaseListResponse extends EveAPIResponse {

    private static final long serialVersionUID = -6881766910572039754L;

    private List<Starbase> starbases;

    public StarbaseListResponse() {
        super();
        starbases = new ArrayList<>();
    }

    public void addStarbase(Starbase starbase) {
        starbases.add(starbase);
    }

    public List<Starbase> getStarbases() {
        return this.starbases;
    }
}
