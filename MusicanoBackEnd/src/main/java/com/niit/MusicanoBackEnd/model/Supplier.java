package com.niit.MusicanoBackEnd.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Supplier {
	@Id
	private String supId;
	private String supName;
	private String addr;
	private String ph_no;
	@OneToMany(mappedBy="supplier")
	private List<Product> product;
	
	public Supplier()
	{
		this.supId="SUP"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public String getSupId() {
		return supId;
	}
	public void setSupId(String supId) {
		this.supId = supId;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String  getPh_no() {
		return ph_no; 
	}
	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}

}
