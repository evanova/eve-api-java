package com.tlabs.eve.api.corporation;



import com.tlabs.eve.api.MarketOrderResponse;

public final class CorporationMarketOrderRequest extends CorporationRequest<MarketOrderResponse> {
    public static final long MASK = 4096;

    public CorporationMarketOrderRequest(String corpID) {
        super(MarketOrderResponse.class, "/corp/MarketOrders.xml.aspx", MASK, corpID);
    }

}
