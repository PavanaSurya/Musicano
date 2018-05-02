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
public class Product {
	@Id
	private String proId;
	private String proName;
	private String prodescrptn;
	private int qty;
	private double price;
	@ManyToOne
	@JoinColumn(name="catId")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="supId")
	private Supplier supplier;
	
	@OneToOne
	@JoinColumn(name="cartItems_Id")
	private CartItems cartItems;
	
	
	public CartItems getCartItems() {
		return cartItems;
	}
	public void setCartItems(CartItems cartItems) {
		this.cartItems = cartItems;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProdescrptn() {
		return prodescrptn;
	}
	public void setProdescrptn(String prodescrptn) {
		this.prodescrptn = prodescrptn;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
 
}
