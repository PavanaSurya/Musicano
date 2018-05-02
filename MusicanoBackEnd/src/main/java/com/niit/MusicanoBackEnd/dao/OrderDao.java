package com.niit.MusicanoBackEnd.dao;

import java.util.List;

import com.niit.MusicanoBackEnd.model.Order;

public interface OrderDao 
{
	public boolean saveorupdateOrd(Order order);
	public boolean deleteOrd(Order order);
	public Order getOrder(String orderId);
	public List<Order> list();

}
