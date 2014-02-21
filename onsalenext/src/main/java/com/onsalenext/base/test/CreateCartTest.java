package com.onsalenext.base.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.onsalenext.base.web.model.IpBom;
import com.onsalenext.base.web.model.PictureBom;
import com.onsalenext.base.web.model.item.ItemBom;
import com.onsalenext.base.web.model.order.CartBom;
import com.onsalenext.base.web.model.order.CartDetailBom;
import com.onsalenext.base.web.model.person.CustomerBom;

public class CreateCartTest {
	
	public CreateCartTest () {}
	
	public CartBom createCart ( List<ItemBom> items, CustomerBom customer ){
		Set<CartDetailBom> detail = this.createCartDetails(items);
		return new CartBom ( null, this.calculateSubtotal (detail), this.countItem(detail), detail, 
				this.createIp (), customer);
	}

	private Set<CartDetailBom> createCartDetails ( List<ItemBom> items ){
		Set<CartDetailBom> cartDetails = new HashSet <CartDetailBom> ();
		int count = 0;
		for ( ItemBom i : items ){
			if ( count == 3 ) cartDetails.add( this.setCartDetail( i, 2 ));
			if ( count == 6 ) cartDetails.add( this.setCartDetail( i, 3 ));
			if ( count == 9 ) cartDetails.add( this.setCartDetail( i, 1 ));
			if ( count == 12 ) return cartDetails;
			count ++;
		}
		return cartDetails;
	}
	private CartDetailBom setCartDetail ( ItemBom item, int qty ){
		return new CartDetailBom ( null, item.getSalePrice(), qty, item.getSubject(), 
				this.setPictureMain( item.getPictures()), item);
	}
	private PictureBom setPictureMain ( Set<PictureBom> pics ){
		PictureBom pb = null;
		for ( PictureBom p : pics ){
			if ( p.isMain() ) pb = p;
		}
		return pb;
	}
  	private int countItem (Set<CartDetailBom> detail){
  		int count = 0;
  		for ( CartDetailBom c : detail) count += c.getQty();
		return count;
	}
	private double calculateSubtotal (Set<CartDetailBom> detail){
		double subTotal = 0.00;
		for ( CartDetailBom c : detail ){
			subTotal += c.getPrice() * c.getQty();
		}
		return subTotal;
	}
	private IpBom createIp (){
		return new IpBom (null, "11.101.20.22", UUID.randomUUID().toString() );
	}

}
