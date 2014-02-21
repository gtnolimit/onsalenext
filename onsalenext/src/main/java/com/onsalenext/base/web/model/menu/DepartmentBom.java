package com.onsalenext.base.web.model.menu;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "department")
public class DepartmentBom {
	
	private Long id;
	private String storeName;
	private Set<CategoryBom> categories = new HashSet<CategoryBom>();
	 
	public DepartmentBom ( Long id, String storeName, Set<CategoryBom> category){
		this.id = id;
		this.storeName = storeName;
		this.categories = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Set<CategoryBom> getCategories() {
		return categories;
	}

	public void setCategories(Set<CategoryBom> categories) {
		this.categories = categories;
	}
}
