package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.ContractItemsResponse;

public final class CorporationContractItemsRequest extends CorporationRequest<ContractItemsResponse> {
    public static final long MASK = 8388608;

    private final long contractID;

    public CorporationContractItemsRequest(final long corpID, final long contractID) {
        super(ContractItemsResponse.class, "/corp/ContractItems.xml.aspx", MASK, corpID);
        this.contractID = contractID;
        putParam("contractID", new long[] { contractID });
    }

    public long getContractID() {
        return contractID;
    }

}
