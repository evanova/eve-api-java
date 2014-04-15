package com.tlabs.eve.api.character;

import java.io.Serializable;

public class PlanetaryRoute extends Object implements Serializable {

	private static final long serialVersionUID = -3629780760607505499L;

	/*<rowset name="routes" key="routeID" 
	 * columns="
	 * routeID,
	 * sourcePinID,
	 * destinationPinID,
	 * contentTypeID,
	 * contentTypeName,
	 * quantity,
	 * waypoint1,
	 * waypoint2,
	 * waypoint3,
	 * waypoint4,
	 * waypoint5">
	 * 
	 */
	
	private long routeID;
	private long sourcePinID;
	private long destinationPinID;
	
	private long contentTypeID;
	private String contentTypeName;
	
	private float quantity;

	public long getRouteID() {
		return routeID;
	}

	public void setRouteID(long routeID) {
		this.routeID = routeID;
	}

	public long getSourcePinID() {
		return sourcePinID;
	}

	public void setSourcePinID(long sourcePinID) {
		this.sourcePinID = sourcePinID;
	}

	public long getDestinationPinID() {
		return destinationPinID;
	}

	public void setDestinationPinID(long destinationPinID) {
		this.destinationPinID = destinationPinID;
	}

	public long getContentTypeID() {
		return contentTypeID;
	}

	public void setContentTypeID(long contentTypeID) {
		this.contentTypeID = contentTypeID;
	}

	public String getContentTypeName() {
		return contentTypeName;
	}

	public void setContentTypeName(String contentTypeName) {
		this.contentTypeName = contentTypeName;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}		
}
