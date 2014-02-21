package com.onsalenext.base.test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import com.onsalenext.base.domain.lookup.AddressTypeLookup;
import com.onsalenext.base.domain.lookup.RoleTypeLookup;
import com.onsalenext.base.domain.lookup.StateTypeLookup;
import com.onsalenext.base.web.model.IpBom;
import com.onsalenext.base.web.model.item.ItemBom;
import com.onsalenext.base.web.model.person.AddressBom;
import com.onsalenext.base.web.model.person.CustomerBom;
import com.onsalenext.base.web.model.person.RegistryBom;
import com.onsalenext.base.web.model.person.RegistryDetailBom;
import com.onsalenext.base.web.model.person.SubscriptionBom;
import com.onsalenext.base.web.model.person.UserInfoBom;
import com.onsalenext.base.web.model.person.WishListBom;
import com.onsalenext.base.web.model.person.WishListDetailBom;

public class CreateUserTest {
	
	public CustomerBom createCustomer (ItemBom item ){
		return new CustomerBom ( null, "GT", "Nolimit", "1-225-525-6566", null, true,
				RoleTypeLookup.C, this.setWishList(item), this.createUserInfo(), this.setSubscription(),
				this.setRegistries(item), this.setAddtess(), this.setIps());
	}
	
	private Set <AddressBom> setAddtess (){
		Set <AddressBom> a = new HashSet <AddressBom> ();
		a.add(this.createAddress(AddressTypeLookup.B));
		a.add(this.createAddress(AddressTypeLookup.S));
		return a;
	}
	
	private Set <IpBom> setIps (){
		Set <IpBom> ip = new HashSet <IpBom> ();
		ip.add ( this.createIP() );
		ip.add ( this.createIP() );
		return ip;
	}

	private WishListBom setWishList (ItemBom item){
		Set<WishListDetailBom> rd = new HashSet <WishListDetailBom> ();
		for ( int i=0; i<4; i++ ) rd.add(this.setWishListDetail(item));
		return new WishListBom (null, rd);
	}
	
	private WishListDetailBom setWishListDetail (ItemBom item){
		return new WishListDetailBom ( null, item );
	}
	
	private Set<RegistryBom> setRegistries (ItemBom item){
		Set<RegistryBom> r = new HashSet <RegistryBom> ();
		String [] sb = {"Wedding", "HomeWarming"};
		for ( String s : sb) r.add(this.setRegistry(s, item));
		return r;
	}
	
	private RegistryBom setRegistry (String name, ItemBom item){
		Set<RegistryDetailBom> rd = new HashSet <RegistryDetailBom> ();
		for ( int i=0; i<4; i++ ) rd.add(this.setRegistryDetail(item));
		return new RegistryBom (null, "REG_" + new Random().nextInt(100000000), name, true, rd);
	}
	
	private RegistryDetailBom setRegistryDetail (ItemBom item){
		return new RegistryDetailBom ( null, item );
	}
	
	private SubscriptionBom setSubscription (){
		return new SubscriptionBom (null, true, true, true);
	}
	
	private IpBom createIP ( ){
		return new IpBom (null, "10.101.10.23", UUID.randomUUID().toString() );
	}

	private UserInfoBom createUserInfo (){
		return new UserInfoBom (null, "gtnolimit@gmail" + new Random().nextInt(20)+".com", "password" + new Random().nextInt(20));
	}
	
	private AddressBom createAddress ( AddressTypeLookup type ){
		return new AddressBom ( null, type, "30002 North Dr.", null, "Glenview", StateTypeLookup.IL, "60025", true);
	}
}
