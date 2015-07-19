package com.tlabs.eve.api.corporation;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Outpost implements Serializable {

    private static final long serialVersionUID = 4480776659853459976L;

    private long stationID;
    private String stationName;

    private long ownerID;
    private String ownerName;//Not in XML

    private long standingOwnerID;
    private String standingOwnerName;//Not in XML

    private long solarSystemID;
    private String solarSystemName;//Not in XML

    private double dockingCostPerShipVolume;
    private double officeRentalCost;

    private long stationTypeID;
    private String stationTypeName;//Not in XML

    private float reprocessingEfficiency;
    private float reprocessingStationTake;

    private double x;
    private double y;
    private double z;


}
