package com.tlabs.eve.api;

import java.util.ArrayList;
import java.util.List;

/**@since Eve API V3*/
public class ContractItemsResponse extends EveAPIResponse {

    private static final long serialVersionUID = -2436382675293683168L;

    private List<ContractItem> items = new ArrayList<>();

    public ContractItemsResponse() {
        super();
    }

    public void addItem(ContractItem c) {
        this.items.add(c);
    }

    public final List<ContractItem> getItems() {
        return this.items;
    }
}
