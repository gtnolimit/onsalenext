package com.onsalenext.base.web.model.menu;

import java.util.HashSet;
import java.util.Set;

import com.onsalenext.base.domain.item.Brand;
import com.onsalenext.base.web.model.item.BrandBom;

public class CategoryBrandBom implements Comparable<CategoryBrandBom>{

	private Long id;
	private String attribute;
	private boolean isActive;
	private Set<Brand> brands = new HashSet <Brand> ();
	private Set<BrandBom> brandBom = new HashSet <BrandBom> ();
	
	public CategoryBrandBom ( Long id, String attribute, boolean isActive, Set<Brand> brands){
		this.attribute = attribute;
		this.id = id;
		this.brands = brands;
	}
	
	public CategoryBrandBom ( Long id, String attribute, Set<BrandBom> brandBom){
		this.attribute = attribute;
		this.id = id;
		this.brandBom = brandBom;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Set<Brand> getBrands() {
		return brands;
	}

	public void setBrands(Set<Brand> brands) {
		this.brands = brands;
	}

	public Set<BrandBom> getBrandBom() {
		return brandBom;
	}

	public void setBrandBom(Set<BrandBom> brandBom) {
		this.brandBom = brandBom;
	}

	public int compareTo(CategoryBrandBom o) {
		return attribute.compareTo(o.attribute);
	}
}
