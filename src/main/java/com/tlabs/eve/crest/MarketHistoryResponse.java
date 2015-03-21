package com.tlabs.eve.crest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;
import java.util.List;

public class MarketHistoryResponse extends CRESTResponse {

    private static final long serialVersionUID = 1020799045456674278L;

    private final List<MarketTransaction> history = new LinkedList<>();

    public final List<MarketTransaction> getHistory() {
        return history;
    }

    @JsonProperty("items")
    public void setHistory(final List<MarketTransaction> history) {
        this.history.addAll(history);
    }

    public void setHistory(final MarketTransaction history) {
        this.history.add(history);
    }
}
