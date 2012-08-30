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
import java.util.LinkedList;
import java.util.List;

public class Certificate extends Object implements Serializable {
	
	private static final long serialVersionUID = -5060400316279720293L;

	private long certificateID;
	
	private long classID;
	private String className;
	
	private long categoryID;
	private String categoryName;
		
	private long corporationID;
	
	private int grade;
	private String description;
	
	private List<EveSkill> requiredSkills = new LinkedList<EveSkill>();
	private List<Certificate> requiredCertificates = new LinkedList<Certificate>();
	
	public long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public final long getCertificateID() {
		return certificateID;
	}

	public final void setCertificateID(long certificateID) {
		this.certificateID = certificateID;
	}

	public final long getClassID() {
		return classID;
	}

	public final void setClassID(long classID) {
		this.classID = classID;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public final long getCorporationID() {
		return corporationID;
	}

	public final void setCorporationID(long corporationID) {
		this.corporationID = corporationID;
	}

	public final int getGrade() {
		return grade;
	}

	public final void setGrade(int grade) {
		this.grade = grade;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

	public void addRequirement(final Certificate c) {		
		this.requiredCertificates.add(c);
	}
	
	public void addRequirement(final EveSkill s) {
		this.requiredSkills.add(s);
	}

	public final List<EveSkill> getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequirements(List<Certificate> requiredCertificates) {
		this.requiredCertificates = requiredCertificates;
	}

	public final List<Certificate> getRequiredCertificates() {
		return requiredCertificates;
	}
}
