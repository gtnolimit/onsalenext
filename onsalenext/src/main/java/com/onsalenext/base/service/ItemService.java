package com.onsalenext.base.service;

import java.util.List;

import com.onsalenext.base.web.model.item.ItemBom;

public interface ItemService {

	public Long add ( ItemBom item, Long productId );
	public Long add ( ItemBom item );	
	public void edit ( ItemBom item );	
	public void delete ( ItemBom item );
	public void delete ( Long id );	
	public List<ItemBom> getAll ();
	public ItemBom get ( Long id );
	
	public List<ItemBom> getPromoItemsSale ( Long storeId );
	public List<ItemBom> getItemsOver250 ( Long storeId );
	public List<ItemBom> getItems250_100 ( Long storeId );
	public List<ItemBom> getItems100_50 ( Long storeId );
	public List<ItemBom> getItems50_20 ( Long storeId );
	public List<ItemBom> getItems20_10 ( Long storeId );
	public List<ItemBom> getItems10_5 ( Long storeId );
	public List<ItemBom> getItemsBelow5 ( Long storeId );
	public List<ItemBom> getItemsFreeShipping ( Long storeId );
	public List<ItemBom> getItemsSaleEmail ( Long storeId );
	public List<ItemBom> getItemsClerance ( Long storeId );
}
