package com.tlabs.eve.api;

import com.tlabs.eve.EveResponse;

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

public abstract class EveAPIResponse extends EveResponse {

    private static final long serialVersionUID = -8149968321234613949L;

    //Authentication failures
    private static final int INVALID_KEYS_MIN = 200;
    private static final int INVALID_KEYS_MAX = 299;

    //private static final int INVALID_KEYS[] = {108, 109,202,203,204,205,222};
    /*
    	      <row errorCode="200" errorText="Current security level not high enough." />
    	      <row errorCode="201" errorText="Character does not belong to account." />
    	      <row errorCode="202" errorText="API key authentication failure." />
    	      <row errorCode="203" errorText="Authentication failure." />
    	      <row errorCode="204" errorText="Authentication failure." />
    	      <row errorCode="205" errorText="Authentication failure (final pass)." />*/

    public final boolean hasAuthenticationError() {
        return (getErrorCode() >= INVALID_KEYS_MIN) && (getErrorCode() <= INVALID_KEYS_MAX);
    }

}
