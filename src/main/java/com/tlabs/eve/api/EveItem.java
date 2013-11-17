package com.tlabs.eve.api;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * %%
 * Copyright (C) 2010 - 2012 Evanova (Traquenard Labs)
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.io.Serializable;


public class EveItem extends Object implements Serializable {

	private static final long serialVersionUID = 1043774614858911095L;

	//This is not part of the API but part of the data dump.
	public static final class Attribute implements Serializable {
	    
	    private static final long serialVersionUID = 1486870784673678791L;
	    
	    public static final int MASS = 4;
	    public static final int VOLUME = 161;
	    
	    public static final int STRUCTURE_HP = 9;
	    public static final int STRUCTURE_DRONE_CAPACITY = 283;
	    public static final int STRUCTURE_DRONE_BANDWIDTH = 1271;
	    
	    public static final int STRUCTURE_INERTIA_MOD = 70;
	    public static final int STRUCTURE_EM_RES = 113;
	    public static final int STRUCTURE_EXP_RES = 111;
	    public static final int STRUCTURE_KINETIC_RES = 109;
	    public static final int STRUCTURE_THERMAL_RES = 110;
	    
	    public static final int ARMOR_HP = 265;
	    public static final int ARMOR_EM_RES = 267;
	    public static final int ARMOR_EXP_RES = 268;
	    public static final int ARMOR_KINETIC_RES = 269;
	    public static final int ARMOR_THERMAL_RES = 270;
	    
	    public static final int SHIELD_HP = 263;
	    public static final int SHIELD_RECHARGE = 479;
	    public static final int SHIELD_EM_RES = 271;
	    public static final int SHIELD_EXP_RES = 272;
	    public static final int SHIELD_KINETIC_RES = 273;
	    public static final int SHIELD_THERMAL_RES = 274;
	    
	    public static final int CAPACITOR_CAPACITY = 482;
	    public static final int CAPACITOR_RECHARGE = 55;
	    
	    public static final int TARGETING_RANGE = 76;
	    public static final int TARGETING_TARGETS = 192;
	    public static final int GRAVIMETRIC_STRENGTH = 211;
	    public static final int SCAN_RESOLUTION = 564;
	    public static final int SIGNATURE_RADIUS = 552;
	    public static final int VELOCITY_MAX = 37;
	    public static final int VELOCITY_WARP = 1281;
	    
	    public static final int PRIMARY_PILOT_ATTRIBUTE = 180;
        public static final int SECONDARY_PILOT_ATTRIBUTE = 181;
        
	    public static final int PRIMARY_SKILL = 182;
	    public static final int SECONDARY_SKILL = 183;
	    
	    public static final int TECH_LEVEL = 422;
	    public static final int META_LEVEL = 633;
	    
	    public static final int SHIP_RESTRICTION = 1380;
	    
	    private int attributeID;
	    private float attributeValue;
	    private int categoryID;

	    private String attributeName;

	    public int getID() {
	        return attributeID;
	    }

	    public void setID(int attributeID) {
	        this.attributeID = attributeID;
	    }

	    public int getCategoryID() {
	        return categoryID;
	    }

	    public void setCategoryID(int categoryID) {
	        this.categoryID = categoryID;
	    }

	    public String getName() {
	        return attributeName;
	    }

	    public void setName(String attributeName) {
	        this.attributeName = attributeName;
	    }

	    public float getValue() {
	        return attributeValue;
	    }

	    public void setValue(float attributeValue) {
	        this.attributeValue = attributeValue;
	    }
	}
	//Location.aspx.xml
	//@see https://forums.eveonline.com/default.aspx?g=posts&t=58316&find=unread
	public static class Location extends Object implements Serializable {
		
		private static final long serialVersionUID = -2001543279500079655L;

		private long itemID;
		
		private long locationID;
		private String locationName;
		
		private float x = 0;
		private float y = 0;
		public long getItemID() {
			return itemID;
		}
		public void setItemID(long itemID) {
			this.itemID = itemID;
		}
		public long getLocationID() {
			return locationID;
		}
		public void setLocationID(long locationID) {
			this.locationID = locationID;
		}
		public String getLocationName() {
			return locationName;
		}
		public void setLocationName(String locationName) {
			this.locationName = locationName;
		}
		public float getX() {
			return x;
		}
		public void setX(float x) {
			this.x = x;
		}
		public float getY() {
			return y;
		}
		public void setY(float y) {
			this.y = y;
		}		
		
		
	}
	
	private long itemID;//it is the typeID	
	private String itemName;//item name;//not in Eve XML
			
	private int raceID;//not in Eve XML
	
	private String description;////not in Eve XML
	private long categoryID;//not in Eve XML
	private String categoryName;//not in Eve XML
	private long groupID;//not in Eve XML
	private String groupName;//not in Eve XML
	private long metaGroupID;//not in Eve XML
	private String metaGroupName;//not in Eve XML
	private double mass;//not in Eve XML
	private double volume;//not in Eve XML
	private double capacity;//not in Eve XML
	private float duplicateChange;//not in Eve XML
	private long portion;//not in Eve XML
	private double basePrice;//not in Eve XML
	private int marketGroupID;//not in Eve XML
	private int published;//not in Eve XML
		
	public EveItem() {
		super();
	}
	
	public String getName() {
		return itemName;
	}

	public void setName(String name) {
		this.itemName = name;
	}

	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}
	
	public final int getRaceID() {
		return raceID;
	}

	public final void setRaceID(int raceID) {
		this.raceID = raceID;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

	public final long getCategoryID() {
		return categoryID;
	}

	public final void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}

	public final String getCategoryName() {
		return categoryName;
	}

	public final void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public final long getGroupID() {
		return groupID;
	}

	public final void setGroupID(long groupID) {
		this.groupID = groupID;
	}

	public final String getGroupName() {
		return groupName;
	}

	public final void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public final long getMetaGroupID() {
		return metaGroupID;
	}

	public final void setMetaGroupID(long metaGroupID) {
		this.metaGroupID = metaGroupID;
	}

	public final String getMetaGroupName() {
		return metaGroupName;
	}

	public final void setMetaGroupName(String metaGroupName) {
		this.metaGroupName = metaGroupName;
	}

	public final double getMass() {
		return mass;
	}

	public final void setMass(double mass) {
		this.mass = mass;
	}

	public final double getVolume() {
		return volume;
	}

	public final void setVolume(double volume) {
		this.volume = volume;
	}

	public final double getCapacity() {
		return capacity;
	}

	public final void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public final float getDuplicateChange() {
		return duplicateChange;
	}

	public final void setDuplicateChange(float duplicateChange) {
		this.duplicateChange = duplicateChange;
	}

	public final long getPortion() {
		return portion;
	}

	public final void setPortion(long portion) {
		this.portion = portion;
	}

	public final double getBasePrice() {
		return basePrice;
	}

	public final void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public final int getMarketGroupID() {
		return marketGroupID;
	}

	public final void setMarketGroupID(int marketGroupID) {
		this.marketGroupID = marketGroupID;
	}

	public final int getPublished() {
		return published;
	}

	public final void setPublished(int published) {
		this.published = published;
	}
}
