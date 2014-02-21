package com.onsalenext.base.web.model.menu;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.onsalenext.base.web.model.item.ItemBom;

@XmlRootElement(name = "saleItem")
public class SaleItemBom {
	
	List <ItemBom> itemsSale;
	
	public SaleItemBom ( List<ItemBom> itemsSale ){
	
		this.itemsSale = itemsSale;
	}

	public List<ItemBom> getItemsSale() {
		return itemsSale;
	}

	public void setItemsSale(List<ItemBom> itemsSale) {
		this.itemsSale = itemsSale;
	}
}
