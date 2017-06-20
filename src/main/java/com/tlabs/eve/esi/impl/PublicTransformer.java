package com.tlabs.eve.esi.impl;

import com.tlabs.eve.esi.model.ESILocation;
import com.tlabs.eve.esi.model.ESIMarketItem;
import com.tlabs.eve.esi.model.ESIMarketOrder;
import com.tlabs.eve.esi.model.ESIName;
import com.tlabs.eve.esi.model.ESIServerStatus;
import org.devfleet.esi.model.GetMarketsPrices200Ok;
import org.devfleet.esi.model.GetMarketsRegionIdOrders200Ok;
import org.devfleet.esi.model.GetStatusOk;
import org.devfleet.esi.model.GetUniverseConstellationsConstellationIdOk;
import org.devfleet.esi.model.GetUniverseRegionsRegionIdOk;
import org.devfleet.esi.model.GetUniverseStructuresStructureIdOk;
import org.devfleet.esi.model.GetUniverseSystemsSystemIdOk;
import org.devfleet.esi.model.PostUniverseNames200Ok;

final class PublicTransformer {
    private PublicTransformer() {}

    public static ESIServerStatus transform(GetStatusOk object) {
        final ESIServerStatus status = new ESIServerStatus();
        status.setPlayers(object.getPlayers());
        status.setStartTime(object.getStartTime().getMillis());
        status.setVersion(object.getServerVersion());
        return status;
    }

    public static ESIName transform(PostUniverseNames200Ok object) {
        final ESIName name = new ESIName();
        name.setGroup(object.getCategory().toString());
        name.setId(object.getId());
        name.setName(object.getName());
        return name;
    }

    public static ESIMarketItem transform(GetMarketsPrices200Ok object) {
        final ESIMarketItem item = new ESIMarketItem();
        item.setAdjustedPrice((null == object.getAdjustedPrice()) ? 0d : object.getAdjustedPrice());
        item.setAveragePrice((null == object.getAveragePrice()) ? 0d : object.getAveragePrice());
        item.setTypeID(object.getTypeId());
        return item;
    }

    public static ESIMarketOrder transform(GetMarketsRegionIdOrders200Ok object) {
        final ESIMarketOrder item = new ESIMarketOrder();
        item.setBuyOrder(object.getIsBuyOrder());
        item.setDuration(object.getDuration());
        item.setLocationID(object.getLocationId());
        item.setIssued(object.getIssued().toDate());
        item.setMinVolume(object.getMinVolume());
        item.setRemainingVolume(object.getVolumeRemain());
        item.setTotalVolume(object.getVolumeTotal());
        item.setOrderID(object.getOrderId());
        item.setPrice(object.getPrice());
        item.setTypeID(object.getTypeId());
        return item;
    }

    public static ESILocation.Region transform(GetUniverseRegionsRegionIdOk object) {
        final ESILocation.Region region = new ESILocation.Region();
        region.setDescription(object.getDescription());
        region.setName(object.getName());
        region.setId(object.getRegionId());

        for (Integer a: object.getConstellations()) {
            region.addConstellation(a.longValue());
        }

        return region;
    }

    public static ESILocation.Constellation transform(GetUniverseConstellationsConstellationIdOk object) {
        final ESILocation.Constellation constellation = new ESILocation.Constellation();

        final ESILocation.Region region =
                new ESILocation.Region().setId(object.getRegionId());
        constellation.setRegion(region);

        for (Integer a: object.getSystems()) {
            constellation.addSolarSystem(a);
        }

        constellation.setDescription(object.getName());
        constellation.setName(object.getName());
        constellation.setId(object.getRegionId());
        constellation.setX(object.getPosition().getX());
        constellation.setY(object.getPosition().getY());
        constellation.setZ(object.getPosition().getZ());
        return constellation;
    }

    public static ESILocation.SolarSystem transform(GetUniverseSystemsSystemIdOk object) {
        final ESILocation.SolarSystem system = new ESILocation.SolarSystem();

        final ESILocation.Constellation constellation =
                new ESILocation.Constellation().setId(object.getConstellationId());
        system.setConstellation(constellation);

        system.setDescription(object.getName());
        system.setId(object.getSystemId());
        system.setName(object.getName());
        system.setX(object.getPosition().getX());
        system.setY(object.getPosition().getY());
        system.setZ(object.getPosition().getZ());
        system.setSecurityStatus(object.getSecurityStatus());
        system.setSecurityClass(object.getSecurityClass());

        return system;
    }

    public static ESILocation.Structure transform(final long id, GetUniverseStructuresStructureIdOk object) {
        final ESILocation.Structure structure = new ESILocation.Structure();
        structure.setId(id);
        structure.setTypeID(object.getTypeId());
        structure.setName(object.getName());

        structure.setSolarSystemId(object.getSolarSystemId());
        if (null != object.getPosition()) {
            structure.setX(object.getPosition().getX());
            structure.setY(object.getPosition().getY());
            structure.setZ(object.getPosition().getZ());
        }
        return structure;
    }
}
