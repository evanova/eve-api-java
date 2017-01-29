package com.tlabs.eve.crest;


import com.tlabs.eve.crest.model.CrestCharacter;
import com.tlabs.eve.crest.model.CrestCharacterStatus;
import com.tlabs.eve.crest.model.CrestContact;
import com.tlabs.eve.crest.model.CrestFitting;
import com.tlabs.eve.crest.model.CrestItem;
import com.tlabs.eve.crest.model.CrestLocation;
import com.tlabs.eve.crest.model.CrestMarketBulkOrder;
import com.tlabs.eve.crest.model.CrestMarketHistory;
import com.tlabs.eve.crest.model.CrestMarketOrder;
import com.tlabs.eve.crest.model.CrestMarketPrice;
import com.tlabs.eve.crest.model.CrestServerStatus;
import com.tlabs.eve.crest.model.CrestSolarSystem;
import com.tlabs.eve.crest.model.CrestType;
import com.tlabs.eve.crest.model.CrestWaypoint;

import java.util.List;

public interface CrestService {

    CrestServerStatus getServerStatus();

    CrestCharacterStatus getCharacterStatus();

    CrestCharacter getCharacter();

    CrestLocation getLocation();

    CrestSolarSystem getSolarSystem(long solarSystemId);

    CrestType getInventoryType(int typeId);

    List<CrestSolarSystem> getLocations();

    List<CrestItem> getRegions();

    List<CrestContact> getContacts();

    CrestContact getContact(final long contactID);

    boolean addContact(final CrestContact contact);

    boolean deleteContact(final long contactID);

    List<CrestFitting> getFittings();

    boolean addFitting(final CrestFitting fitting);

    boolean deleteFitting(final long fittingID);

    boolean addWaypoints(final List<CrestWaypoint> waypoints);

    boolean setWaypoints(final List<CrestWaypoint> waypoints);

    List<CrestMarketHistory> getMarketHistory(final long regionId, final long itemId);

    List<CrestMarketOrder> getMarketOrders(final long regionId, final String orderType, final long itemId);

    List<CrestMarketBulkOrder> getAllMarketOrders(final long regionId);
    
    List<CrestMarketPrice> getAllMarketPrices();
}
