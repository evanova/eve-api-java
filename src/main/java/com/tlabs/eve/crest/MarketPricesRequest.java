package com.tlabs.eve.crest;

public final class MarketPricesRequest extends CRESTRequest<MarketPricesResponse> {

	private final long regionID;
	private final String orderType;
	private final long typeID;

	public MarketPricesRequest(final long regionID, final String orderType, final long typeID) {
		super(MarketPricesResponse.class, "/market/" + regionID + "/orders/" + orderType
				+ "/?type=http://public-crest.eveonline.com/types/" + typeID + "/");
		this.regionID = regionID;
		this.orderType = orderType;
		this.typeID = typeID;
	}

	public long getRegionID() {
		return regionID;
	}

	public String getOrderType() {
		return orderType;
	}

	public long getTypeID() {
		return typeID;
	}

};