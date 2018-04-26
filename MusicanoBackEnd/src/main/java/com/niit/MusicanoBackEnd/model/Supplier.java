package com.niit.MusicanoBackEnd.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Supplier {
	
	private String supId;
	private String supName;
	private String addr;
	private long ph_no;
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
	public long  getPh_no() {
		return ph_no; 
	}
	public void setPh_no(long ph_no) {
		this.ph_no = ph_no;
	}

}
