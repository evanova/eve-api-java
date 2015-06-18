package com.tlabs.eve.central;



import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EveCentralStatsResponse extends EveCentralResponse {

    private Map<Long, List<EveCentralPrice>> marketPrices = new HashMap<>();
    private Map<Long, List<EveCentralPrice>> buyOrders = new HashMap<>();
    private Map<Long, List<EveCentralPrice>> sellOrders = new HashMap<>();

    public final Map<Long, List<EveCentralPrice>> getMarketPrices() {
        return marketPrices;
    }

    public final Map<Long, List<EveCentralPrice>> getBuyPrices() {
        return buyOrders;
    }

    public final Map<Long, List<EveCentralPrice>> getSellPrices() {
        return sellOrders;
    }

    public void add(EveCentralPrice p) {
        switch (p.getType()) {
        case EveCentralPrice.MARKET:
            add(this.marketPrices, p);
            break;
        case EveCentralPrice.BUY:
            add(this.buyOrders, p);
            break;
        case EveCentralPrice.SELL:
            add(this.sellOrders, p);
            break;
        default:
            throw new IllegalArgumentException("Invalid EveCentralPrice.type " + p.getType());
        }
    }

    private static void add(Map<Long, List<EveCentralPrice>> prices, EveCentralPrice p) {
        List<EveCentralPrice> l = prices.get(p.getID());
        if (null == l) {
            l = new LinkedList<>();
            prices.put(p.getID(), l);
        }
        l.add(p);
    }
}
