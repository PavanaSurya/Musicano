package com.niit.Musicano.Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.MusicanoBackEnd.dao.ShippingDao;
import com.niit.MusicanoBackEnd.dao.UserDao;
import com.niit.MusicanoBackEnd.model.Shipping;
import com.niit.MusicanoBackEnd.model.User;

public class ShippingTest 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Shipping shp=(Shipping)ctx.getBean("shipping");
		ShippingDao shpDao=(ShippingDao)ctx.getBean("shippingDao");
		User us=(User)ctx.getBean("user");
		UserDao userDao=(UserDao)ctx.getBean("userDao");
		shp.setShipId("SP101");
		shp.setShipName("SName1");
		shp.setAddr("Saddr1");
		shp.setPh_no("9383638983");
		shp.setCountry("India");
	
		us=userDao.getUser("U101");
		shp.setUser(us);
		if(shpDao.saveorupdateShip(shp)==true)
		{
			System.out.println("Shipping is Added successfully");
		}
		else
		{
			System.out.println("Shipping Not Added");
		}
		shp.setShipId("SP102");
		shp.setShipName("SName2");
		shp.setAddr("Saddr2");
		shp.setPh_no("8393728333");
		shp.setCountry("China");
	
		us=userDao.getUser("U102");
		shp.setUser(us);
		if(shpDao.saveorupdateShip(shp)==true)
		{
			System.out.println("Shipping is Added successfully");
		}
		else
		{
			System.out.println("Shipping Not Added");
		}
		shp=shpDao.getShipping("SP102");
		if(shpDao.deleteShip(shp)==true)
		{
			System.out.println("Shipping is Deleted");
		}
		else
		{
			System.out.println("Shipping is Not Deleted");
		}
		shp=shpDao.getShipping("SP101");
		if(shp==null)
		{
			System.out.println("Shipping is empty");
		}
		else
		{
			System.out.println("Shipping Info");
			System.out.println(shp.getShipId());
			System.out.println(shp.getShipName());
			System.out.println(shp.getAddr());
			System.out.println(shp.getPh_no());
			System.out.println(shp.getCountry());
			
			System.out.println(shp.getUser().getUserId());
		}
		List<Shipping> clist=shpDao.list();
		for(Shipping sp:clist)
		{
			System.out.println(sp.getShipId());
			System.out.println(sp.getShipName());
			System.out.println(sp.getAddr());
			System.out.println(sp.getPh_no());
			System.out.println(sp.getCountry());
		
			System.out.println(sp.getUser().getUserId());
		}
	}

}
