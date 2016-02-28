package com.tlabs.eve;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class EveResponse implements Serializable {

    private static final long serialVersionUID = -7496533657716416645L;

    private int errorCode = 0;
    private String errorMessage = null;

    private long dateTime;

    private boolean cached = false;
    private long cachedUntil;

    private byte[] content = null;
    private String contentHash = null;

    public EveResponse() {
        super();
        long now = System.currentTimeMillis();
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

    public boolean getCached() {
        return cached;
    }

    public void setCached(boolean cached) {
        this.cached = cached;
    }

    public final byte[] getContent() {
        return content;
    }

    public final void setContent(byte[] content) {
        this.content = content;
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(content);
            this.contentHash = new String(digest.digest());
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String getContentHash() {
        return contentHash;
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
