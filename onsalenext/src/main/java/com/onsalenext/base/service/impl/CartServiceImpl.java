package com.onsalenext.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.dao.CartDao;
import com.onsalenext.base.service.CartService;
import com.onsalenext.base.service.CustomerService;
import com.onsalenext.base.service.ItemService;
import com.onsalenext.base.service.converter.CartConvert;
import com.onsalenext.base.service.converter.IpConvert;
import com.onsalenext.base.service.converter.ItemConvert;
import com.onsalenext.base.service.converter.PictureConvert;
import com.onsalenext.base.web.model.order.CartBom;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CartConvert cartConvert;
	@Autowired
	private IpConvert ipService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private ItemConvert itemConvert;
	@Autowired
	private PictureConvert pictureService;

	public Long add(CartBom cart) {
		return cartDao.add(cartConvert.convert ( cart, "ADD"));
	}

	public void edit(CartBom cart) {
		cartDao.edit(cartConvert.convert ( cart, "EDIT"));
	}

	public void delete(CartBom cart) {
		cartDao.delete(cartConvert.convert ( cart, "EDIT"));
	}

	public void delete(Long id) {
		cartDao.delete(id);
	}

	public List<CartBom> getAll() {
		return cartConvert.convert ( cartDao.getAll() );
	}

	public CartBom get(Long id) {
		return cartConvert.convert ( cartDao.get(id));
	}

	public CartBom findCartByCustomerId(Long customerId) {
		return cartConvert.convert ( cartDao.findByCustomerId(customerId));
	}
	
	public CartBom findCartBySession(String session) {
		return cartConvert.convert ( cartDao.findBySession(session));
	}
	
	public CartBom findCartByIp(String ip) {
		return cartConvert.convert ( cartDao.findByIp(ip) );
	}
}
