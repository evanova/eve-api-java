package com.tlabs.eve.api.character;

import com.tlabs.eve.api.ContractBidsResponse;

public final class CharacterContractBidsRequest extends CharacterRequest<ContractBidsResponse> {
    public static final int MASK = 67108864;

    public CharacterContractBidsRequest(final String charID) {
        super(ContractBidsResponse.class, "/char/ContractBids.xml.aspx", MASK, charID);
    }
}
