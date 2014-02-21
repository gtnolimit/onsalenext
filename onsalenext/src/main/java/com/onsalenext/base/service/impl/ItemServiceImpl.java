package com.onsalenext.base.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.dao.ItemDao;
import com.onsalenext.base.dao.MenuDao;
import com.onsalenext.base.domain.item.Brand;
import com.onsalenext.base.domain.item.Item;
import com.onsalenext.base.domain.menu.Category;
import com.onsalenext.base.domain.menu.Product;
import com.onsalenext.base.service.BrandService;
import com.onsalenext.base.service.ColorService;
import com.onsalenext.base.service.ItemService;
import com.onsalenext.base.service.RatingService;
import com.onsalenext.base.service.SizeService;
import com.onsalenext.base.service.TagService;
import com.onsalenext.base.service.converter.ItemConvert;
import com.onsalenext.base.web.model.item.ItemBom;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private ItemConvert itemConvert;
	
	@Autowired
	private BrandService brandService;
	@Autowired
	private RatingService ratingService;
		@Autowired
	private ColorService colorService;
	@Autowired
	private SizeService sizeService;
	@Autowired
	private TagService tagService;
	
	//TODO revise latter
	public Long add ( ItemBom o, Long productId ) {
		// insert Item and add to Product
		Long id = itemDao.add ( itemConvert.convert ( o, "ADD" ));
		Item item = itemDao.get ( id );
		Product prod = menuDao.getProduct ( productId );
		Set <Item> items = prod.getItems ();
		items.add ( item );
		prod.setItems ( items );
		menuDao.edit ( prod );
		
		// checking if Brand exist for this category and if not add to the category
		Set<Brand> brands_p = item.getBrands ();
		Category category = menuDao.getCategoryByProduct ( productId );
		Set<Brand> brands = category.getBrands (); 
		boolean notFound = true;
		for ( Brand b : brands_p ){
			for ( Brand b_p : brands ) if ( b_p.getAttribute().equals ( b.getAttribute () )) notFound = false;
			if ( notFound ) brands.add ( b );
		}
		category.setBrands ( brands );
		menuDao.edit ( category );
		return id;
	}
	
	public Long add(ItemBom o) {
		return itemDao.add(  itemConvert.convert(o, "ADD"));
	}

	public void edit(ItemBom o ) {
		itemDao.edit( itemConvert.convert(o, null));
	}

	public void delete(ItemBom o) {
		itemDao.delete(  itemConvert.convert(o, null));
	}

	public void delete(Long id) {
		itemDao.delete(id);
	}

	public List<ItemBom> getAll() {
		return itemConvert.convert ( itemDao.getAll() );
	}

	public ItemBom get(Long id) {
			return  itemConvert.convert(itemDao.get(id), "FULL" );
	}
	
	public List<ItemBom> getPromoItemsSale ( Long storeId ) {
		return itemConvert.convert ( itemDao.getItemsSale ( storeId ));
	}

	public List<ItemBom> getItemsOver250(Long storeId) {
		return itemConvert.convert ( itemDao.getItemsOver250 ( storeId ) );
	}

	public List<ItemBom> getItems250_100(Long storeId) {
		return itemConvert.convert ( itemDao.getItems250_100 ( storeId ) );	}

	public List<ItemBom> getItems100_50(Long storeId) {
		return itemConvert.convert ( itemDao.getItems100_50 ( storeId ) );	}

	public List<ItemBom> getItems50_20(Long storeId) {
		return itemConvert.convert ( itemDao.getItems50_20 ( storeId ) );
	}

	public List<ItemBom> getItems20_10(Long storeId) {
		return itemConvert.convert ( itemDao.getItems20_10 ( storeId ) );
	}

	public List<ItemBom> getItems10_5(Long storeId) {
		return itemConvert.convert ( itemDao.getItems10_5 ( storeId ) );
	}

	public List<ItemBom> getItemsBelow5(Long storeId) {
		return itemConvert.convert ( itemDao.getItemsBelow5 ( storeId ) );
	}

	public List<ItemBom> getItemsFreeShipping(Long storeId) {
		return itemConvert.convert ( itemDao.getItemsFreeShipping ( storeId ) );
	}

	public List<ItemBom> getItemsSaleEmail(Long storeId) {
		return itemConvert.convert ( itemDao.getItemsSaleEmail ( storeId ) );
	}

	public List<ItemBom> getItemsClerance(Long storeId) {
		return itemConvert.convert ( itemDao.getItemsClerance ( storeId ) );
	}

}
