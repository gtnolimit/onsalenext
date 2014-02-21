package com.onsalenext.base.dao;

import java.util.List;

import com.onsalenext.base.domain.item.Item;

public interface ItemDao {
	
	public Long add ( Item item );	
	public void edit ( Item item );	
	public void delete ( Item item );
	public void delete ( Long id );	
	public List<Item> getAll ();
	public List<Item> getItemsSale ( Long storeId );
	public List<Item> getItemsOver250 ( Long storeId );
	public List<Item> getItems250_100 ( Long storeId );
	public List<Item> getItems100_50 ( Long storeId );
	public List<Item> getItems50_20 ( Long storeId );
	public List<Item> getItems20_10 ( Long storeId );
	public List<Item> getItems10_5 ( Long storeId );
	public List<Item> getItemsBelow5 ( Long storeId );
	public List<Item> getItemsFreeShipping ( Long storeId );
	public List<Item> getItemsSaleEmail ( Long storeId );
	public List<Item> getItemsClerance ( Long storeId );
	public Item get ( Long id );

}
