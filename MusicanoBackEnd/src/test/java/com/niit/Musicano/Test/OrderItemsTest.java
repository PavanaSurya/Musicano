package com.niit.Musicano.Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MusicanoBackEnd.dao.OrderDao;
import com.niit.MusicanoBackEnd.dao.OrderItemsDao;
import com.niit.MusicanoBackEnd.model.Order;
import com.niit.MusicanoBackEnd.model.OrderItems;

public class OrderItemsTest 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		OrderItems ordi=(OrderItems)ctx.getBean("orderItems");
		OrderItemsDao ordiDao=(OrderItemsDao)ctx.getBean("orderItemsDao");
		Order ord=(Order)ctx.getBean("order");
		OrderDao ordDao=(OrderDao)ctx.getBean("orderDao");
		
		ordi.setOrderItem_Id("OI101");
		ordi.setProId("P01");
		ord=ordDao.getOrder("O101");
		ordi.setOrder(ord);
		if(ordiDao.saveorupdateOrditem(ordi)==true)
		{
			System.out.println("OrderItems are Added successfully");
		}
		else
		{
			System.out.println("OrderItems Not Added");
		}
		
		ordi.setOrderItem_Id("OI102");
		ordi.setProId("P02");
		ord=ordDao.getOrder("O102");
		ordi.setOrder(ord);
		if(ordiDao.saveorupdateOrditem(ordi)==true)
		{
			System.out.println("OrderItems are Added successfully");
		}
		else
		{
			System.out.println("OrderItems Not Added");
		}
		ordi=ordiDao.getOrderItems("OI102");
		if(ordiDao.deleteOrditem(ordi)==true)
		{
			System.out.println("OrderItems are Deleted");
		}
		else
		{
			System.out.println("OrderItems are not Deleted");
		}
		ordi=ordiDao.getOrderItems("OI101");
		if(ordi==null)
		{
			System.out.println("OrderItems are empty");
		}
		else
		{
			System.out.println("OrderItems Info");
			System.out.println(ordi.getOrderItem_Id());
			System.out.println(ordi.getProId());
			System.out.println(ordi.getOrder().getOrderId());
		}
		List<OrderItems> clist=ordiDao.list();
		for(OrderItems oi:clist)
		{
			System.out.println(oi.getOrderItem_Id());
			System.out.println(oi.getProId());
			System.out.println(oi.getOrder().getOrderId());
		}
		
	}

}
