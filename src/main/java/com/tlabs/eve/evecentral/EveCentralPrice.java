package com.tlabs.eve.evecentral;

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

public class EveCentralPrice extends Object implements Serializable {

	private static final long serialVersionUID = -869884490850959196L;
	
	public static final int MARKET = 0;
	public static final int BUY = 1;
	public static final int SELL = 2;
	
	private long typeID;
	private int type;
	
	private double volume;
	private double average;
	private double min;
	private double max;
	
	private float deviation;	
	private float median;
	private float percentile;
	
	public final long getID() {
		return typeID;
	}
	public final void setID(long typeID) {
		this.typeID = typeID;
	}
	
	public final int getType() {
		return type;
	}
	public final void setType(int type) {
		this.type = type;
	}
	public final double getVolume() {
		return volume;
	}
	public final void setVolume(double volume) {
		this.volume = volume;
	}
	public final double getAverage() {
		return average;
	}
	public final void setAverage(double average) {
		this.average = average;
	}
	public final double getMin() {
		return min;
	}
	public final void setMin(double min) {
		this.min = min;
	}
	public final double getMax() {
		return max;
	}
	public final void setMax(double max) {
		this.max = max;
	}
	public final float getDeviation() {
		return deviation;
	}
	public final void setDeviation(float deviation) {
		this.deviation = deviation;
	}
	public final float getMedian() {
		return median;
	}
	public final void setMedian(float median) {
		this.median = median;
	}
	public final float getPercentile() {
		return percentile;
	}
	public final void setPercentile(float percentile) {
		this.percentile = percentile;
	}
	
	
}
