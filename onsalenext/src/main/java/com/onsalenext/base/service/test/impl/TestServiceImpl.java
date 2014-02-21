package com.onsalenext.base.service.test.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.lookup.StateTypeLookup;
import com.onsalenext.base.service.BrandService;
import com.onsalenext.base.service.CartService;
import com.onsalenext.base.service.ColorService;
import com.onsalenext.base.service.CustomerService;
import com.onsalenext.base.service.HomeService;
import com.onsalenext.base.service.ItemService;
import com.onsalenext.base.service.LookupTypeService;
import com.onsalenext.base.service.MenuService;
import com.onsalenext.base.service.OrderService;
import com.onsalenext.base.service.RatingService;
import com.onsalenext.base.service.SizeService;
import com.onsalenext.base.service.TagService;
import com.onsalenext.base.service.TaxService;
import com.onsalenext.base.service.test.TestService;
import com.onsalenext.base.test.CreateBrandTest;
import com.onsalenext.base.test.CreateCartTest;
import com.onsalenext.base.test.CreateColorTest;
import com.onsalenext.base.test.CreateItemTest;
import com.onsalenext.base.test.CreateOrderTest;
import com.onsalenext.base.test.CreateRatingTest;
import com.onsalenext.base.test.CreateSizeTest;
import com.onsalenext.base.test.CreateStoreTest;
import com.onsalenext.base.test.CreateTagTest;
import com.onsalenext.base.test.CreateTaxTest;
import com.onsalenext.base.test.CreateUserTest;
import com.onsalenext.base.web.model.TaxBom;
import com.onsalenext.base.web.model.item.BrandBom;
import com.onsalenext.base.web.model.item.ColorBom;
import com.onsalenext.base.web.model.item.RatingBom;
import com.onsalenext.base.web.model.item.SizeBom;
import com.onsalenext.base.web.model.item.TagBom;
import com.onsalenext.base.web.model.order.CartBom;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private HomeService homeService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private RatingService ratingService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private TagService tagService;
	@Autowired
	private TaxService taxService;
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private LookupTypeService lookupService;
	
	private CartBom cart;
	
	public void setBrands (){
		String [] br = {"Samsung","Apple","HP","Toshiba","Lenovo","Dell"};
		CreateBrandTest cbt = new CreateBrandTest ();
		for ( String brand: br){
			brandService.add( cbt.createBrand(brand));
		}
	}

	public Long setStore() {
		List<BrandBom> brands = brandService.getAll();
		return homeService.add(new CreateStoreTest ().createStore(brands, 
				itemService.get((long) 1), itemService.get((long) 2), 
				customerService.get( (long) 1),
				sizeService.getAll(), tagService.getAll(), ratingService.getAll(), colorService.getAll()));
	}

	public Long setCustomer() {
		return customerService.add( new CreateUserTest ().createCustomer(itemService.get((long) 2)) );
	}
	
	public void setItem (){
		itemService.add( new CreateItemTest ().createItem(null, brandService.get((long) 1), null, null,
				sizeService.getAll(), tagService.getAll(), ratingService.getAll(), colorService.getAll()) );
		itemService.add( new CreateItemTest ().createItem(null, brandService.get((long) 3), null, null,
				sizeService.getAll(), tagService.getAll(), ratingService.getAll(), colorService.getAll()) );
	}
	
	public void setColor (){
		Set<ColorBom> colors = new CreateColorTest ().createColors();
		for ( ColorBom c : colors ) colorService.add( c );
	}
	
	public void setRating (){
		Set<RatingBom> rs = new CreateRatingTest ().createRates();
		for ( RatingBom c : rs ) ratingService.add( c );
	}

	public void setSize() {
		Set<SizeBom> rs = new CreateSizeTest ().createSizes();
		for ( SizeBom c : rs ) sizeService.add( c );
	}

	public void setTag() {
		Set<TagBom> ts = new CreateTagTest ().createTags();
		for ( TagBom t : ts ) tagService.add( t );
	}

	public List<StateTypeLookup> getStateTypes() {
		return lookupService.getLookupTypeListOptions(StateTypeLookup.class, false);
	}

	public void setTax() {
		Set<TaxBom> ts = new CreateTaxTest ().setTaxes(this.getStateTypes());
		for ( TaxBom o : ts ) taxService.add( o );
	}

	public void createCart() {
		cart = new CreateCartTest ().createCart(itemService.getAll(), customerService.get( (long) 1));
		cartService.add( cart );
	}

	public void createOrder () {
		orderService.add(new CreateOrderTest().createOrder(cartService.get( (long) 1)));
	}

}
