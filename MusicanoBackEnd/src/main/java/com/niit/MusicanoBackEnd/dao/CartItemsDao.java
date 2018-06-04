package com.niit.MusicanoBackEnd.dao;

import java.util.List;

import com.niit.MusicanoBackEnd.model.CartItems;

public interface CartItemsDao 
{
	public boolean saveorupdateCarItems(CartItems cartitems);
	public boolean deleteCartItems(CartItems cartitems);
	public CartItems getCartItems(String cartItems_Id);
	public List<CartItems> list();
	public List<CartItems> getlist(String cart_Id);

}
