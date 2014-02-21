package com.onsalenext.base.domain.item;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.onsalenext.base.domain.DBBase;
import com.onsalenext.base.domain.lookup.LengthTypeLookup;
import com.onsalenext.base.domain.lookup.WeightTypeLookup;

@Entity
@Table(name = "DIMENSIONS", schema="ONSALENEXT_ITEM")
public class Dimensions  extends DBBase implements Serializable{

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "DIMENSION_ID")
	private Long id;
	@Column(name = "HEIGHT", unique=false, nullable=true)
	private double height;
	@Column(name = "WIDTH", unique=false, nullable=true)
	private double width;
	@Column(name = "DEPTH", unique=false, nullable=true)
	private double depth;
	@Column(name = "WEIGHT", unique=false, nullable=true)
	private double weight;
	@Column(name = "SHIPPING_HEIGHT", unique=false, nullable=true)
	private double shippingHeight;
	@Column(name = "SHIPPING_WIDTH", unique=false, nullable=true)
	private double shippingWidth;
	@Column(name = "SHIPPING_DEPTH", unique=false, nullable=true)
	private double shippingDepth;
	@Column(name = "SHIPPING_WEIGHT", unique=false, nullable=true)
	private double shippingWeight;
	
	@OneToOne
	@JoinColumn (name="WEIGHT_TYPE")
	private WeightTypeLookup weightType;
	
	@OneToOne
	@JoinColumn (name="LENGTH_TYPE")
	private LengthTypeLookup lengthType;

	public Dimensions () {}
	
	public Dimensions ( Long id, double height, double width, double depth, double weight, double shippingHeight, 
			double shippingWidth, double shippingDepth, double shippingWeight, WeightTypeLookup weightType, 
			LengthTypeLookup lengthType, Date upd, String user )	{
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
		this.upd = upd;
		this.user = user;
	}
	
	public Dimensions ( Long id, double height, double width, double depth, double weight, double shippingHeight, 
			double shippingWidth, double shippingDepth, double shippingWeight, WeightTypeLookup weightType, 
			LengthTypeLookup lengthType, Date cpd, Date upd, String user )	{
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

}
