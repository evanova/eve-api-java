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


public class Item extends Object implements Serializable {

	private static final long serialVersionUID = 1043774614858911095L;

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
		
	public Item() {
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
