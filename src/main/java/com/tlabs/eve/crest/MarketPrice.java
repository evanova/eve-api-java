package com.tlabs.eve.crest;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketPrice {
	@JsonProperty("volume")
	private long volume;
	
	@JsonProperty("buy")
	private boolean buy;
	
	@JsonProperty("issued")
	private Date issued;
	
	@JsonProperty("price")
	private double price;
	
	@JsonProperty("volumeEntered")
	private long volumeEntered;
	
	@JsonProperty("minVolume")
	private long minVolume;
	
	@JsonProperty("range")
	private String range;
	
	@JsonProperty("href")
	private String href;
	
	@JsonProperty("duration")
	private long duration;
	
	@JsonProperty("id")
	private long id;

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public boolean isBuy() {
		return buy;
	}

	public void setBuy(boolean buy) {
		this.buy = buy;
	}

	public Date getIssued() {
		return issued;
	}

	public void setIssued(Date issued) {
		this.issued = issued;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getVolumeEntered() {
		return volumeEntered;
	}

	public void setVolumeEntered(long volumeEntered) {
		this.volumeEntered = volumeEntered;
	}

	public long getMinVolume() {
		return minVolume;
	}

	public void setMinVolume(long minVolume) {
		this.minVolume = minVolume;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
