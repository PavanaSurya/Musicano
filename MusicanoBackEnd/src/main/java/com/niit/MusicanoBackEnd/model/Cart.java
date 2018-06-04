package com.niit.MusicanoBackEnd.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	public Cart()
	{
		this.cart_Id="CART"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@OneToMany(mappedBy="cart", fetch=FetchType.EAGER)
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
