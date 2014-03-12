package com.tlabs.eve.api;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * 
 * ------------------------------------------------------------------------
 * %%
 * Copyright (C) 2011 - 2014 Traquenard Labs
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

//This is not part of the API but part of the data dump.
public final class EveItemEffect implements Serializable {
    
    public static final int USES_LOW_SLOT = 11;
    public static final int USES_MEDIUM_SLOT = 13;
    public static final int USES_HIGH_SLOT = 12;
    public static final int USES_RIG_SLOT = 2663;
    
    private static final long serialVersionUID = -6457985690836261476L;
    
    private int effectID;
    
    public int getID() {
        return effectID;
    }

    public void setID(int effectID) {
        this.effectID = effectID;
    }

}