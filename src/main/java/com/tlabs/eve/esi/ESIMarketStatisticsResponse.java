package com.tlabs.eve.esi;

import com.tlabs.eve.EveTime;
import com.tlabs.eve.esi.model.ESIMarketHistory;
import com.tlabs.eve.esi.model.ESIMarketOrder;
import com.tlabs.eve.esi.model.ESIServerStatus;

import java.util.List;

public class ESIMarketStatisticsResponse extends ESIResponse {

    private List<ESIMarketHistory> history;
    private List<ESIMarketOrder> orders;

    public ESIMarketStatisticsResponse() {
        setCachedUntil(EveTime.now() + 30 * 1000);
    }

    public List<ESIMarketHistory> getHistory() {
        return history;
    }

    public ESIMarketStatisticsResponse setHistory(List<ESIMarketHistory> history) {
        this.history = history;
        return this;
    }

    public List<ESIMarketOrder> getOrders() {
        return orders;
    }

    public ESIMarketStatisticsResponse setOrders(List<ESIMarketOrder> orders) {
        this.orders = orders;
        return this;
    }
}
