package com.niit.MusicanoBackEnd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class OrderItems 
{
	@Id
	private String orderItem_Id;
	private String proId;
	@ManyToOne
	@JoinColumn(name="orderId")
	private Order order;
	
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getOrderItem_Id() {
		return orderItem_Id;
	}
	public void setOrderItem_Id(String orderItem_Id) {
		this.orderItem_Id = orderItem_Id;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}	

}
