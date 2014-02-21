package com.onsalenext.base.web.model.menu;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "subcategory")
public class SubCategoryBom implements Comparable<SubCategoryBom>{

	private Long id;
	private String attribute;
	private boolean isActive;
	private Set<ProductBom> products;

	public SubCategoryBom ( Long id, String attribute, boolean isActive, Set<ProductBom> product){
		this.id = id;
		this.attribute = attribute;
		this.products = product;
		this.isActive = isActive;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public Set<ProductBom> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductBom> products) {
		this.products = products;
	}

	public int compareTo(SubCategoryBom o) {
		return attribute.compareTo(o.attribute);
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
