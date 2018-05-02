package com.niit.Musicano.Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MusicanoBackEnd.dao.BillingDao;
import com.niit.MusicanoBackEnd.dao.OrderDao;
import com.niit.MusicanoBackEnd.dao.ShippingDao;
import com.niit.MusicanoBackEnd.dao.UserDao;
import com.niit.MusicanoBackEnd.model.Billing;
import com.niit.MusicanoBackEnd.model.Order;
import com.niit.MusicanoBackEnd.model.Shipping;
import com.niit.MusicanoBackEnd.model.User;

public class OrderTest 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Order ord=(Order)ctx.getBean("order");
		OrderDao ordDao=(OrderDao)ctx.getBean("orderDao");
		Billing bill=(Billing)ctx.getBean("billing");
		BillingDao billDao=(BillingDao)ctx.getBean("billingDao");
		Shipping shp=(Shipping)ctx.getBean("shipping");
		ShippingDao shpDao=(ShippingDao)ctx.getBean("shippingDao");
		User us=(User)ctx.getBean("user");
		UserDao userDao=(UserDao)ctx.getBean("userDao");
		
		ord.setOrderId("O101");
		ord.setOrderDate("30-04-2018");
		ord.setOrderTime("10:33");
		ord.setGrandtotal(399.91);
		bill=billDao.getBilling("B101");
		ord.setBilling(bill);
		shp=shpDao.getShipping("SP101");
		ord.setShipping(shp);
		us=userDao.getUser("U101");
		ord.setUser(us);
		if(ordDao.saveorupdateOrd(ord)==true)
		{
			System.out.println("Order is added successfully");
		}
		else
		{
			System.out.println("Order Not Added");
		}
		ord.setOrderId("O102");
		ord.setOrderDate("29-4-2018");
		ord.setOrderTime("11:02");
		ord.setGrandtotal(200.19);
		bill=billDao.getBilling("B102");
		ord.setBilling(bill);
		shp=shpDao.getShipping("SP102");
		ord.setShipping(shp);
		us=userDao.getUser("U102");
		ord.setUser(us);
		if(ordDao.saveorupdateOrd(ord)==true)
		{
			System.out.println("Order is added successfully");
		}
		else
		{
			System.out.println("Order Not added");
		}
		ord=ordDao.getOrder("O102");
		if(ordDao.deleteOrd(ord)==true)
		{
			System.out.println("Order is Deleted");
		}
		else
		{
			System.out.println("Order Not Deleted");
		}
		ord=ordDao.getOrder("O101");
		if(ord==null)
		{
			System.out.println("Order is empty");
		}
		else
		{
			System.out.println("Order Info");
			System.out.println(ord.getOrderId());
			System.out.println(ord.getOrderDate());
			System.out.println(ord.getOrderTime());
			System.out.println(ord.getGrandtotal());
			System.out.println(ord.getBilling().getBillId());
			System.out.println(ord.getShipping().getShipId());
			System.out.println(ord.getUser().getUserId());
		}
		List<Order> clist=ordDao.list();
		for(Order o:clist)
		{
			System.out.println(o.getOrderId());
			System.out.println(o.getOrderDate());
			System.out.println(o.getOrderTime());
			System.out.println(o.getGrandtotal());
			System.out.println(o.getBilling().getBillId());
			System.out.println(o.getShipping().getShipId());
			System.out.println(o.getUser().getUserId());
		}
	}

}
