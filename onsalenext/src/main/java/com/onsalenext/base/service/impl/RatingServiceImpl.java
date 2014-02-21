package com.onsalenext.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.dao.RatingDao;
import com.onsalenext.base.service.RatingService;
import com.onsalenext.base.service.converter.RatingConvert;
import com.onsalenext.base.web.model.item.RatingBom;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingDao ratingDao;
	@Autowired RatingConvert ratingConvert;
	
	public Long add ( RatingBom o ) {
		return ratingDao.add ( ratingConvert.convert ( o, "ADD" ) );
	}

	public void edit ( RatingBom o ) {
		ratingDao.edit ( ratingConvert.convert ( o, "EDIT" ) );
	}

	public void delete ( RatingBom o ) {
		this.edit ( o );
	}

	public void delete(Long id) {
		this.edit ( this.get ( id ) );
	}

	public List<RatingBom> getAll() {
		return ratingConvert.convert ( ratingDao.getAll() );
	}

	public RatingBom get(Long id) {
		return ratingConvert.convert ( ratingDao.get ( id ) );
	}
}
