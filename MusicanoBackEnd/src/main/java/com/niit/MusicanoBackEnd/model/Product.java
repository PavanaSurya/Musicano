package com.niit.MusicanoBackEnd.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Product {
	
	private String proId;
	private String proName;
	private String prodescrptn;
	private int qty;
	private double price;
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
