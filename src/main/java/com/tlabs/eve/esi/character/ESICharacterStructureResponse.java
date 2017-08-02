package com.tlabs.eve.esi.character;

import com.tlabs.eve.EveTime;
import com.tlabs.eve.esi.ESIResponse;
import com.tlabs.eve.esi.model.ESICharacterStatus;
import com.tlabs.eve.esi.model.ESILocation;

public final class ESICharacterStructureResponse extends ESICharacterResponse {

    private ESILocation.Structure structure;

    public ESICharacterStructureResponse() {
        setCachedUntil(EveTime.now() + 24 * 3600L * 1000L);
    }

    public ESILocation.Structure getStructure() {
        return structure;
    }

    public void setStructure(ESILocation.Structure structure) {
        this.structure = structure;
    }
}
