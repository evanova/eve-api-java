package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.ContractListResponse;

public final class CorporationContractsRequest extends CorporationRequest<ContractListResponse> {
    public static final long MASK = 8388608;

    public CorporationContractsRequest(final long corpID) {
        super(ContractListResponse.class, "/corp/Contracts.xml.aspx", MASK, corpID);
    }

}
