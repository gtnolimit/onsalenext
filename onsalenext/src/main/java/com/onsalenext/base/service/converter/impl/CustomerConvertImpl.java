package com.onsalenext.base.service.converter.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.person.Customer;
import com.onsalenext.base.service.converter.AddressConvert;
import com.onsalenext.base.service.converter.CustomerConvert;
import com.onsalenext.base.service.converter.IpConvert;
import com.onsalenext.base.service.converter.RegistryConvert;
import com.onsalenext.base.service.converter.SubscriptionConvert;
import com.onsalenext.base.service.converter.UserInfoConvert;
import com.onsalenext.base.service.converter.WishListConvert;
import com.onsalenext.base.web.model.person.CustomerBom;

@Service
public class CustomerConvertImpl implements CustomerConvert {

	@Autowired
	private IpConvert ipConvert;
	@Autowired
	private AddressConvert addressConvert;
	@Autowired
	private UserInfoConvert userInfoConvert;
	@Autowired
	private RegistryConvert registryConvert;
	@Autowired
	private WishListConvert wishListConvert;
	@Autowired
	private SubscriptionConvert subscriptionConvert;
	
	public List<CustomerBom> convert ( List <Customer> o ){
		List <CustomerBom> cs = new ArrayList <CustomerBom> ();
		for (Customer c : o) cs.add( this.convert ( c, "FULL" ));
		Collections.sort(cs);
		return cs;
	}

	public Customer convert ( CustomerBom o, String action ){
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD"))
			return new Customer ( o.getId(), o.getFirstName(), o.getLastName(), o.getPhone(), o.getDob(),
				o.isActive(), o.getRoleType(), 
				wishListConvert.convert (o.getWishList(), action),
				userInfoConvert.convert (o.getUserInfo(), action), 
				subscriptionConvert.convert (o.getSubscription(), action),
				registryConvert.convert ( o.getRegistries(), action), 
				addressConvert.convert ( o.getAddresses(), action ), 
				ipConvert.convert (o.getIps(), action), new Date (), new Date (), "admin");
		return new Customer ( o.getId(), o.getFirstName(), o.getLastName(), o.getPhone(), o.getDob(),
				o.isActive(), o.getRoleType(), 
				wishListConvert.convert (o.getWishList(), action),
				userInfoConvert.convert (o.getUserInfo(), action), 
				subscriptionConvert.convert (o.getSubscription(), action),
				registryConvert.convert ( o.getRegistries(), action), 
				addressConvert.convert ( o.getAddresses(), action ), 
				ipConvert.convert (o.getIps(), action), new Date (), "admin");
	}
	
	public CustomerBom convert ( Customer o, String action ){
		if ( o == null ) return null;
		if ( action.equals ( "FULL" ))
			return new CustomerBom ( o.getId(), o.getFirstName(), o.getLastName(), o.getPhone(), o.getDob(),
				o.isActive(), o.getRoleType(), 
				wishListConvert.convert (o.getWishList()),
				userInfoConvert.convert (o.getUserInfo()), 
				subscriptionConvert.convert (o.getSubscription()),
				registryConvert.convert ( o.getRegistries()), 
				addressConvert.convert ( o.getAddresses() ), 
				ipConvert.convert (o.getIps()) );
		return new CustomerBom ( o.getId(), o.getFirstName(), o.getLastName(), o.isActive() );
	}
}
