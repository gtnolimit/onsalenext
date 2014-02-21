package com.onsalenext.base.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.onsalenext.base.service.BrandService;
import com.onsalenext.base.service.MenuService;
import com.onsalenext.base.web.model.item.BrandBom;
import com.onsalenext.base.web.model.menu.CategoryBom;
import com.onsalenext.base.web.model.menu.ProductBom;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService_i;
	@Autowired
	private BrandService brandService_i;
	
	@Autowired
	private View jsonView_i;
	
	private static final String CATEGORY_FIELD = "category";
	private static final String MENU_FIELD = "menu";
	private static final String PRODUCT_FIELD = "product";
	private static final String BRAND_FIELD = "brand";
	private static final String ERROR_FIELD = "error";
	
	@RequestMapping ( value = "/{storeId}", method = RequestMethod.GET )
	public ModelAndView getMenu ( @PathVariable ( "storeId" ) Long storeId ) {
		return new ModelAndView ( jsonView_i, MENU_FIELD, menuService_i.getMenu(storeId) );
	}
	
	@RequestMapping(value = { "/category/add/" }, method = { RequestMethod.POST })
	public ModelAndView createCategory(@RequestBody CategoryBom category_p,
			HttpServletResponse httpResponse_p, WebRequest request_p) {

		Long createCategoryId;
		try {
			createCategoryId = menuService_i.add ( category_p );
			category_p.setId( createCategoryId );
		} catch (Exception e) {
			String sMessage = "Error createCategory. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		httpResponse_p.setStatus(HttpStatus.CREATED.value());
		httpResponse_p.setHeader("caregory", request_p.getContextPath() + "/category/add/" + createCategoryId);
		return new ModelAndView(jsonView_i, CATEGORY_FIELD, category_p );
	}
	@RequestMapping(value = { "/brand/add/" }, method = { RequestMethod.POST })
	public ModelAndView createBrand(@RequestBody BrandBom brand_p,
			HttpServletResponse httpResponse_p, WebRequest request_p) {

		Long createBrandId;
		try {
			createBrandId = brandService_i.add ( brand_p );
			brand_p.setId( createBrandId );
		} catch (Exception e) {
			String sMessage = "Error createBrand. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		httpResponse_p.setStatus(HttpStatus.CREATED.value());
		httpResponse_p.setHeader("product", request_p.getContextPath() + "/brand/add/" + createBrandId);
		return new ModelAndView(jsonView_i, BRAND_FIELD, brand_p );
	}
	@RequestMapping(value = { "/category/update/{categoryId}" }, method = { RequestMethod.PUT })
	public ModelAndView updateCategory(@RequestBody CategoryBom category_p, @PathVariable("categoryId") String categoryId_p,
								   HttpServletResponse httpResponse_p) {
		try {
			menuService_i.edit(category_p);
		} catch (Exception e) {
			String sMessage = "Error updateCategory. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, CATEGORY_FIELD, null);
	}
	@RequestMapping(value = { "/product/update/{productId}" }, method = { RequestMethod.PUT })
	public ModelAndView updateProduct(@RequestBody ProductBom product_p, @PathVariable("productId") String productId_p,
								   HttpServletResponse httpResponse_p) {
		try {
			menuService_i.edit(product_p);
		} catch (Exception e) {
			String sMessage = "Error updateProduct. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, PRODUCT_FIELD, null);
	}
	@RequestMapping(value = { "/brand/update/{brandId}" }, method = { RequestMethod.PUT })
	public ModelAndView updateBrand(@RequestBody BrandBom brand_p, @PathVariable("brandId") String brandId_p,
								   HttpServletResponse httpResponse_p) {
		try {
			brandService_i.edit(brand_p);
		} catch (Exception e) {
			String sMessage = "Error updateBrand. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, BRAND_FIELD, null);
	}	
	@RequestMapping(value = { "/find/product/{productName}" }, method = { RequestMethod.GET })
	public ModelAndView findProductByName(@PathVariable("productName") String productName,
				   HttpServletResponse httpResponse_p) {
		List <ProductBom> productList;
		try {
			productList = menuService_i.findProductByName(productName);
		} catch (Exception e) {
			String sMessage = "Error findProductByName. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, PRODUCT_FIELD, productList);
	}
	@RequestMapping(value = { "/find/product/id/{productId}" }, method = { RequestMethod.GET })
	public ModelAndView findProductById(@PathVariable("productId") Long productId,
				   HttpServletResponse httpResponse_p) {
		ProductBom product = menuService_i.getProduct( productId );

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, PRODUCT_FIELD, product);
	}
	@RequestMapping(value = "/delete/category/{categoryId}", method = RequestMethod.DELETE)
	public ModelAndView removeCategory(@PathVariable("categoryId") Long categoryId_p,
						   HttpServletResponse httpResponse_p) {
		menuService_i.deleteCategory( categoryId_p );
		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, CATEGORY_FIELD, null);
	}	
	@RequestMapping(value = "/delete/product/{productId}", method = RequestMethod.DELETE)
	public ModelAndView removeProduct(@PathVariable("productId") Long productId_p,
								   HttpServletResponse httpResponse_p) {
		menuService_i.deleteProduct  (productId_p);
		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, PRODUCT_FIELD, null);
	}
	public void setJsonView(View view) {
		jsonView_i = view;
	}
	private ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(jsonView_i, ERROR_FIELD, sMessage);
	}
}
