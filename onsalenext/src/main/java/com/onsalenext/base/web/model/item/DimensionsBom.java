package com.onsalenext.base.web.model.item;

import com.onsalenext.base.domain.lookup.LengthTypeLookup;
import com.onsalenext.base.domain.lookup.WeightTypeLookup;

public class DimensionsBom implements Comparable<DimensionsBom>{

	private Long id;
	private double height;
	private double width;
	private double depth;
	private double weight;
	private double shippingHeight;
	private double shippingWidth;
	private double shippingDepth;
	private double shippingWeight;
	private WeightTypeLookup weightType;
	private LengthTypeLookup lengthType;
	
	public DimensionsBom (Long id, double height, double width, double depth, 
			double weight, double shippingHeight, double shippingWidth, 
			double shippingDepth, double shippingWeight, 
			WeightTypeLookup weightType, LengthTypeLookup lengthType){
		
		this.id = id;
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.weight = weight;
		this.shippingHeight = shippingHeight;
		this.shippingWidth = shippingWidth;
		this.shippingDepth = shippingDepth;
		this.shippingWeight = shippingWeight;
		this.weightType = weightType;
		this.lengthType = lengthType;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getDepth() {
		return depth;
	}
	public void setDepth(double depth) {
		this.depth = depth;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getShippingHeight() {
		return shippingHeight;
	}
	public void setShippingHeight(double shippingHeight) {
		this.shippingHeight = shippingHeight;
	}
	public double getShippingWidth() {
		return shippingWidth;
	}
	public void setShippingWidth(double shippingWidth) {
		this.shippingWidth = shippingWidth;
	}
	public double getShippingDepth() {
		return shippingDepth;
	}
	public void setShippingDepth(double shippingDepth) {
		this.shippingDepth = shippingDepth;
	}
	public double getShippingWeight() {
		return shippingWeight;
	}
	public void setShippingWeight(double shippingWeight) {
		this.shippingWeight = shippingWeight;
	}
	public WeightTypeLookup getWeightType() {
		return weightType;
	}
	public void setWeightType(WeightTypeLookup weightType) {
		this.weightType = weightType;
	}
	public LengthTypeLookup getLengthType() {
		return lengthType;
	}
	public void setLengthType(LengthTypeLookup lengthType) {
		this.lengthType = lengthType;
	}

	public int compareTo(DimensionsBom o) {
		return this.id.compareTo(o.id);
	}

	
}
