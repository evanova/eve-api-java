package com.tlabs.eve.map;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.tlabs.eve.EveRequest;

public final class DotlanJumpsRequest extends EveRequest<DotlanRouteResponse> {

	public static final class Builder {
		
		private int jumpDriveCalibration;
		private int jumpFuelConservation;
		private int jumpFreighter;
		
		private boolean passOnlyStationSystems;
		
		private String shipName;
		
		private final List<String> avoidSystems;
		private final String from;
		private final String to;
		
		private Builder(final String from, final String to) {			
			this.from = from;
			this.to = to;
			this.avoidSystems = new LinkedList<String>();		
			
			this.jumpDriveCalibration = 4;
			this.jumpFreighter = 4;
			this.jumpFuelConservation = 4;
			this.passOnlyStationSystems = false;
			this.shipName = "Thanatos";
		}
		
		public static Builder from(final String fromSolarSystemName, final String toSolarSystemName) {
			return new Builder(fromSolarSystemName, toSolarSystemName);
		}
		
		public Builder setShip(final String shipName) {
			this.shipName = shipName;
			return this;
		}

		public Builder setPassOnlyStationSystems(final boolean passOnly) {
			this.passOnlyStationSystems = passOnly;
			return this;
		}
		
		public Builder setJumpDriveCalibrationLevel(final int level) {
			this.jumpDriveCalibration = level;
			return this;
		}
		
		public Builder setJumpFuelConservationLevel(final int level) {
			this.jumpFuelConservation = level;
			return this;
		}
		
		public Builder setJumpFreighterLevel(final int level) {
			this.jumpFreighter = level;
			return this;
		}
		
		public Builder avoidSolarSystem(final String systemName) {
			if (!this.avoidSystems.contains(systemName)) {
				this.avoidSystems.add(systemName);
			}
			return this;
		}
		
		public DotlanJumpsRequest build() {
			return new DotlanJumpsRequest(buildPage());
		}
		
		public String buildPage() {
			String r = 
					"/jump/" + 
				    shipName + 
				    "," + 
				    jumpDriveCalibration + "" + jumpFuelConservation + "" + jumpFreighter;
			if (passOnlyStationSystems) {
				r = r + ",S";
			}
			
			if (avoidSystems.size() > 0) {
				r = r + ",";
				for (String s: avoidSystems) {
					r = r + "-" + s + ":";
				}
				r = StringUtils.removeEnd(r, ":");
			}
			r = r + "/" + from + ":" + to;		
			return r;
		}
	}
	
	public DotlanJumpsRequest(final String fromSolarSystemName, final String toSolarSystemName) {
		super(
			DotlanRouteResponse.class, 
			Builder.from(fromSolarSystemName, toSolarSystemName).buildPage());
	}

	private DotlanJumpsRequest(final String pageURL) {
		super(DotlanRouteResponse.class, pageURL); 
			
	}
}
