package com.tlabs.eve.api;


import java.util.ArrayList;
import java.util.List;

/**@since Eve API V3*/
public class ContractListResponse extends EveAPIResponse {

    private static final long serialVersionUID = -4879047977717920997L;

    private List<Contract> eveContracts = new ArrayList<>();

    public ContractListResponse() {
        super();
    }

    public void addContract(Contract c) {
        this.eveContracts.add(c);
    }

    public final List<Contract> getContracts() {
        return this.eveContracts;
    }
}
