package com.niit.MusicanoBackEnd.dao;

import java.util.List;

import com.niit.MusicanoBackEnd.model.OrderItems;

public interface OrderItemsDao 
{
	public boolean saveorupdateOrditem(OrderItems orderitems);
	public boolean deleteOrditem(OrderItems orderitems);
	public OrderItems getOrderItems(String orderItem_Id);
	public List<OrderItems> list();
}
