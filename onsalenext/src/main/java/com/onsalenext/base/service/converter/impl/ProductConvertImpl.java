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

import com.onsalenext.base.domain.menu.Product;
import com.onsalenext.base.service.converter.ItemConvert;
import com.onsalenext.base.service.converter.PictureConvert;
import com.onsalenext.base.service.converter.ProductConvert;
import com.onsalenext.base.web.model.menu.ProductBom;

@Service
public class ProductConvertImpl implements ProductConvert {

	@Autowired
	private ItemConvert itemConvert;
	
	@Autowired
	private PictureConvert pictureConvert;

	public Product convert ( ProductBom o, String action ){
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new Product ( o.getId (), o.getAttribute (), o.isActive(), 
					pictureConvert.convert ( o.getPicture(), action ), 
					itemConvert.convert ( o.getItems(), action ), new Date (), new Date (), "admin");
		return new Product ( o.getId (), o.getAttribute (), o.isActive(), 
				pictureConvert.convert ( o.getPicture(), action ), 
				itemConvert.convert ( o.getItems(), action ), new Date (), "admin");
	}
	
	public ProductBom convert ( Product o ){
		return new ProductBom ( o.getId (), o.getAttribute (), o.isActive(), 
				pictureConvert.convert ( o.getPicture() ), itemConvert.convert ( o.getItems() ) );
	}
	
	public Set<ProductBom> convert ( Set <Product> o ){
		Set<ProductBom> ss = new TreeSet <ProductBom> ();
		for ( Product s : o ) ss.add( this.convert ( s ));
		return ss;
	}
	
	public Set<Product> convert ( Set <ProductBom> o, String action ){
		Set<Product> ss = new HashSet <Product> ();
		for ( ProductBom s : o ) ss.add( this.convert ( s, action ));
		return ss;
	}

	public List<ProductBom> convert ( List <Product> o ){
		List<ProductBom> ss = new ArrayList <ProductBom> ();
		for ( Product s : o ) ss.add( this.convert ( s ));
		Collections.sort(ss);
		return ss;

	}
}
