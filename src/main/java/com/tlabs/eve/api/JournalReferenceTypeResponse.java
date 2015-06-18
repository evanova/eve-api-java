package com.tlabs.eve.api;



import java.util.HashMap;
import java.util.Map;

public class JournalReferenceTypeResponse extends EveAPIResponse {

    private static final long serialVersionUID = -1423045891788417599L;

    private Map<Long, String> referenceTypes;//names by id

    public JournalReferenceTypeResponse() {
        super();
        this.referenceTypes = new HashMap<>();
    }

    public Map<Long, String> getReferences() {
        return this.referenceTypes;
    }

    public void addReference(Long id, String name) {
        this.referenceTypes.put(id, name);
    }

}
