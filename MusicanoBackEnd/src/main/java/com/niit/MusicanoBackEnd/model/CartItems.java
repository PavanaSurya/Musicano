package com.niit.MusicanoBackEnd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class CartItems 
{
	@Id
	private String cartItems_Id;
	private double price;
	
	@ManyToOne
	@JoinColumn(name="cart_Id")
	private Cart cart;
	
	@OneToOne
	@JoinColumn(name="proId")
	private Product product;
	
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public String getCartItems_Id() {
		return cartItems_Id;
	}
	public void setCartItems_Id(String cartItems_Id) {
		this.cartItems_Id = cartItems_Id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
