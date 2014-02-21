package com.onsalenext.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.dao.SearchDao;
import com.onsalenext.base.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchDao searchDao;
}
