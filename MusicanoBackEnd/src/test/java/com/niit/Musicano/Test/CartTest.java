package com.niit.Musicano.Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MusicanoBackEnd.dao.CartDao;
import com.niit.MusicanoBackEnd.dao.CartItemsDao;
import com.niit.MusicanoBackEnd.model.Cart;
import com.niit.MusicanoBackEnd.model.CartItems;

public class CartTest 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Cart crt=(Cart)ctx.getBean("cart");
		CartDao crtDao=(CartDao)ctx.getBean("cartDao");
		//CartItems crti=(CartItems)ctx.getBean("cartItems");
		//CartItemsDao crtiDao=(CartItemsDao)ctx.getBean("cartItemsDao");
		crt.setCart_Id("C101");
		crt.setGrandtotal(0.0);
		crt.setTotalItems(0);
		
		if(crtDao.saveorupdateCart(crt)==true)
		{
			System.out.println("Cart is Added Successfully");
		}
		else
		{
			System.out.println("Cart Not Added");
		}
		crt.setCart_Id("C102");
		crt.setGrandtotal(0.1);
		crt.setTotalItems(2);
		if(crtDao.saveorupdateCart(crt)==true)
		{
			System.out.println("Cart is Added Successfully");
		}
		else
		{
			System.out.println("Cart Not Added");
		}
		crt=crtDao.getCart("C102");
		if(crtDao.deleteCart(crt)==true)
		{
			System.out.println("Cart Deleted");
		}
		else
		{
			System.out.println("Cart Not Deleted");
		}
		crt=crtDao.getCart("C101");
		if(crt==null)
		{
			System.out.println("Cart is empty");
		}
		else
		{
			System.out.println("Cart Info");
			System.out.println(crt.getCart_Id());
			System.out.println(crt.getGrandtotal());
			System.out.println(crt.getTotalItems());
		}
		List<Cart> clist=crtDao.list();
		for(Cart cr:clist)
		{
			System.out.println(cr.getCart_Id());
			System.out.println(cr.getGrandtotal());
			System.out.println(cr.getTotalItems());
		}
		
	}

}
