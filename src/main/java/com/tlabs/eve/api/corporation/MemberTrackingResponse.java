package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.EveAPIResponse;

import java.util.ArrayList;
import java.util.List;

public final class MemberTrackingResponse extends EveAPIResponse {

    private static final long serialVersionUID = 5337975035635672595L;

    private List<CorporationMember> members;

    public MemberTrackingResponse() {
        super();
        members = new ArrayList<>();
    }

    public void addCorpMember(CorporationMember member) {
        members.add(member);
    }

    public List<CorporationMember> getCorpMembers() {
        return this.members;
    }
}
