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

public class UserTest 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		User us=(User)ctx.getBean("user");
		UserDao userDao=(UserDao)ctx.getBean("userDao");
		Billing bill=(Billing)ctx.getBean("billing");
		BillingDao billDao=(BillingDao)ctx.getBean("billingDao");
		Order ord=(Order)ctx.getBean("order");
		OrderDao ordDao=(OrderDao)ctx.getBean("orderDao");
		Shipping shp=(Shipping)ctx.getBean("shipping");
		ShippingDao shpDao=(ShippingDao)ctx.getBean("shippingDao");
		us.setUserId("U101");
		us.setUserName("Username1");
		us.setAddr("addr1");
		us.setPh_no("9388392223");
		us.setEmail_Id("adc@gmail.com");
		us.setPwd("abc");
		
		bill=billDao.getBilling("B101");
		us.setBilling(bill);
		ord=ordDao.getOrder("O101");
		us.setOrder(ord);
		
		if(userDao.saveorupdateUs(us)==true)
		{
			System.out.println("User is added successfully");
		}
		else
		{
			System.out.println("User Not Added");
		}
		us.setUserId("U102");
		us.setUserName("Username2");
		us.setAddr("addr2");
		us.setPh_no("8393987723");
		us.setEmail_Id("dca@gmail.com");
		us.setPwd("cba");
		bill=billDao.getBilling("B102");
		us.setBilling(bill);
		ord=ordDao.getOrder("O102");
		us.getOrder();
		if(userDao.saveorupdateUs(us)==true)
		{
			System.out.println("User is added successfully");
		}
		else
		{
			System.out.println("User Not Added");
		}
		us=userDao.getUser("U102");
		if(userDao.delete(us)==true)
		{
			System.out.println("User Deleted");
		}
		else
		{
			System.out.println("User Not Deleted");
		}
		us=userDao.getUser("U101");
		if(us==null)
		{
			System.out.println("User is empty");
		}
		else
		{
			System.out.println("User Info");
			System.out.println(us.getUserId());
			System.out.println(us.getUserName());
			System.out.println(us.getAddr());
			System.out.println(us.getPh_no());
			System.out.println(us.getPwd());
			System.out.println(us.getBilling().getBillId());
			System.out.println(us.getOrder().getOrderId());
			
			
		}
		List<User> ulist=userDao.list();
		for(User u:ulist)
		{
			System.out.println(u.getUserId());
			System.out.println(u.getUserName());
			System.out.println(u.getAddr());
			System.out.println(u.getPh_no());
			System.out.println(u.getEmail_Id());
			System.out.println(u.getPwd());
			System.out.println(u.getBilling().getBillId());
			System.out.println(u.getOrder().getOrderId());
		}
	}

}
