package com.onsalenext.base.web.model.menu;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import com.onsalenext.base.web.model.item.BrandBom;


@XmlRootElement(name = "category")
public class CategoryBom implements Comparable<CategoryBom>{
	
	private Long id;
	private String attribute;
	private boolean isActive;
	private Set<SubCategoryBom> subCategories;
	private Set<BrandBom> brands;
	
	public CategoryBom ( Long id, String attribute, boolean isActive, Set<SubCategoryBom> subCategory, Set<BrandBom> brands){
		this.attribute = attribute;
		this.id = id;
		this.subCategories = subCategory;
		this.brands = brands;
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
	public Set<SubCategoryBom> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(Set<SubCategoryBom> subCategories) {
		this.subCategories = subCategories;
	}
	public int compareTo(CategoryBom o) {
		return attribute.compareTo(o.attribute);
	}
	public Set<BrandBom> getBrands() {
		return brands;
	}
	public void setBrands(Set<BrandBom> brands) {
		this.brands = brands;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
