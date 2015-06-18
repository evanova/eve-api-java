package com.tlabs.eve.api.corporation;

import com.tlabs.eve.api.ContractBidsResponse;

public final class CorporationContractBidsRequest extends CorporationRequest<ContractBidsResponse> {
    public static final int MASK = 8388608;

    public CorporationContractBidsRequest(final String corpID) {
        super(ContractBidsResponse.class, "/corp/ContractBids.xml.aspx", MASK, corpID);
    }
}
