package com.niit.MusicanoFrontend.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MusicanoBackEnd.dao.CartDao;
import com.niit.MusicanoBackEnd.dao.CartItemsDao;
import com.niit.MusicanoBackEnd.dao.ProductDao;
import com.niit.MusicanoBackEnd.dao.UserDao;
import com.niit.MusicanoBackEnd.model.Cart;
import com.niit.MusicanoBackEnd.model.CartItems;
import com.niit.MusicanoBackEnd.model.Product;
import com.niit.MusicanoBackEnd.model.User;

@Controller
public class CartController {
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	@Autowired
	CartItems cartItems;
	@Autowired 
	CartItemsDao cartItemsDao;
	@RequestMapping("/addtocart/{proId}")
	public ModelAndView cart(@PathVariable("proId") String id, HttpSession session)
	{
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken))
		{
			String currusername=authentication.getName();
			User u=userDao.getEmail(currusername);
	
			if(u==null)
			{    
				//		int items=0;
				Product product1=productDao.getProduct(id);
				CartItems cartItem=new CartItems();
				cartItem.setCart(cart);
				cartItem.setProduct(product1);
				cartItem.setPrice(product1.getPrice());
				cartItemsDao.saveorupdateCarItems(cartItem);
				cart.setGrandtotal(cart.getGrandtotal()+product1.getPrice());
				cart.setTotalItems(cart.getTotalItems()+1);
				cartDao.saveorupdateCart(cart);
				session.setAttribute("items",cart.getTotalItems());
				session.setAttribute("gtotal",cart.getGrandtotal());
				return new ModelAndView("redirect:/");
			}
			else
			{
				cart=u.getCart();
//				ModelAndView mv= new ModelAndView();
//				Cart cart= new Cart();
//				mv.addObject("cart", cart);
				Product product1=productDao.getProduct(id);
				CartItems cartItem=new CartItems();
				cartItem.setCart(cart);
				cartItem.setProduct(product1);
				cartItem.setPrice(product1.getPrice());
				cartItemsDao.saveorupdateCarItems(cartItem);
				cart.setGrandtotal(cart.getGrandtotal()+product1.getPrice());
				cart.setTotalItems(cart.getTotalItems()+1);
				cartDao.saveorupdateCart(cart);
				session.setAttribute("items",cart.getTotalItems());
				session.setAttribute("gtotal",cart.getGrandtotal());
				return new ModelAndView("redirect:/");
			}
		}
		return new ModelAndView("redirect:/");
	}
	@RequestMapping(value="/checkout")
	public String viewcart(Model model,HttpSession session)
	{
		System.out.println(1223);
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken))
		{
			String currusername=authentication.getName();
			User u=userDao.getEmail(currusername);
			Cart cart= u.getCart();
			List<CartItems> cartItem=cartItemsDao.getlist(u.getCart().getCart_Id());
			if(cartItem==null||cartItem.isEmpty())
			{
				session.setAttribute("items",0);
				model.addAttribute("Grandtotal",0.0);
				model.addAttribute("msg","no items is added to cart");
				return "Cart1";
			}
			model.addAttribute("cartItems",cartItem);
			model.addAttribute("Grandtotal",cart.getGrandtotal());
			session.setAttribute("items",cart.getTotalItems());
			session.setAttribute("cartId", cart.getCart_Id());
			return "Cart1";
		}
		return "redirect:/";
	}
	@RequestMapping(value="/Remove/{Cartitem_Id}")
	public ModelAndView RemoveFromCart(@PathVariable("Cartitem_Id")String id)
	{
		ModelAndView mv= new ModelAndView("redirect:/checkout");
		cartItems= cartItemsDao.getCartItems(id);
		Cart c= cartItems.getCart();
		c.setGrandtotal(c.getGrandtotal()-cartItems.getPrice());
		c.setTotalItems(c.getTotalItems()-1);
		cartDao.saveorupdateCart(c);
		cartItemsDao.deleteCartItems(cartItems);
		return mv;
	}
	@RequestMapping(value="/RemoveAll")
	public String RemoveAllFromCart(Model model, HttpSession session)
	{
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken))
		{
			String currusername=authentication.getName();
			User u=userDao.getEmail(currusername);
			Cart c= cartDao.getCart(u.getCart().getCart_Id());
			List<CartItems> cartItem=cartItemsDao.getlist(u.getCart().getCart_Id());
			for(CartItems c1:cartItem)
			{
				//			cartItemsDao.get(c1.getCartitem_Id());
				cartItemsDao.deleteCartItems(c1);
			}
			c.setGrandtotal(0.0);
			c.setTotalItems(0);
			cartDao.saveorupdateCart(c);
			session.setAttribute("items", c.getTotalItems());
			return "redirect:/checkout";
		}
		else
		{
			return "redirect:/";
		}
	}
}

