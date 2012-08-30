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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CertificateTree extends Object implements Serializable {

	private static final long serialVersionUID = 5776187103343768179L;

	public static class CategoryClass extends Object implements Serializable {
		
		private static final long serialVersionUID = -3863970255956866294L;
		
		private long classID;
		private String className;
		
		private long categoryID;
		private String categoryName;
				
		private List<Certificate> certificates = new LinkedList<Certificate>();
		
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

		public final long getClassID() {
			return classID;
		}

		public final void setClassID(long classID) {
			this.classID = classID;
		}

		public final String getClassName() {
			return className;
		}

		public final void setClassName(String className) {
			this.className = className;
		}

		public final List<Certificate> getCertificates() {
			return certificates;
		}

		public void addCertificate(final Certificate c) {
			c.setClassID(this.classID);
			c.setClassName(this.className);
			this.certificates.add(c);
		}
		
		public Certificate findCertificate(final int grade) {
			for (Certificate c: this.certificates) {
				if (c.getGrade() == grade) {
					return c;
				}
			}
			return null;
		}
	}
	
	public static class Category extends Object implements Serializable {
		
		private static final long serialVersionUID = -3772978056753214474L;
		
		private long categoryID;
		private String categoryName;
		
		private List<CertificateTree.CategoryClass> classes = new LinkedList<CertificateTree.CategoryClass>();
		
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

		public final List<CertificateTree.CategoryClass> getClasses() {
			return classes;
		}

		public void addClass(final CertificateTree.CategoryClass c) {			
			this.classes.add(c);
		}		
	}
	
	
	private final List<CertificateTree.Category> categories = new LinkedList<CertificateTree.Category>();
	private final Map<Long, Certificate> certificates = new HashMap<Long, Certificate>();
	
	public void addCategory(final CertificateTree.Category c) {		
		this.categories.add(c);
	}
		
	public final List<CertificateTree.Category> getCategories() {
		return this.categories;
	}

	public final Certificate getCertificate(long certID) {
		return this.certificates.get(certID);
	}
	
	public final Map<Long, Certificate> getCertificates() {
		return this.certificates;		
	}
	
	final void index() {
		this.certificates.clear();
		for (CertificateTree.Category c: this.categories) {
			for (CertificateTree.CategoryClass cl: c.getClasses()) {
				cl.setCategoryID(c.categoryID);
				cl.setCategoryName(c.categoryName);
				for (Certificate cert: cl.getCertificates()) {
					cert.setCategoryID(c.categoryID);
					cert.setCategoryName(c.categoryName);
					cert.setClassID(cl.getClassID());
					cert.setClassName(cl.getClassName());
					this.certificates.put(cert.getCertificateID(), cert);				
				}
			}
		}
		for (CertificateTree.Category c: this.categories) {
			for (CertificateTree.CategoryClass cl: c.getClasses()) {
				for (Certificate cert: cl.getCertificates()) {
					List<Certificate> req = new LinkedList<Certificate>();
					for (Certificate r: cert.getRequiredCertificates()) {
						Certificate requiredCert = getCertificate(r.getCertificateID());
						if (r.getCertificateID() != cert.getCertificateID()) {
							req.add(requiredCert);
						}
					}
					cert.setRequirements(req);
				}
			}
		}
	}
}
