package com.tlabs.eve;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * 
 * ------------------------------------------------------------------------
 * %%
 * Copyright (C) 2011 - 2013 Traquenard Labs
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


public abstract class EveResponse extends Object {
    
    private int errorCode = 0;  
    private String errorMessage = null;
    
    private long dateTime;
    private long cachedUntil;
    
    private byte[] content = null;
    

    public EveResponse() {
        super();
        long now = System.currentTimeMillis();;
        this.dateTime = now;
        this.cachedUntil = now;
    }
    
    /** Eve Time*/
    public final long getDateTime() {
        return dateTime;
    }

    /** Eve Time*/
    public final void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    /** Eve Time*/
    public final long getCachedUntil() {
        return cachedUntil;
    }
    
    /** Eve Time*/
    public final void setCachedUntil(long cachedUntil) {
        this.cachedUntil = cachedUntil;
    }
    
    public final byte[] getContent() {
        return content;
    }

    public final void setContent(byte[] content) {
        this.content = content;
    }       
    
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorString) {
        this.errorMessage = errorString;
    }

    public final void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public final int getErrorCode() {
        return errorCode;
    }
    
    public final boolean hasError() {
        return errorCode > 0;
    }
    
}
