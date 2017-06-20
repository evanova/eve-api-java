package com.tlabs.eve.esi.character;

public final class ESICharacterContactLabelsRequest extends ESICharacterRequest<ESICharacterContactLabelsResponse> {
    public static final String SCOPE = "esi-characters.read_contacts.v1";

    public ESICharacterContactLabelsRequest(final long charID) {
        super(
                ESICharacterContactLabelsResponse.class,
                charID,
                SCOPE);
    }
}
