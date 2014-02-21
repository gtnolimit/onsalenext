package com.onsalenext.base.domain.item;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.onsalenext.base.domain.DBBase;
import com.onsalenext.base.domain.Picture;

@Entity
@Table(name = "ITEM", schema="ONSALENEXT_ITEM")
public class Item extends DBBase implements Serializable {
	
	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@Column(name="ITEM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "SUBJECT", nullable = true, length = 1500)
	private String subject;
	@Column(name = "SORT_DESCRIPTION", unique=false, nullable=true, length=1000)
	private String shortDescription;
	@Column(name = "DESCRIPTION", unique=false, nullable=true, length=2500)
	private String description;
	@Column(name = "REFUNDABLE")
	private boolean refundable;
	@Column(name = "REGULAR_PRICE", unique=false, nullable=true)
	private double regularPrice;
	@Column(name = "PRICE", unique=false, nullable=false)
	private double price;
	@Column(name = "QTY", unique=false, nullable=false)
	private int qty;
	@Column(name = "INSTACK", unique=false, nullable=false)
	private boolean inStack;
	@Column(name = "AVAILABLE_FOR_REORDER", unique=false, nullable=false)
	private boolean availableForReorder;
	@Column(name = "BRAND_MODEL_NUMBER", unique=false, nullable=true, length=100)
	private String brandModelNumber;
	@Column(name = "BAR_CODE", unique=false, nullable=true, length=100)
	private String barCode;
	
	// Clearance price setting
	@Column(name = "CLEARANCE_PRICE", unique=false, nullable=true)
	private double clerancePrice;
	@Column(name = "CLEARANCE_PRICE_ACTIVE")
	private boolean clearancePriceActive;
	
	// email send in email
	@Column(name = "EMAIL_SALE", unique=false, nullable=true)
	private boolean emailSale;

	// sale price setting
	@Column(name = "SALE_PRICE", unique=false, nullable=true)
	private double salePrice;
	@Column(name="SALE_DATE_START", updatable=true)
	protected Date saleDateStart;
	@Column(name="SALE_DATE_END", updatable=true)
	protected Date saleDateEnd;

	@Column(name = "STATUS", unique=false, nullable=false)
	private boolean isActive;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name="ITEM_BRAND_LINK", 
                joinColumns={@JoinColumn(name="ITEM_ID")}, 
                inverseJoinColumns={@JoinColumn(name="BRAND_ID")})
    private Set<Brand> brands = new HashSet<Brand>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ITEM_CUSTOMER_REVIEW_LINK", 
		joinColumns = { @JoinColumn(name = "ITEM_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "CUSTOMER_REVIEW_ID") })
	private Set<CustomerReview> customerReviews = new HashSet <CustomerReview> (0);
	
	@OneToOne(cascade=CascadeType.ALL)
	private Review review;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Dimensions dimension;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Rating rating;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ITEM_WARRANTY_LINK", 
		joinColumns = { @JoinColumn(name = "ITEM_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "WARRANTY_ID") })
	private Set<Warranty> warranties = new HashSet <Warranty> ();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ITEM_SPECIFICATION_LINK", 
		joinColumns = { @JoinColumn(name = "ITEM_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "SPECIFICATION_ID") })
	private Set<Specification> specifications = new HashSet <Specification> ();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ITEM_FEATURE_LINK", 
		joinColumns = { @JoinColumn(name = "ITEM_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "FEATURES_ID") })
	private Set<Feature> features = new HashSet <Feature> ();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ITEM_PICTURE_LINK", 
		joinColumns = { @JoinColumn(name = "ITEM_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "PICTURE_ID") })
	private Set<Picture> pictures = new HashSet <Picture> ();

	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="ITEM_ACCESSORY_LINK", 
                joinColumns={@JoinColumn(name="ITEM_ID")}, 
                inverseJoinColumns={@JoinColumn(name="ACCESSORY_ID")})
    private Set<Accessories> accessories = new HashSet<Accessories>();

	@ManyToMany(cascade = {CascadeType.MERGE})
	@JoinTable(name="ITEM_COLOR_LINK", 
	     joinColumns={@JoinColumn(name="ITEM_ID")}, 
	     inverseJoinColumns={@JoinColumn(name="COLOR_ID")})
	private Set<Color> colors = new HashSet<Color>();
	
	@ManyToMany(cascade = {CascadeType.MERGE})
	@JoinTable(name="ITEM_SIZE_LINK", 
	   joinColumns={@JoinColumn(name="ITEM_ID")}, 
	   inverseJoinColumns={@JoinColumn(name="SIZE_ID")})
	private Set<Size> sizes = new HashSet<Size>();
		
	@ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name="ITEM_TAG_LINK", 
        joinColumns={@JoinColumn(name="ITEM_ID")}, 
        inverseJoinColumns={@JoinColumn(name="TAG_ID")})
    private Set<Tag> tags = new HashSet<Tag>();

	public Item () {}
    public Item ( Long id, String subject, String shortDescription, String description, boolean refundable, 
			double regularPrice, double price, int qty, boolean inStack, boolean availableForReorder, 
			String brandModelNumber, String barCode, double clerancePrice, boolean clearancePriceActive, 
			double salePrice, Date saleDateStart, Date saleDateEnd, boolean emailSale, boolean isActive, Set<Brand> brand, 
			Set<CustomerReview> customerReviews, Review review, Dimensions dimension, Rating rating, 
			Set<Warranty> warranties, Set<Specification> specifications, Set<Feature> features, 
			Set<Picture> pictures, Set<Accessories> accessories, Set<Color> colors, Set<Size> sizes, 
			Set<Tag> tags, Date upd, String user){
		this.id = id;
		this.subject = subject;
		this.shortDescription = shortDescription;
		this.description = description;
		this.refundable = refundable;
		this.regularPrice = regularPrice;
		this.price = price;
		this.qty = qty;
		this.inStack = inStack;
		this.availableForReorder = availableForReorder;
		this.brandModelNumber = brandModelNumber;
		this.barCode = barCode;
		this.clerancePrice = clerancePrice;
		this.clearancePriceActive = clearancePriceActive;
		this.salePrice = salePrice;
		this.saleDateStart = saleDateStart;
		this.saleDateEnd = saleDateEnd;
		this.emailSale = emailSale;
		this.isActive = isActive;
		this.brands = brand;
		this.customerReviews = customerReviews;
		this.review = review;
		this.dimension = dimension;
		this.rating = rating;
		this.warranties = warranties;
		this.specifications = specifications;
		this.features = features;
		this.pictures = pictures;
		this.accessories = accessories;
		this.colors = colors;
		this.sizes = sizes;
		this.tags = tags;
		this.upd = upd;
		this.user = user;
	}
    
    public Item ( Long id, String subject, String shortDescription, String description, boolean refundable, 
			double regularPrice, double price, int qty, boolean inStack, boolean availableForReorder, 
			String brandModelNumber, String barCode, double clerancePrice, boolean clearancePriceActive, 
			double salePrice, Date saleDateStart, Date saleDateEnd, boolean emailSale, boolean isActive, Set<Brand> brand, 
			Set<CustomerReview> customerReviews, Review review, Dimensions dimension, Rating rating, 
			Set<Warranty> warranties, Set<Specification> specifications, Set<Feature> features, 
			Set<Picture> pictures, Set<Accessories> accessories, Set<Color> colors, Set<Size> sizes, 
			Set<Tag> tags, Date cpd, Date upd, String user){
		this.id = id;
		this.subject = subject;
		this.shortDescription = shortDescription;
		this.description = description;
		this.refundable = refundable;
		this.regularPrice = regularPrice;
		this.price = price;
		this.qty = qty;
		this.inStack = inStack;
		this.availableForReorder = availableForReorder;
		this.brandModelNumber = brandModelNumber;
		this.barCode = barCode;
		this.clerancePrice = clerancePrice;
		this.clearancePriceActive = clearancePriceActive;
		this.salePrice = salePrice;
		this.saleDateStart = saleDateStart;
		this.saleDateEnd = saleDateEnd;
		this.emailSale = emailSale;
		this.isActive = isActive;
		this.brands = brand;
		this.customerReviews = customerReviews;
		this.review = review;
		this.dimension = dimension;
		this.rating = rating;
		this.warranties = warranties;
		this.specifications = specifications;
		this.features = features;
		this.pictures = pictures;
		this.accessories = accessories;
		this.colors = colors;
		this.sizes = sizes;
		this.tags = tags;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isRefundable() {
		return refundable;
	}

	public void setRefundable(boolean refundable) {
		this.refundable = refundable;
	}

	public double getRegularPrice() {
		return regularPrice;
	}

	public void setRegularPrice(double regularPrice) {
		this.regularPrice = regularPrice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBrandModelNumber() {
		return brandModelNumber;
	}

	public void setBrandModelNumber(String brandModelNumber) {
		this.brandModelNumber = brandModelNumber;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public double getClerancePrice() {
		return clerancePrice;
	}

	public void setClerancePrice(double clerancePrice) {
		this.clerancePrice = clerancePrice;
	}

	public boolean isClearancePriceActive() {
		return clearancePriceActive;
	}

	public void setClearancePriceActive(boolean clearancePriceActive) {
		this.clearancePriceActive = clearancePriceActive;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public Date getSaleDateStart() {
		return saleDateStart;
	}

	public void setSaleDateStart(Date saleDateStart) {
		this.saleDateStart = saleDateStart;
	}

	public Date getSaleDateEnd() {
		return saleDateEnd;
	}

	public void setSaleDateEnd(Date saleDateEnd) {
		this.saleDateEnd = saleDateEnd;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Dimensions getDimension() {
		return dimension;
	}

	public void setDimension(Dimensions dimension) {
		this.dimension = dimension;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Set<Warranty> getWarranties() {
		return warranties;
	}

	public void setWarranties(Set<Warranty> warranties) {
		this.warranties = warranties;
	}

	public Set<Specification> getSpecifications() {
		return specifications;
	}

	public void setSpecifications(Set<Specification> specifications) {
		this.specifications = specifications;
	}

	public Set<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}

	public Set<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(Set<Picture> pictures) {
		this.pictures = pictures;
	}

	public Set<Accessories> getAccessories() {
		return accessories;
	}

	public void setAccessories(Set<Accessories> accessories) {
		this.accessories = accessories;
	}

	public Set<Color> getColors() {
		return colors;
	}

	public void setColors(Set<Color> colors) {
		this.colors = colors;
	}

	public Set<Size> getSizes() {
		return sizes;
	}

	public void setSizes(Set<Size> sizes) {
		this.sizes = sizes;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public Set<CustomerReview> getCustomerReviews() {
		return customerReviews;
	}

	public void setCustomerReviews(Set<CustomerReview> customerReviews) {
		this.customerReviews = customerReviews;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public boolean isInStack() {
		return inStack;
	}

	public void setInStack(boolean inStack) {
		this.inStack = inStack;
	}

	public boolean isAvailableForReorder() {
		return availableForReorder;
	}

	public void setAvailableForReorder(boolean availableForReorder) {
		this.availableForReorder = availableForReorder;
	}

	public Set<Brand> getBrands() {
		return brands;
	}

	public void setBrands(Set<Brand> brands) {
		this.brands = brands;
	}
	public boolean isEmailSale() {
		return emailSale;
	}
	public void setEmailSale(boolean emailSale) {
		this.emailSale = emailSale;
	}
}
