package com.tlabs.eve.api;

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


import java.io.Serializable;

public class Standing extends Object implements Serializable {

    private static final long serialVersionUID = -9069702849389351438L;

    private String fromName;
    private long fromID;
    
    private float standing;

    public final String getFromName() {
        return fromName;
    }

    public final void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public final long getFromID() {
        return fromID;
    }

    public final void setFromID(long fromID) {
        this.fromID = fromID;
    }

    public final float getStanding() {
        return standing;
    }

    public final void setStanding(float standing) {
        this.standing = standing;
    }
    
    
}
