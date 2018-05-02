package com.niit.MusicanoBackEnd.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart 
{
	@Id
	private String cart_Id;
	private double grandtotal=0.0;
	private int totalItems=0;
	@OneToMany(mappedBy="cart")
	private List<CartItems> cartItems;
	
	
	public List<CartItems> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}
	public String getCart_Id() {
		return cart_Id;
	}
	public void setCart_Id(String cart_Id) {
		this.cart_Id = cart_Id;
	}
	public double getGrandtotal() {
		return grandtotal;
	}
	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

}
