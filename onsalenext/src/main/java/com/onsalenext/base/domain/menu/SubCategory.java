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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.onsalenext.base.domain.DBBase;

@Entity
@Table(name = "SUBCATEGORY", schema="ONSALENEXT_HOME")
public class SubCategory extends DBBase implements Serializable {

	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@Column(name="SUBCATEGORY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "ATTRIBUTE", unique=false, nullable=false, length=100)
	private String attribute;
	@Column(name = "STATUS", unique=false, nullable=false)
	private boolean isActive;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "SUBCATEGORY_PRODUCT_LINK", 
		joinColumns = { @JoinColumn(name = "SUBCATEGORY_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "PRODUCT_ID") })
	private Set<Product> products = new HashSet <Product> (0);

	public SubCategory () {}

	public SubCategory (Long id, String attribute, boolean isActive, Set<Product> products, 
			Date upd, String user ){
		this.id = id;
		this.attribute = attribute;
		this.isActive = isActive;
		this.products = products;
		this.upd = upd;
		this.user = user;
	}

	public SubCategory (Long id, String attribute, boolean isActive, Set<Product> products, 
			Date cpd, Date upd, String user ){
		this.id = id;
		this.attribute = attribute;
		this.isActive = isActive;
		this.products = products;
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

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
