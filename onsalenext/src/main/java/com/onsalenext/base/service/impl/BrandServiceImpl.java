package com.onsalenext.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.dao.BrandDao;
import com.onsalenext.base.service.BrandService;
import com.onsalenext.base.service.converter.BrandConvert;
import com.onsalenext.base.service.converter.PictureConvert;
import com.onsalenext.base.web.model.item.BrandBom;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDao brandDao;
	@Autowired
	private PictureConvert pictureService;
	@Autowired
	private BrandConvert brandService;
	
	public Long add ( BrandBom brand ) {
		return brandDao.add ( brandService.convert ( brand, "ADD" ) );
	}

	public void edit ( BrandBom brand ) {
		brandDao.edit ( brandService.convert ( brand, "EDIT" ) );
	}

	public void delete ( BrandBom brand ) {
		brandDao.delete ( brandService.convert ( brand, "EDIT" ) );
	}

	public void delete ( Long id ) {
		brandDao.delete ( id );
	}

	public List<BrandBom> getAll () {
		return brandService.convert ( brandDao.getAll () );
	}

	public BrandBom get ( Long id ) {
		return brandService.convert ( brandDao.get ( id ));
	}

	public BrandBom findByName ( String name ) {
		return brandService.convert ( brandDao.findByName ( name ));
	}

	public List<BrandBom> getStoreBrand ( long storeId ) {
		return brandService.convert ( brandDao.getStoreBrand ( storeId ));
	}
}
