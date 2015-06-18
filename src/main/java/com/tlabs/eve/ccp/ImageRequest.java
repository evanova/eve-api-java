package com.tlabs.eve.ccp;

import com.tlabs.eve.EveRequest;



public abstract class ImageRequest<T extends ImageResponse> extends EveRequest<T> {

    public ImageRequest(Class<T> responseClass, String url) {
        super(responseClass, url);
    }

}
