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

public class IndustryJob extends Object implements Serializable {
	
	//select * from ramactivities
	public static enum Type {
		NONE(0, "None"),
		MANUFACTURING(1, "Manufacturing"),
		RESEARCH_TECH(2, "Researching Technology"),
		RESEARCH_TIME(3, "Researching Time Productivity"),
		RESEARCH_MATERIAL(4, "Researching Material Productivity"),
		COPY(5, "Copying"),
		DUPLICATE(6, "Duplicating"),
		REVERSE(7, "Reverse Engineering"),
		INVENTION(8, "Invention");
		
		private final String text;
		private final int value;
		
		private Type(final int value, final String text) {
			this.value = value;
			this.text = text;
		}
		
		public String getText() {
			return this.text;
		}
		
		public int getValue() {
			return this.value;
		}
		
		public static Type typeOf(int value) {
			for (Type t: EnumSet.allOf(Type.class)) {
				if (t.value == value) {
					return t;
				}
			}
			return NONE;
		}
	}
	
	private static final long serialVersionUID = 8712948500771471576L;

	private long jobID;
	private long assemblyLineID;
	private long containerID;
	
	private long installedItemID;
	private String installedItemName;//Not in XML
	
	private long installedItemLocationID;
	private String installedLocationName;//Not in XML
	
	private long installedItemQuantity;
	private int installedItemProductivityLevel;
	private int installedItemMaterialLevel;
	private int installedItemLicensedProductionRunsRemaining;
	
	private long outputLocationID;
	private String outputLocationName;//Not in XML
	
	private long installerID;
	private String installerName;//Not in XML
	
	private int runs;
	private int licensedProductionRuns;
	
	private long installedInSolarSystemID;
	private String installedInSolarSystemName;//Not in XML
	
	private long containerTypeID;
	private String containerTypeName;//Not in XML
	
	private long containerLocationID;
	private String containerLocationName;//Not in XML
	
	private int materialMultiplier;
	private int charMaterialMultiplier;
	private int timeMultiplier;
	private int charTimeMultiplier;
	
	private long installedItemTypeID;
	private String installedItemTypeName;//Not in XML
	
	private long outputTypeID;
	private String outputTypeName;//Not in XML
	
	private boolean installedItemCopy;
	private boolean completed;
	//private boolean completedSuccessfully;//always 0
	
	private int installedItemFlag;
	private int outputFlag;
	
	private int activityID;
	private IndustryJob.Type activityType; 
	
	private int completedStatus;
	
	private long installTime;
	private long beginProductionTime;
	private long endProductionTime;
	private long pauseProductionTime;
	
	public final long getJobID() {
		return jobID;
	}
	public final void setJobID(long jobID) {
		this.jobID = jobID;
	}
	public final long getAssemblyLineID() {
		return assemblyLineID;
	}
	public final void setAssemblyLineID(long assemblyLineID) {
		this.assemblyLineID = assemblyLineID;
	}
	public final long getContainerID() {
		return containerID;
	}
	public final void setContainerID(long containerID) {
		this.containerID = containerID;
	}
	public final long getInstalledItemID() {
		return installedItemID;
	}
	public final void setInstalledItemID(long installedItemID) {
		this.installedItemID = installedItemID;
	}
	public final long getInstalledItemLocationID() {
		return installedItemLocationID;
	}
	public final void setInstalledItemLocationID(long installedItemLocationID) {
		this.installedItemLocationID = installedItemLocationID;
	}
	public final long getInstalledItemQuantity() {
		return installedItemQuantity;
	}
	public final void setInstalledItemQuantity(long installedItemQuantity) {
		this.installedItemQuantity = installedItemQuantity;
	}
	public final int getInstalledItemProductivityLevel() {
		return installedItemProductivityLevel;
	}
	public final void setInstalledItemProductivityLevel(
			int installedItemProductivityLevel) {
		this.installedItemProductivityLevel = installedItemProductivityLevel;
	}
	public final int getInstalledItemMaterialLevel() {
		return installedItemMaterialLevel;
	}
	public final void setInstalledItemMaterialLevel(int installedItemMaterialLevel) {
		this.installedItemMaterialLevel = installedItemMaterialLevel;
	}
	public final int getInstalledItemLicensedProductionRunsRemaining() {
		return installedItemLicensedProductionRunsRemaining;
	}
	public final void setInstalledItemLicensedProductionRunsRemaining(
			int installedItemLicensedProductionRunsRemaining) {
		this.installedItemLicensedProductionRunsRemaining = installedItemLicensedProductionRunsRemaining;
	}
	public final long getOutputLocationID() {
		return outputLocationID;
	}
	public final void setOutputLocationID(long outputLocationID) {
		this.outputLocationID = outputLocationID;
	}
	public final long getInstallerID() {
		return installerID;
	}
	public final void setInstallerID(long installerID) {
		this.installerID = installerID;
	}
	public final int getRuns() {
		return runs;
	}
	public final void setRuns(int runs) {
		this.runs = runs;
	}
	public final int getLicensedProductionRuns() {
		return licensedProductionRuns;
	}
	public final void setLicensedProductionRuns(int licensedProductionRuns) {
		this.licensedProductionRuns = licensedProductionRuns;
	}
	public final long getInstalledInSolarSystemID() {
		return installedInSolarSystemID;
	}
	public final void setInstalledInSolarSystemID(long installedInSolarSystemID) {
		this.installedInSolarSystemID = installedInSolarSystemID;
	}
	public final long getContainerLocationID() {
		return containerLocationID;
	}
	public final void setContainerLocationID(long containerLocationID) {
		this.containerLocationID = containerLocationID;
	}
	public final int getMaterialMultiplier() {
		return materialMultiplier;
	}
	public final void setMaterialMultiplier(int materialMultiplier) {
		this.materialMultiplier = materialMultiplier;
	}
	public final int getCharMaterialMultiplier() {
		return charMaterialMultiplier;
	}
	public final void setCharMaterialMultiplier(int charMaterialMultiplier) {
		this.charMaterialMultiplier = charMaterialMultiplier;
	}
	public final int getTimeMultiplier() {
		return timeMultiplier;
	}
	public final void setTimeMultiplier(int timeMultiplier) {
		this.timeMultiplier = timeMultiplier;
	}
	public final int getCharTimeMultiplier() {
		return charTimeMultiplier;
	}
	public final void setCharTimeMultiplier(int charTimeMultiplier) {
		this.charTimeMultiplier = charTimeMultiplier;
	}
	public final long getInstalledItemTypeID() {
		return installedItemTypeID;
	}
	public final void setInstalledItemTypeID(long installedItemTypeID) {
		this.installedItemTypeID = installedItemTypeID;
	}
	public final long getOutputTypeID() {
		return outputTypeID;
	}
	public final void setOutputTypeID(long outputTypeID) {
		this.outputTypeID = outputTypeID;
	}
	public final long getContainerTypeID() {
		return containerTypeID;
	}
	public final void setContainerTypeID(long containerTypeID) {
		this.containerTypeID = containerTypeID;
	}
	public final boolean getInstalledItemCopy() {
		return installedItemCopy;
	}
	public final void setInstalledItemCopy(boolean installedItemCopy) {
		this.installedItemCopy = installedItemCopy;
	}
	public final boolean getCompleted() {
		return completed;
	}
	public final void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public final int getInstalledItemFlag() {
		return installedItemFlag;
	}
	public final void setInstalledItemFlag(int installedItemFlag) {
		this.installedItemFlag = installedItemFlag;
	}
	public final int getOutputFlag() {
		return outputFlag;
	}
	public final void setOutputFlag(int outputFlag) {
		this.outputFlag = outputFlag;
	}
	public final long getActivityID() {
		return activityID;
	}
	
	public final void setActivityID(int activityID) {
		this.activityID = activityID;
		this.activityType = Type.typeOf(activityID);
	}
	
	public final IndustryJob.Type getType() {
		return activityType;
	}
	
	public final int getCompletedStatus() {
		return completedStatus;
	}
	public final void setCompletedStatus(int completedStatus) {
		this.completedStatus = completedStatus;
	}
	public final long getInstallTime() {
		return installTime;
	}
	public final void setInstallTime(long installTime) {
		this.installTime = installTime;
	}
	public final long getBeginProductionTime() {
		return beginProductionTime;
	}
	public final void setBeginProductionTime(long beginProductionTime) {
		this.beginProductionTime = beginProductionTime;
	}
	public final long getEndProductionTime() {
		return endProductionTime;
	}
	public final void setEndProductionTime(long endProductionTime) {
		this.endProductionTime = endProductionTime;
	}
	public final long getPauseProductionTime() {
		return pauseProductionTime;
	}
	public final void setPauseProductionTime(long pauseProductionTime) {
		this.pauseProductionTime = pauseProductionTime;
	}
	public final String getInstalledItemName() {
		return installedItemName;
	}
	public final void setInstalledItemName(String installedItemName) {
		this.installedItemName = installedItemName;
	}
	public final String getInstalledLocationName() {
		return installedLocationName;
	}
	public final void setInstalledLocationName(String installedLocationName) {
		this.installedLocationName = installedLocationName;
	}
	public final String getOutputLocationName() {
		return outputLocationName;
	}
	public final void setOutputLocationName(String outputLocationName) {
		this.outputLocationName = outputLocationName;
	}
	public final String getInstallerName() {
		return installerName;
	}
	public final void setInstallerName(String installerName) {
		this.installerName = installerName;
	}
	public final String getInstalledInSolarSystemName() {
		return installedInSolarSystemName;
	}
	public final void setInstalledInSolarSystemName(
			String installedInSolarSystemName) {
		this.installedInSolarSystemName = installedInSolarSystemName;
	}
	public final String getContainerTypeName() {
		return containerTypeName;
	}
	public final void setContainerTypeName(String containerTypeName) {
		this.containerTypeName = containerTypeName;
	}
	public final String getContainerLocationName() {
		return containerLocationName;
	}
	public final void setContainerLocationName(String containerLocationName) {
		this.containerLocationName = containerLocationName;
	}
	public final String getInstalledItemTypeName() {
		return installedItemTypeName;
	}
	public final void setInstalledItemTypeName(String installedItemTypeName) {
		this.installedItemTypeName = installedItemTypeName;
	}
	public final String getOutputTypeName() {
		return outputTypeName;
	}
	public final void setOutputTypeName(String outputTypeName) {
		this.outputTypeName = outputTypeName;
	}
	
	
}
