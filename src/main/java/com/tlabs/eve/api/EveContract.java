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
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

//http://wiki.eveonline.com/wikiEN/index.php?title=EVE_API_Character_Character_Contracts
public class EveContract extends Object implements Serializable {
	
	private static final long serialVersionUID = -2606077397367047795L;
	public static enum Status {
		UNKNOWN("Unknown", 0),
		IN_PROGRESS("InProgress", 1),
		OUTSTANDING("Outstanding", 2),
		COMPLETED_COMPLETED("Completed", 3),
		COMPLETED_ISSUER("CompletedByIssuer", 4),
		COMPLETED_CONTRACTOR("CompletedByContractor", 5),
		CANCELLED("Cancelled", 6),
		REJECTED("Rejected", 7),
		FAILED("Failed", 8),
		DELETED("Deleted", 9),
		REVERSED("Reversed", 10);
		
		private String name;
		private int value;
		
		private Status(String name, int value) {
			this.name = name;
			this.value = value;
		}
		
		public int getValue() {
			return this.value;
		}
		
		public String getStatusName() {
			return this.name;
		}
		public static Status statusOf(String s) {
			for (Status st: EnumSet.allOf(Status.class)) {
				if (st.name.equalsIgnoreCase(s)) {
					return st;
				}
			}
			return UNKNOWN;
		}
		

		public static Status statusOf(int a) {
			for (Status st: EnumSet.allOf(Status.class)) {
				if (st.value == a) {
					return st;
				}
			}
			return UNKNOWN;
		}
		
		
		public static int statusInt(String s) {
			return statusOf(s).value;
		}
	}
	
	public static enum Type {
		UNKNOWN("Unknown", 0),
		AUCTION("Auction", 1),
		EXCHANGE("ItemExchange", 2),
		COURIER("Courier", 3);
		
		private String name;
		private int value;
		
		private Type(String name, int value) {
			this.name = name;
			this.value = value;
		}
		public String getTypeName() {
			return this.name;
		}
		
		public int getValue() {
			return this.value;
		}
		
		public static Type typeOf(String s) {
			for (Type st: EnumSet.allOf(Type.class)) {
				if (st.name.equalsIgnoreCase(s)) {
					return st;
				}
			}
			return UNKNOWN;
		}
		

		public static Type typeOf(int a) {
			for (Type st: EnumSet.allOf(Type.class)) {
				if (st.value == a) {
					return st;
				}
			}
			return UNKNOWN;
		}
		
		
		public static int typeInt(String s) {
			return typeOf(s).value;
		}
	}
	
	private long contractID = -1;//contractID
	private long issuerID = -1;
	private String issuerName = "";//not in XML
	
	private long issuerCorpID = -1;
	private String issuerCorpName = "";//not in XML
	
	private long assigneeID = -1;
	private String assigneeName = "";//not in XML
	
	private long acceptorID = -1;
	private String acceptorName = "";//not in XML
	
	private long startStationID = -1;
	private String startStationName = "";//not in XML
	
	private long endStationID = -1;
	private String endStationName = "";//not in XML
	
	private long forCorpID = -1;
	private String forCorpName = "";//not in XML
	
	private String title;
	private String availability;

	private EveContract.Type type;
	private EveContract.Status status;

	private long dateIssued;
	private long dateExpired;
	private long dateAccepted;
	private long dateCompleted;
	
	private int numDays;
	private double price;
	private double reward;
	private double collateral;
	private double buyout;
	private double volume;
	
	private List<EveContractItem> items = new LinkedList<EveContractItem>();
	private List<EveContractBid> bids = new LinkedList<EveContractBid>();
	
	public final long getContractID() {
		return contractID;
	}
	public final void setContractID(long contractID) {
		this.contractID = contractID;
	}
	public final long getIssuerID() {
		return issuerID;
	}
	public final void setIssuerID(long issuerID) {
		this.issuerID = issuerID;
	}
	public final long getIssuerCorpID() {
		return issuerCorpID;
	}
	public final void setIssuerCorpID(long issuerCorpID) {
		this.issuerCorpID = issuerCorpID;
	}
	public final long getAssigneeID() {
		return assigneeID;
	}
	public final void setAssigneeID(long assigneeID) {
		this.assigneeID = assigneeID;
	}
	public final long getAcceptorID() {
		return acceptorID;
	}
	public final void setAcceptorID(long acceptorID) {
		this.acceptorID = acceptorID;
	}
	public final long getStartStationID() {
		return startStationID;
	}
	public final void setStartStationID(long startStationID) {
		this.startStationID = startStationID;
	}
	public final long getEndStationID() {
		return endStationID;
	}
	public final void setEndStationID(long endStationID) {
		this.endStationID = endStationID;
	}
	public final long getForCorpID() {
		return forCorpID;
	}
	public final void setForCorpID(long forCorpID) {
		this.forCorpID = forCorpID;
	}
	public final String getTitle() {
		return title;
	}
	public final void setTitle(String title) {
		this.title = title;
	}
	
	public final EveContract.Type getType() {
		return type;
	}
	
	public final void setType(String type) {
		this.type = EveContract.Type.typeOf(type);
	}
	
	public final void setType(int type) {
		this.type = EveContract.Type.typeOf(type);
	}
		
	public final EveContract.Status getStatus() {
		return status;
	}
	
	public final void setStatus(String status) {
		this.status = EveContract.Status.statusOf(status);
	}
	
	public final void setStatus(int status) {
		this.status = EveContract.Status.statusOf(status);
	}
	
	public final String getAvailability() {
		return availability;
	}
	public final void setAvailability(String availability) {
		this.availability = availability;
	}
	public final long getDateIssued() {
		return dateIssued;
	}
	public final void setDateIssued(long dateIssued) {
		this.dateIssued = dateIssued;
	}
	public final long getDateExpired() {
		return dateExpired;
	}
	public final void setDateExpired(long dateExpired) {
		this.dateExpired = dateExpired;
	}
	public final long getDateAccepted() {
		return dateAccepted;
	}
	public final void setDateAccepted(long dateAccepted) {
		this.dateAccepted = dateAccepted;
	}
	public final long getDateCompleted() {
		return dateCompleted;
	}
	public final void setDateCompleted(long dateCompleted) {
		this.dateCompleted = dateCompleted;
	}
	public final int getNumDays() {
		return numDays;
	}
	public final void setNumDays(int numDays) {
		this.numDays = numDays;
	}
	public final double getPrice() {
		return price;
	}
	public final void setPrice(double price) {
		this.price = price;
	}
	public final double getReward() {
		return reward;
	}
	public final void setReward(double reward) {
		this.reward = reward;
	}
	public final double getCollateral() {
		return collateral;
	}
	public final void setCollateral(double collateral) {
		this.collateral = collateral;
	}
	public final double getBuyout() {
		return buyout;
	}
	public final void setBuyout(double buyout) {
		this.buyout = buyout;
	}
	public final double getVolume() {
		return volume;
	}
	public final void setVolume(double volume) {
		this.volume = volume;
	}
	public final String getIssuerName() {
		return issuerName;
	}
	public final void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}
	public final String getAssigneeName() {
		return assigneeName;
	}
	public final void setAssigneeName(String assigneeName) {
		this.assigneeName = assigneeName;
	}
	public final String getAcceptorName() {
		return acceptorName;
	}
	public final void setAcceptorName(String acceptorName) {
		this.acceptorName = acceptorName;
	}
	public final String getStartStationName() {
		return startStationName;
	}
	public final void setStartStationName(String startStationName) {
		this.startStationName = startStationName;
	}
	public final String getEndStationName() {
		return endStationName;
	}
	public final void setEndStationName(String endStationName) {
		this.endStationName = endStationName;
	}
	public final String getForCorpName() {
		return forCorpName;
	}
	public final void setForCorpName(String forCorpName) {
		this.forCorpName = forCorpName;
	}
	public final String getIssuerCorpName() {
		return issuerCorpName;
	}
	public final void setIssuerCorpName(String issuerCorpName) {
		this.issuerCorpName = issuerCorpName;
	}
	public List<EveContractItem> getItems() {
		return items;
	}
	public void setItems(List<EveContractItem> items) {
		this.items = items;
	}
    public List<EveContractBid> getBids() {
        return bids;
    }
    public void setBids(List<EveContractBid> bids) {
        this.bids = bids;
    }
		
}
