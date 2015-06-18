package com.tlabs.eve.api;



public final class JournalReferenceTypeRequest extends EveAPIRequest<JournalReferenceTypeResponse> {

    public JournalReferenceTypeRequest() {
        super(JournalReferenceTypeResponse.class, "/eve/RefTypes.xml.aspx", 0);
    }

}
