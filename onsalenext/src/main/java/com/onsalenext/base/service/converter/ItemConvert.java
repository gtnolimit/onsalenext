package com.onsalenext.base.service.converter;

import java.util.List;
import java.util.Set;

import com.onsalenext.base.domain.item.Item;
import com.onsalenext.base.web.model.item.ItemBom;

public interface ItemConvert {

	public ItemBom convert ( Item o, String type );
	public Item convert ( ItemBom o, String action );
	public Set<ItemBom> convert ( Set<Item> o );
	public Set<Item> convert ( Set<ItemBom> o, String action );
	public List<ItemBom> convert ( List<Item> o );
}
