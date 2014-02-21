package com.onsalenext.base.service.converter.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.item.Item;
import com.onsalenext.base.service.converter.AccessoriesConvert;
import com.onsalenext.base.service.converter.BrandConvert;
import com.onsalenext.base.service.converter.ColorConvert;
import com.onsalenext.base.service.converter.CustomerReviewConvert;
import com.onsalenext.base.service.converter.DimensionsConvert;
import com.onsalenext.base.service.converter.FeatureConvert;
import com.onsalenext.base.service.converter.ItemConvert;
import com.onsalenext.base.service.converter.PictureConvert;
import com.onsalenext.base.service.converter.RatingConvert;
import com.onsalenext.base.service.converter.ReviewConvert;
import com.onsalenext.base.service.converter.SizeConvert;
import com.onsalenext.base.service.converter.SpecificationConvert;
import com.onsalenext.base.service.converter.TagConvert;
import com.onsalenext.base.service.converter.WarrantyConvert;
import com.onsalenext.base.web.model.item.ItemBom;

@Service
public class ItemConvertImpl implements ItemConvert {

	@Autowired
	private AccessoriesConvert accessories;
	@Autowired
	private ColorConvert color;
	@Autowired
	private CustomerReviewConvert customerReview;
	@Autowired
	private DimensionsConvert dimensions;
	@Autowired
	private FeatureConvert feature;
	@Autowired
	private RatingConvert rating;
	@Autowired
	private ReviewConvert review;
	@Autowired
	private SizeConvert size;
	@Autowired
	private SpecificationConvert specification;
	@Autowired
	private TagConvert tag;
	@Autowired
	private WarrantyConvert warranty;
	@Autowired
	private BrandConvert brand;
	@Autowired
	private PictureConvert picture;
	
	public ItemBom convert(Item o, String type) {
		
		if ( o == null ) return null;

		if ( type.equals("SHORT"))
			return new ItemBom ( o.getId (), o.getSubject (), o.getShortDescription (), o.isRefundable (), 
					o.getRegularPrice (), o.getPrice (), o.getQty (), o.isInStack (),o.isAvailableForReorder (), 
					o.getBrandModelNumber (), o.getBarCode (), o.getClerancePrice (), o.isClearancePriceActive (), 
					o.getSalePrice (), o.getSaleDateStart (), o.getSaleDateEnd (), o.isEmailSale(), o.isActive (), 
					brand.convert ( o.getBrands () )
					//, customerReview.convert ( o.getCustomerReviews () )
					//, review.convert ( o.getReview () )
					//, dimensions.convert ( o.getDimension () ) 
					//, rating.convert ( o.getRating () )
					//, warranty.convert ( o.getWarranties () ) 
					//, specification.convert ( o.getSpecifications () ) 
					//, feature.convert ( o.getFeatures () )
					, picture.convert ( o.getPictures () )
					//, accessories.convert ( o.getAccessories () )
					//, color.convert ( o.getColors () )
					//, size.convert ( o.getSizes () )
					//, tag.convert ( o.getTags ())
					);
		
		return new ItemBom ( o.getId (), o.getSubject (), o.getShortDescription (), o.getDescription (), o.isRefundable (), 
				o.getRegularPrice (), o.getPrice (), o.getQty (), o.isInStack (),o.isAvailableForReorder (), 
				o.getBrandModelNumber (), o.getBarCode (), o.getClerancePrice (), o.isClearancePriceActive (), 
				o.getSalePrice (), o.getSaleDateStart (), o.getSaleDateEnd (), o.isEmailSale(), o.isActive (), 
				brand.convert ( o.getBrands () ), 
				customerReview.convert ( o.getCustomerReviews () ), 
				review.convert ( o.getReview () ), 
				dimensions.convert ( o.getDimension () ), 
				rating.convert ( o.getRating () ), 
				warranty.convert ( o.getWarranties () ), 
				specification.convert ( o.getSpecifications () ), 
				feature.convert ( o.getFeatures () ), 
				picture.convert ( o.getPictures () ), 
				accessories.convert ( o.getAccessories () ), 
				color.convert ( o.getColors () ), 
				size.convert ( o.getSizes () ), 
				tag.convert ( o.getTags () ) );
	}

	public Item convert(ItemBom o, String action) {
		
		if ( o == null ) return null;

		if ( action.equalsIgnoreCase( "ADD" ))
			return new Item ( o.getId (), o.getSubject (), o.getShortDescription (), o.getDescription (), o.isRefundable (), 
				o.getRegularPrice (), o.getPrice (), o.getQty (), o.isInStack (),o.isAvailableForReorder (), 
				o.getBrandModelNumber (), o.getBarCode (), o.getClerancePrice (), o.isClearancePriceActive (), 
				o.getSalePrice (), o.getSaleDateStart (), o.getSaleDateEnd (), o.isEmailSale(), o.isActive (), 
				brand.convert ( o.getBrands (), action ), 
				customerReview.convert ( o.getCustomerReviews (), action  ), 
				review.convert ( o.getReview (), action  ), 
				dimensions.convert ( o.getDimension (), action  ), 
				rating.convert ( o.getRating (), action  ), 
				warranty.convert ( o.getWarranties (), action  ), 
				specification.convert ( o.getSpecifications (), action  ), 
				feature.convert ( o.getFeatures (), action  ), 
				picture.convert ( o.getPictures (), action  ), 
				accessories.convert ( o.getAccessories (), action  ), 
				color.convert ( o.getColors (), action  ), 
				size.convert ( o.getSizes (), action  ), 
				tag.convert ( o.getTags (), action  ), new Date (),
				new Date (), "admin" );
		
		return new Item ( o.getId (), o.getSubject (), o.getShortDescription (), o.getDescription (), o.isRefundable (), 
				o.getRegularPrice (), o.getPrice (), o.getQty (), o.isInStack (),o.isAvailableForReorder (), 
				o.getBrandModelNumber (), o.getBarCode (), o.getClerancePrice (), o.isClearancePriceActive (), 
				o.getSalePrice (), o.getSaleDateStart (), o.getSaleDateEnd (), o.isEmailSale(), o.isActive (), 
				brand.convert ( o.getBrands (), action ), 
				customerReview.convert ( o.getCustomerReviews (), action  ), 
				review.convert ( o.getReview (), action  ), 
				dimensions.convert ( o.getDimension (), action  ), 
				rating.convert ( o.getRating (), action  ), 
				warranty.convert ( o.getWarranties (), action  ), 
				specification.convert ( o.getSpecifications (), action  ), 
				feature.convert ( o.getFeatures (), action  ), 
				picture.convert ( o.getPictures (), action  ), 
				accessories.convert ( o.getAccessories (), action  ), 
				color.convert ( o.getColors (), action  ), 
				size.convert ( o.getSizes (), action  ), 
				tag.convert ( o.getTags (), action  ), 
				new Date (), "admin" );
	}

	public Set<ItemBom> convert(Set<Item> o) {
		if ( o == null ) return null;
		Set <ItemBom> ss = new TreeSet <ItemBom> ();
		for ( Item i : o ) ss.add( this.convert( i, "SHORT" ));
		return ss;
	}

	public Set<Item> convert(Set<ItemBom> o, String action) {
		if ( o == null ) return null;
		Set <Item> ss = new HashSet <Item> ();
		for ( ItemBom i : o ) ss.add( this.convert( i, action ));
		return ss;
	}

	public List<ItemBom> convert ( List<Item> o ) {
		List <ItemBom> ss = new ArrayList <ItemBom> ();
		for ( Item s : o ) ss.add(  this.convert( s, "SHORT" ));
		Collections.sort( ss );
		return ss;
	}

}
