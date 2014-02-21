package com.onsalenext.base.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.dao.TaxDao;
import com.onsalenext.base.domain.Tax;
import com.onsalenext.base.service.TaxService;
import com.onsalenext.base.service.converter.TaxConvert;
import com.onsalenext.base.web.model.TaxBom;

@Service
public class TaxServiceImpl implements TaxService {

	@Autowired
	private TaxDao taxDao;
	@Autowired
	private TaxConvert taxConvert;
	
	public Long add ( TaxBom tax ) {
		return taxDao.add ( taxConvert.convert ( tax, "ADD" ));
	}

	public void edit ( TaxBom tax ) {
		taxDao.edit ( taxConvert.convert ( tax, "EDIT" ));
	}

	public List<TaxBom> getAll() {
		List<Tax> o = taxDao.getAll();
		List<TaxBom> tb = new ArrayList <TaxBom> ();
		for ( Tax tax : o ) tb.add( taxConvert.convert (tax) );
		Collections.sort(tb);
		return tb;
	}

	public TaxBom get(Long id) {
		return taxConvert.convert(taxDao.get(id));
	}


}
