package com.onsalenext.base.domain.menu;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.onsalenext.base.domain.DBBase;
import com.onsalenext.base.domain.item.Brand;

@Entity
@Table(name = "CATEGORY", schema="ONSALENEXT_HOME")
public class Category extends DBBase implements Serializable {

	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@Column(name="CATEGORY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "ATTRIBUTE" , unique=false, nullable=false, length=100)
	private String attribute;
	@Column(name = "STATUS", unique=false, nullable=false)
	private boolean isActive;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CATEGORY_SUBCATEGORY_LINK", 
		joinColumns = { @JoinColumn(name = "CATEGORY_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "SUBCATEGORY_ID") })
	private Set<SubCategory> subCategories = new HashSet <SubCategory> (0);

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name="CATEGORY_BRAND_LINK", 
                joinColumns={@JoinColumn(name="CATEGORY_ID")}, 
                inverseJoinColumns={@JoinColumn(name="BRAND_ID")})
    private Set<Brand> brands = new HashSet<Brand>();

    public Category () {}
  
	public Category (Long id, String attribute, boolean isActive, Set<SubCategory> subCategories, Set<Brand> brands,
			Date upd, String user){
		this.id = id;
		this.attribute = attribute;
		this.isActive = isActive;
		this.subCategories = subCategories;
		this.brands = brands;
		this.upd = upd;
		this.user = user;
	}

	public Category (Long id, String attribute, boolean isActive, Set<SubCategory> subCategories, Set<Brand> brands,
			Date cpd, Date upd, String user){
		this.id = id;
		this.attribute = attribute;
		this.isActive = isActive;
		this.subCategories = subCategories;
		this.brands = brands;
		this.cpd = cpd;
		this.upd = upd;
		this.user = user;
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

	public Set<SubCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(Set<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Brand> getBrands() {
		return brands;
	}

	public void setBrands(Set<Brand> brands) {
		this.brands = brands;
	}

//	public Set<CategoryBrand> getCategoryBrands() {
//		return categoryBrands;
//	}

//	public void setCategoryBrands(Set<CategoryBrand> categoryBrands) {
//		this.categoryBrands = categoryBrands;
//	}

}