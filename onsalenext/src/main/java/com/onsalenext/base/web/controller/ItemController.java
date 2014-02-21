package com.onsalenext.base.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.onsalenext.base.service.ItemService;
import com.onsalenext.base.web.model.item.ItemBom;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService_i;
	
	@Autowired
	private View jsonView_i;
	
	private static final String ITEM_FIELD = "item";
	private static final String ITEMS_FIELD = "items";
	private static final String ERROR_FIELD = "error";
	
	@RequestMapping(value = "/items/", method = RequestMethod.GET)
	public ModelAndView getItems() {
		return new ModelAndView(jsonView_i, ITEMS_FIELD, itemService_i.getAll());
	}
	
	@RequestMapping ( value = "/{itemId}", method = RequestMethod.GET )
	public ModelAndView getItem ( @PathVariable ( "itemId" ) Long itemId ) {
			return new ModelAndView ( jsonView_i, ITEM_FIELD, itemService_i.get ( itemId ) );
	}
 
	@RequestMapping(value = { "/add/" }, method = { RequestMethod.POST })
	public ModelAndView createItem(@RequestBody ItemBom item_p,
			HttpServletResponse httpResponse_p, WebRequest request_p) {

		Long createItemId;
		try {
			createItemId = (long) itemService_i.add ( item_p );
			item_p.setId( createItemId );
		} catch (Exception e) {
			String sMessage = "Error creating new category. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		httpResponse_p.setStatus(HttpStatus.CREATED.value());
		httpResponse_p.setHeader("item", request_p.getContextPath() + "/item/" + createItemId);
		return new ModelAndView(jsonView_i, ITEM_FIELD, item_p );
	}

	@RequestMapping(value = { "/update/{itemId}" }, method = { RequestMethod.PUT })
	public ModelAndView updateItem(@RequestBody ItemBom item_p, @PathVariable("itemId") String itemId_p,
								   HttpServletResponse httpResponse_p) {
		try {
			itemService_i.edit(item_p);
		} catch (Exception e) {
			String sMessage = "Error updating category. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, ITEM_FIELD, null);
	}

	@RequestMapping(value = "/delete/{itemId}", method = RequestMethod.DELETE)
	public ModelAndView removeItem(@PathVariable("itemId") String itemId_p,
								   HttpServletResponse httpResponse_p) {

		try {
			Long id = Long.parseLong(itemId_p);
			itemService_i.delete( id);
		} catch (Exception e) {
			String sMessage = "Error invoking getFunds. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, ITEM_FIELD, null);
	}	

	@RequestMapping(value = { "/find/id/{itemId}" }, method = { RequestMethod.GET })
	public ModelAndView findItemById(@PathVariable("itemId") String itemId,
				   HttpServletResponse httpResponse_p) {
		ItemBom item;
		try {
			Long id = Long.parseLong(itemId);
			item = itemService_i.get( id );
		} catch (Exception e) {
			String sMessage = "Error finding product. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, ITEM_FIELD, item);
	}
	
	public void setJsonView(View view) {
		jsonView_i = view;
	}
	
	private ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(jsonView_i, ERROR_FIELD, sMessage);
	}

}
