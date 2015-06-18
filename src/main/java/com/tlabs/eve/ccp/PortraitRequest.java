package com.tlabs.eve.ccp;



public final class PortraitRequest extends ImageRequest<PortraitResponse> {
    public enum Size {
        S64("64"), S128("128"), S256("256"), S512("512");

        private String value;

        private Size(String value) {
            this.value = value;
        }

        public String getSize() {
            return this.value;
        }
    }

    private static final String URL = "/Character/%1$s_%2$s.jpg";

    private Size size;
    private String characterID;

    public PortraitRequest(String characterID) {
        this(characterID, Size.S512);
    }

    public PortraitRequest(String characterID, Size size) {
        super(PortraitResponse.class, String.format(URL, characterID, size.getSize()));
        this.size = size;
        this.characterID = characterID;
    }

    public Size getSize() {
        return size;
    }

    public final String getCharacterID() {
        return characterID;
    }

}
