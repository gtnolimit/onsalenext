package com.onsalenext.base.service.converter;

import java.util.List;
import java.util.Set;

import com.onsalenext.base.domain.menu.Product;
import com.onsalenext.base.web.model.menu.ProductBom;

public interface ProductConvert {

	public ProductBom convert ( Product o );
	public Product convert ( ProductBom o, String action );
	public Set<ProductBom> convert ( Set<Product> o );
	public Set<Product> convert ( Set<ProductBom> o, String action );
	public List<ProductBom> convert ( List <Product> o );
}
