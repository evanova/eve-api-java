package com.tlabs.eve.ccp;



public final class CorporationLogoRequest extends ImageRequest<CorporationLogoResponse> {
    public enum Size {
        S64("64"), S256("256");

        private String value;

        private Size(String value) {
            this.value = value;
        }

        public String getSize() {
            return this.value;
        }
    }

    private static final String URL = "/Corporation/%1$s_%2$s.png";

    private Size size;
    private String corporationID;

    public CorporationLogoRequest(String corpID) {
        this(corpID, Size.S256);
    }

    public CorporationLogoRequest(String corpID, Size size) {
        super(CorporationLogoResponse.class, String.format(URL, corpID, size.getSize()));
        this.corporationID = corpID;
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public final String getCorporationID() {
        return corporationID;
    }

}
