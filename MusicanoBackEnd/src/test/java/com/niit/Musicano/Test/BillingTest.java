package com.niit.Musicano.Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MusicanoBackEnd.dao.BillingDao;
import com.niit.MusicanoBackEnd.dao.OrderDao;
import com.niit.MusicanoBackEnd.dao.UserDao;
import com.niit.MusicanoBackEnd.model.Billing;
import com.niit.MusicanoBackEnd.model.Order;
import com.niit.MusicanoBackEnd.model.User;

public class BillingTest 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Billing bill=(Billing)ctx.getBean("billing");
		BillingDao billDao=(BillingDao)ctx.getBean("billingDao");
		User us=(User)ctx.getBean("user");
		UserDao usDao=(UserDao)ctx.getBean("userDao");
		Order ord=(Order)ctx.getBean("order");
		OrderDao ordDao=(OrderDao)ctx.getBean("orderDao");
		bill.setBillId("B101");
		bill.setBillName("BillName1");
		bill.setAddr("addr1");
		bill.setPh_no("9387939282");
		bill.setCountry("India");
		
		us=usDao.getUser("U101");
		bill.setUser(us);
		ord=ordDao.getOrder("O101");
		bill.setOrder(ord);
		billDao.saveorupdateBill(bill);
		
		if(billDao.saveorupdateBill(bill)==true)
		{
			System.out.println("Billing is added successfully");
		}
		else
		{
			System.out.println("Billing Not Added");
		}
		bill.setBillId("B102");
		bill.setBillName("BillName2");
		bill.setAddr("addr2");
		bill.setPh_no("8393736363");
		bill.setCountry("Korea");
		
		us=usDao.getUser("U102");
		bill.setUser(us);
		ord=ordDao.getOrder("O102");
		bill.setOrder(ord);
		billDao.saveorupdateBill(bill);
		
		if(billDao.saveorupdateBill(bill)==true)
		{
			System.out.println("Billing is added successfully");
		}
		else
		{
			System.out.println("Billing Not Added");
		}
		bill=billDao.getBilling("B102");
		if(billDao.deleteBill(bill)==true)
		{
			System.out.println("Billing Deleted");
		}
		else
		{
			System.out.println("Billing Not Deleted");
		}
		bill=billDao.getBilling("B101");
		if(bill==null)
		{
			System.out.println("Billing is empty");
		}
		else
		{
			System.out.println("Billing Info");
			System.out.println(bill.getBillId());
			System.out.println(bill.getBillName());
			System.out.println(bill.getAddr());
			System.out.println(bill.getPh_no());
			System.out.println(bill.getCountry());
			System.out.println(bill.getUser().getUserId());
			System.out.println(bill.getOrder().getOrderId());
			
		}
		List<Billing> clist=billDao.list();
		for(Billing b:clist)
		{
			System.out.println(b.getBillId());
			System.out.println(b.getBillName());
			System.out.println(b.getAddr());
			System.out.println(b.getPh_no());
			System.out.println(b.getCountry());
			System.out.println(b.getUser().getUserId());
			System.out.println(b.getOrder().getOrderId());
		}
	}

}
