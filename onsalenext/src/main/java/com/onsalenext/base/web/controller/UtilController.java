package com.onsalenext.base.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.onsalenext.base.service.ColorService;
import com.onsalenext.base.service.RatingService;
import com.onsalenext.base.service.SizeService;
import com.onsalenext.base.service.TagService;

@Controller
@RequestMapping("/util")
public class UtilController {

	@Autowired
	private ColorService colorService_i;
	@Autowired
	private RatingService ratingService_i;
	@Autowired
	private SizeService sizeService_i;
	@Autowired
	private TagService tagService_i;
	
	private static final String COLORS_FIELD = "colors";
	private static final String RATINGS_FIELD = "ratings";
	private static final String SIZES_FIELD = "sizes";
	private static final String TAGS_FIELD = "tags";
	
	@Autowired
	private View jsonView_i;
	
	@RequestMapping(value = "/colors/", method = RequestMethod.GET)
	public ModelAndView getColors() {
		return new ModelAndView(jsonView_i, COLORS_FIELD, colorService_i.getAll());
	}
	
	@RequestMapping(value = "/ratings/", method = RequestMethod.GET)
	public ModelAndView getRatings() {
		return new ModelAndView(jsonView_i, RATINGS_FIELD, ratingService_i.getAll());
	}

	@RequestMapping(value = "/sizes/", method = RequestMethod.GET)
	public ModelAndView getSizes() {
		return new ModelAndView(jsonView_i, SIZES_FIELD, sizeService_i.getAll());
	}
	
	@RequestMapping(value = "/tags/", method = RequestMethod.GET)
	public ModelAndView getTags() {
		return new ModelAndView(jsonView_i, TAGS_FIELD, tagService_i.getAll());
	}

	public void setJsonView(View view) {
		jsonView_i = view;
	}

}
