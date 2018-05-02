package com.niit.MusicanoBackEnd.dao;

import java.util.List;

import com.niit.MusicanoBackEnd.model.Cart;

public interface CartDao 
{
	public boolean saveorupdateCart(Cart cart);
	public boolean deleteCart(Cart cart);
	public Cart getCart(String cart_Id);
	public List<Cart> list();
}
