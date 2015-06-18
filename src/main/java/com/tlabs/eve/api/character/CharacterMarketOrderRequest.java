package com.tlabs.eve.api.character;



import com.tlabs.eve.api.MarketOrderResponse;

public final class CharacterMarketOrderRequest extends CharacterRequest<MarketOrderResponse> {
    public static final int MASK = 4096;

    public CharacterMarketOrderRequest(String characterID) {
        super(MarketOrderResponse.class, "/char/MarketOrders.xml.aspx", MASK, characterID);
    }

}
