package com.tlabs.eve.api.character;



import com.tlabs.eve.api.ContractListResponse;

public class CharacterContractsRequest extends CharacterRequest<ContractListResponse> {
    public static final int MASK = 67108864;

    public CharacterContractsRequest(final String charID) {
        super(ContractListResponse.class, "/char/Contracts.xml.aspx", MASK, charID);
    }
}
