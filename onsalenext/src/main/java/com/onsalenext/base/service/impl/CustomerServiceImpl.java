package com.onsalenext.base.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.dao.CustomerDao;
import com.onsalenext.base.service.CustomerService;
import com.onsalenext.base.service.ItemService;
import com.onsalenext.base.service.converter.CustomerConvert;
import com.onsalenext.base.web.model.person.CustomerBom;
import com.onsalenext.base.web.model.person.RegistryBom;
import com.onsalenext.base.web.model.person.RegistryDetailBom;
import com.onsalenext.base.web.model.person.WishListBom;
import com.onsalenext.base.web.model.person.WishListDetailBom;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private CustomerConvert customerConvert;
	@Autowired
	private ItemService itemService;

	public Long add(CustomerBom customer) {
		return customerDao.add(customerConvert.convert ( customer, "ADD" ));
	}

	public void add ( List <CustomerBom> customer ){
		for (  CustomerBom c : customer )
			this.add(c);
	}
	
	public void edit(CustomerBom customer) {
		customerDao.edit( customerConvert.convert ( customer, "EDIT" ));
	}

	public void delete(CustomerBom customer) {
		customerDao.delete(customerConvert.convert ( customer, "EDIT" ));
	}

	public void delete(Long id) {
		customerDao.delete (id);
	}

	public List <CustomerBom> getAll() {
		return customerConvert.convert ( customerDao.getAll () );
	}

	public CustomerBom get ( Long id ){
		return customerConvert.convert ( customerDao.get ( id ), "FULL" ); 
	}

	public void addItemToWishList ( Long customerId, Long itemId ) {
		CustomerBom customer = this.get( customerId );
		WishListBom wishList = customer.getWishList();
		Set <WishListDetailBom> wishListDetail = wishList.getWishListDetails();
		boolean doesNotExist = true;
		for ( WishListDetailBom w : wishListDetail ) if ( itemId.equals ( w.getItem().getId () ) ) doesNotExist = false;
		if ( doesNotExist ) wishListDetail.add( new WishListDetailBom ( null, itemService.get( itemId )) );
		this.edit ( customer );
	}

	public void addItemToRegstry ( Long customerId, String registryName, Long itemId ) {
		CustomerBom customer = this.get( customerId );
		Set <RegistryBom> registrySet = customer.getRegistries();
		for ( RegistryBom registry : registrySet ){
			if ( registryName.equals ( registry.getName() )){
				Set<RegistryDetailBom> registryDetail = registry.getRegisteryDetails();
				registryDetail.add( new RegistryDetailBom (null, itemService.get( itemId )));
			}
		}
		this.edit ( customer );
	}
}
