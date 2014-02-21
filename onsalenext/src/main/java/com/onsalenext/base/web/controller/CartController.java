package com.onsalenext.base.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
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

import com.onsalenext.base.service.CartService;
import com.onsalenext.base.service.impl.CartServiceImpl;
import com.onsalenext.base.web.model.order.CartBom;

@Controller
@RequestMapping("/cart")
public class CartController {

	
	@Autowired
	private View jsonView_i;

	@Autowired
	private CartServiceImpl cartService_i;
	
	private static final String CART_FIELD = "cart";
	private static final String ERROR_FIELD = "error";
	
	 private static final Logger log = Logger.getLogger(CartController.class);
	 @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	 public ModelAndView getCart(@PathVariable("cartId") String cartId) {
	  CartBom cart = null;

	  /* validate student Id parameter */
	  if (isEmpty(cartId) || cartId.length() < 0) {
	   String sMessage = "Error invoking getCart - Invalid cart Id parameter";
	   return getErrorJSON(sMessage);
	  }

	  try {
	System.out.println("about to run getCart from controller");
	   cart = cartService_i.get(new Long(cartId));
	System.out.println("got getCart from controller");
	  } catch (Exception e) {
	   String sMessage = "Error invoking getCart. [%1$s]";
	   return getErrorJSON(String.format(sMessage, e.toString()));
	  }
	  if ( cart == null ){
			 String sMessage = "Error invoking getCart - Cart is Empty. [%1$s]";
			 return getErrorJSON(sMessage);
		 }
	  log.debug("Returing Cart: " + cart.toString());
	  return new ModelAndView(jsonView_i, CART_FIELD, cart);
	 }
	 
		 
	@RequestMapping(value = { "/find/session/{session}" }, method = { RequestMethod.GET })
	public ModelAndView findCartBySession(@PathVariable("session") String session,
				   HttpServletResponse httpResponse_p) {
		CartBom cart;
		try {
			cart = cartService_i.findCartBySession( session );
		} catch (Exception e) {
			String sMessage = "Error findCartBySession. [%1$s]";
			return getErrorJSON(String.format(sMessage, e.toString()));
		}
		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, CART_FIELD, cart);
	}

	 @RequestMapping(value = { "/find/ip/{ip}" }, method = { RequestMethod.GET })
		public ModelAndView findCartByIp(@PathVariable("ip") String ip,
					   HttpServletResponse httpResponse_p) {
			CartBom cart;
			try {
				cart = cartService_i.findCartByIp( ip );
			} catch (Exception e) {
				String sMessage = "Error findCartByIp. [%1$s]";
				return getErrorJSON(String.format(sMessage, e.toString()));
			}
			httpResponse_p.setStatus(HttpStatus.OK.value());
			return new ModelAndView(jsonView_i, CART_FIELD, cart);
		}


		@RequestMapping(value = { "/find/customer/{customerId}" }, method = { RequestMethod.GET })
		public ModelAndView findCartByCustomer(@PathVariable("customerId") String customerId,
					   HttpServletResponse httpResponse_p) {
			CartBom cart;
			try {
				Long id = Long.parseLong(customerId);
				cart = cartService_i.findCartByCustomerId ( id );
			} catch (Exception e) {
				String sMessage = "Error findCartByCustomer. [%1$s]";
				return getErrorJSON(String.format(sMessage, e.toString()));
			}

			httpResponse_p.setStatus(HttpStatus.OK.value());
			return new ModelAndView(jsonView_i, CART_FIELD, cart );
		}

		@RequestMapping(value = { "/add/" }, method = { RequestMethod.POST })
		public ModelAndView createCart(@RequestBody CartBom cart_p,
				HttpServletResponse httpResponse_p, WebRequest request_p) {
			Long createCartId;
			try {
				createCartId = (long) cartService_i.add ( cart_p );
				cart_p.setId( createCartId );
			} catch (Exception e) {
				String sMessage = "Error createCart. [%1$s]";
				return getErrorJSON(String.format(sMessage, e.toString()));
			}
			httpResponse_p.setStatus(HttpStatus.CREATED.value());
			httpResponse_p.setHeader("cart", request_p.getContextPath() + "/cart/" + createCartId);
			return new ModelAndView(jsonView_i, CART_FIELD, cart_p );
		}
		
		@RequestMapping(value = "/delete/{cartId}", method = RequestMethod.DELETE)
		public ModelAndView removeCart(@PathVariable("cartId") String cartId_p,
									   HttpServletResponse httpResponse_p) {
			try {
				Long id = Long.parseLong(cartId_p);
				cartService_i.delete( id);
			} catch (Exception e) {
				String sMessage = "Error invoking removeCart. [%1$s]";
				return getErrorJSON(String.format(sMessage, e.toString()));
			}
			httpResponse_p.setStatus(HttpStatus.OK.value());
			return new ModelAndView(jsonView_i, CART_FIELD, null);
		}
	 
	 public static boolean isEmpty(String id) {
		  return (null == id) || id.trim().length() == 0;
		 }

	 private ModelAndView getErrorJSON(String sMessage) {
	  return new ModelAndView(jsonView_i, ERROR_FIELD, sMessage);
	 }
	 public void setCartService(CartService cartService_p) {
	  cartService_i = (CartServiceImpl) cartService_p;
	 }
}
