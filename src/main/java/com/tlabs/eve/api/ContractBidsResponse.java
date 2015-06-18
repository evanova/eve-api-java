package com.tlabs.eve.api;



import java.util.LinkedList;
import java.util.List;

/**@since Eve API V3*/
public class ContractBidsResponse extends EveAPIResponse {

    private static final long serialVersionUID = -3799636006647458125L;

    private List<ContractBid> bids = new LinkedList<>();

    public ContractBidsResponse() {
        super();
    }

    public void addBid(ContractBid c) {
        this.bids.add(c);
    }

    public final List<ContractBid> getBids() {
        return this.bids;
    }
}
