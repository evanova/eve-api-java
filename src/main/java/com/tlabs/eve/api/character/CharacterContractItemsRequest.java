package com.tlabs.eve.api.character;

import com.tlabs.eve.api.ContractItemsResponse;

public final class CharacterContractItemsRequest extends CharacterRequest<ContractItemsResponse> {
    public static final int MASK = 67108864;

    private final long contractID;

    public CharacterContractItemsRequest(final String charID, final long contractID) {
        super(ContractItemsResponse.class, "/char/ContractItems.xml.aspx", MASK, charID);
        this.contractID = contractID;
        putParam("contractID", new long[] { contractID });
    }

    public long getContractID() {
        return contractID;
    }

}
