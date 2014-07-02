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

public final class ServerStatusResponse extends EveAPIResponse {

    private static final long serialVersionUID = -8218485055974441769L;

    private int playersOnline = 0;
    private boolean serverOpen = false;

    public int getOnlinePlayers() {
        return playersOnline;
    }

    public void setOnlinePlayers(int playerOnline) {
        this.playersOnline = playerOnline;
    }

    public void setOnlinePlayers(String playerOnline) {
        this.playersOnline = Integer.parseInt(playerOnline);
    }

    public boolean getServerOpen() {
        return serverOpen;
    }

    public void setServerOpen(boolean serverOpen) {
        this.serverOpen = serverOpen;
    }

    public void setServerOpen(String serverOpen) {
        setServerOpen("true".equalsIgnoreCase(serverOpen));
    }

}
