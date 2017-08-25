package com.tlabs.eve.esi.character;

public class ESICharacterStructureRequest extends ESICharacterRequest<ESICharacterStructureResponse> {

    private final long structureId;

    public ESICharacterStructureRequest(final long ownerId, final long structureId) {
        super(ESICharacterStructureResponse.class, ownerId);
        this.structureId = structureId;
    }

    public long getStructureId() {
        return structureId;
    }
}
