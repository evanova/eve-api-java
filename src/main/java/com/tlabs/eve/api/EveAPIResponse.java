package com.tlabs.eve.api;

import com.tlabs.eve.EveResponse;



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
