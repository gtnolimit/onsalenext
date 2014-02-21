package com.onsalenext.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.dao.HomeDao;
import com.onsalenext.base.service.HomeService;
import com.onsalenext.base.service.MenuService;
import com.onsalenext.base.service.converter.IpConvert;
import com.onsalenext.base.service.converter.StoreConvert;
import com.onsalenext.base.web.model.StoreBom;

@Service
public class HomeServiceImpl implements HomeService{

	@Autowired
	private HomeDao homeDao;
	@Autowired
	private IpConvert ipConvert;
	@Autowired
	private MenuService menuService;
	@Autowired
	private StoreConvert storeConvert;

	public Long add(StoreBom store) {
		return homeDao.add( storeConvert.convert (store, "ADD"));
	}
	public void edit(StoreBom store) {
		homeDao.edit( storeConvert.convert (store, "EDIT" )); 
	}
	public void delete(StoreBom store) {
		homeDao.delete(storeConvert.convert (store, "EDIT" ));
	}
	public void delete(Long id) {
		homeDao.delete(id);
	}
	public List<StoreBom> getAll() {
		return storeConvert.convert ( homeDao.getAll() );
	}
	public StoreBom get(Long id) {
		return storeConvert.convert ( homeDao.get(id) );
	}
	public StoreBom getInfo(Long id) {
		return storeConvert.convert (homeDao.getInfo(id));
	}
	public List <StoreBom> getAllInfo (){
		return storeConvert.convert ( homeDao.getAllInfo () );
	}
	public StoreBom findByName ( String name ){
		return storeConvert.convert ( homeDao.findByName ( name ) );
	}
	public StoreBom findByNameInfo ( String name ){
		return storeConvert.convert ( homeDao.findByNameInfo ( name ) );
	}
	public StoreBom findByIp ( String ip ){
		return storeConvert.convert ( homeDao.findByIp ( ip ) );
	}
	public StoreBom findByIpInfo ( String ip ){
		return storeConvert.convert ( homeDao.findByIpInfo  (ip ) );
	}

}
