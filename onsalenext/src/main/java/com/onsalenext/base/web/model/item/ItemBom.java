package com.onsalenext.base.web.model.item;

import java.util.Date;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import com.onsalenext.base.web.model.PictureBom;


@XmlRootElement(name = "item")
public class ItemBom implements Comparable<ItemBom>{

	private Long id;
	private String subject;
	private String shortDescription;
	private String description;
	private boolean refundable;
	private double regularPrice;
	private double price;
	private int qty;
	private boolean inStack;
	private boolean availableForReorder;
	private String brandModelNumber;
	private String barCode;
	private double clerancePrice;
	private boolean clearancePriceActive;
	private double salePrice;
	protected Date saleDateStart;
	protected Date saleDateEnd;
	private boolean emailSale;
	private boolean isActive;
	private Set<BrandBom> brands;
	private Set<CustomerReviewBom> customerReviews;
	private ReviewBom review;
	private DimensionsBom dimension;
	private RatingBom rating;
	private Set<WarrantyBom> warranties;
	private Set<SpecificationBom> specifications;
	private Set<FeatureBom> features;
	private Set<PictureBom> pictures;
    private Set<AccessoriesBom> accessories;
	private Set<ColorBom> colors;
	private Set<SizeBom> sizes;
    private Set<TagBom> tags;

    public ItemBom ( Long id, String subject, String shortDescription, String description, boolean refundable, 
			double regularPrice, double price, int qty, boolean inStack, boolean availableForReorder, 
			String brandModelNumber, String barCode, double clerancePrice, boolean clearancePriceActive, 
			double salePrice, Date saleDateStart, Date saleDateEnd, boolean emailSale, boolean isActive, Set<BrandBom> brand, 
			Set<CustomerReviewBom> customerReviews, ReviewBom review, DimensionsBom dimension, RatingBom rating, 
			Set<WarrantyBom> warranties, Set<SpecificationBom> specifications, Set<FeatureBom> features, 
			Set<PictureBom> pictures, Set<AccessoriesBom> accessories, Set<ColorBom> colors, Set<SizeBom> sizes, 
			Set<TagBom> tags){
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
	}
    
    public ItemBom ( Long id, String subject, String shortDescription, boolean refundable, 
			double regularPrice, double price, int qty, boolean inStack, boolean availableForReorder, 
			String brandModelNumber, String barCode, double clerancePrice, boolean clearancePriceActive, 
			double salePrice, Date saleDateStart, Date saleDateEnd, boolean emailSale, boolean isActive,
			Set<BrandBom> brands, Set<PictureBom> pictures ){
		this.id = id;
		this.subject = subject;
		this.shortDescription = shortDescription;
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
		this.isActive = isActive;
		this.emailSale = emailSale;
		this.brands = brands;
		this.pictures = pictures;
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
	public Set<CustomerReviewBom> getCustomerReviews() {
		return customerReviews;
	}
	public void setCustomerReviews(Set<CustomerReviewBom> customerReviews) {
		this.customerReviews = customerReviews;
	}
	public ReviewBom getReview() {
		return review;
	}
	public void setReview(ReviewBom review) {
		this.review = review;
	}
	public DimensionsBom getDimension() {
		return dimension;
	}
	public void setDimension(DimensionsBom dimension) {
		this.dimension = dimension;
	}
	public RatingBom getRating() {
		return rating;
	}
	public void setRating(RatingBom rating) {
		this.rating = rating;
	}
	public Set<WarrantyBom> getWarranties() {
		return warranties;
	}
	public void setWarranties(Set<WarrantyBom> warranties) {
		this.warranties = warranties;
	}
	public Set<SpecificationBom> getSpecifications() {
		return specifications;
	}
	public void setSpecifications(Set<SpecificationBom> specifications) {
		this.specifications = specifications;
	}
	public Set<FeatureBom> getFeatures() {
		return features;
	}
	public void setFeatures(Set<FeatureBom> features) {
		this.features = features;
	}
	public Set<PictureBom> getPictures() {
		return pictures;
	}
	public void setPictures(Set<PictureBom> pictures) {
		this.pictures = pictures;
	}
	public Set<AccessoriesBom> getAccessories() {
		return accessories;
	}
	public void setAccessories(Set<AccessoriesBom> accessories) {
		this.accessories = accessories;
	}
	public Set<ColorBom> getColors() {
		return colors;
	}
	public void setColors(Set<ColorBom> colors) {
		this.colors = colors;
	}
	public Set<SizeBom> getSizes() {
		return sizes;
	}
	public void setSizes(Set<SizeBom> sizes) {
		this.sizes = sizes;
	}
	public Set<TagBom> getTags() {
		return tags;
	}
	public void setTags(Set<TagBom> tags) {
		this.tags = tags;
	}

	public int compareTo(ItemBom o) {
		return subject.compareTo(o.subject);
	}

	public Set<BrandBom> getBrands() {
		return brands;
	}

	public void setBrands(Set<BrandBom> brands) {
		this.brands = brands;
	}

	public boolean isEmailSale() {
		return emailSale;
	}

	public void setEmailSale(boolean emailSale) {
		this.emailSale = emailSale;
	}   
}
