package com.niit.Musicano.Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MusicanoBackEnd.dao.CartDao;
import com.niit.MusicanoBackEnd.dao.CartItemsDao;
import com.niit.MusicanoBackEnd.dao.ProductDao;
import com.niit.MusicanoBackEnd.model.Cart;
import com.niit.MusicanoBackEnd.model.CartItems;
import com.niit.MusicanoBackEnd.model.Product;

public class CartItemsTest {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		CartItems crti = (CartItems) ctx.getBean("cartItems");
		CartItemsDao crtiDao = (CartItemsDao) ctx.getBean("cartItemsDao");
		Cart crt = (Cart) ctx.getBean("cart");
		CartDao crtDao = (CartDao) ctx.getBean("cartDao");
		Product pro = (Product) ctx.getBean("product");
		ProductDao proDao = (ProductDao) ctx.getBean("productDao");

		crti.setCartItems_Id("CI101");
		crti.setPrice(29.01);
		crt = crtDao.getCart("C101");
		crti.setCart(crt);
		pro = proDao.getProduct("P101");
		crti.setProduct(pro);
		if (crtiDao.saveorupdateCarItems(crti) == true) {
			System.out.println("CartItems are added successfully");
		} else {
			System.out.println("CartItems Not Added");
		}

		crti.setCartItems_Id("CI102");
		crti.setPrice(30.19);

		crt = crtDao.getCart("C102");
		crti.setCart(crt);
		pro = proDao.getProduct("P102");
		crti.setProduct(pro);

		if (crtiDao.saveorupdateCarItems(crti) == true) {
			System.out.println("CartItems are added successfully");
		} else {
			System.out.println("CartItems Not added");
		}
		crti = crtiDao.getCartItems("CI102");
		if (crtiDao.deleteCartItems(crti) == true) {
			System.out.println("CartItems Deleted");
		} else {
			System.out.println("CartItems not deleted");
		}
		crti = crtiDao.getCartItems("CI101");
		if (crti == null) {
			System.out.println("CartItems is empty");
		} else {
			System.out.println("CartItems Info");
			System.out.println(crti.getCartItems_Id());
			System.out.println(crti.getPrice());
			System.out.println(crti.getCart().getCart_Id());
			System.out.println(crti.getProduct().getProId());
		}
		List<CartItems> clist = crtiDao.list();
		for (CartItems ci : clist) {
			System.out.println(ci.getCartItems_Id());
			System.out.println(ci.getPrice());
			System.out.println(ci.getCart().getCart_Id());
			System.out.println(ci.getProduct().getProId());
		}

	}

}
