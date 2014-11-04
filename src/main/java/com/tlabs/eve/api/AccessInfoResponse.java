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

import com.tlabs.eve.api.character.CharacterSheet;

import java.util.List;

/**@since Eve API V3 (30 Aug 2011*/
public class AccessInfoResponse extends EveAPIResponse {

    private static final long serialVersionUID = -4592852922232440448L;

    private final AccessInfo accessInfo;

    public AccessInfoResponse() {
        super();
        this.accessInfo = new AccessInfo();
    }

    public AccessInfo getAccessInfo() {
        return accessInfo;
    }

    @Deprecated
    public final int getAccessMask() {
        return this.accessInfo.getAccessMask();
    }

    @Deprecated
    public final void setAccessMask(int accessMask) {
        this.accessInfo.setAccessMask(accessMask);
    }

    @Deprecated
    public final int getType() {
        return this.accessInfo.getType();
    }

    @Deprecated
    public final void setType(String type) {
        this.accessInfo.setType(type);
    }

    @Deprecated
    public final long getExpires() {
        return this.accessInfo.getExpires();
    }

    @Deprecated
    public final void setExpires(long expires) {
        this.accessInfo.setExpires(expires);
    }

    @Deprecated
    public final void setExpires(String expires) {
        this.accessInfo.setExpires(expires);
    }

    @Deprecated
    public final long getKeyID() {
        return this.accessInfo.getKeyID();
    }

    @Deprecated
    public final void setKeyID(long keyID) {
        this.accessInfo.setKeyID(keyID);
    }

    @Deprecated
    public void addCharacter(CharacterSheet c) {
        this.accessInfo.addCharacter(c);
    }

    @Deprecated
    public List<CharacterSheet> getCharacters() {
        return this.accessInfo.getCharacters();
    }
}
