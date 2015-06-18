package com.tlabs.eve.ccp;

import com.tlabs.eve.EveResponse;



public abstract class ImageResponse extends EveResponse {

    public ImageResponse() {
        super();
        setCachedUntil(System.currentTimeMillis() + 24l * 3600l * 1000l);
    }

    public final byte[] getImageData() {
        return super.getContent();
    }

    public final void setImageData(byte[] imageData) {
        super.setContent(imageData);
    }

}
