package com.niit.Musicano.Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MusicanoBackEnd.dao.SupplierDao;
import com.niit.MusicanoBackEnd.model.Supplier;

public class SupplierTest 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Supplier sup=(Supplier)ctx.getBean("supplier");
		SupplierDao supDao=(SupplierDao)ctx.getBean("supplierDao");
		sup.setSupId("S101");
		sup.setSupName("Supplier1");
		sup.setAddr("addr1");
		sup.setPh_no("9393882637");
		if(supDao.saveorupdateSup(sup)==true)
		{
			System.out.println("Supplier is added successfully");
		}
		else
		{
			System.out.println("Supplier not added");
		}
		sup.setSupId("S102");
		sup.setSupName("Supplier2");
		sup.setAddr("addr1");
		sup.setPh_no("9383993833");
		if(supDao.saveorupdateSup(sup)==true)
		{
			System.out.println("Supplier is added successfully");
		}
		else
		{
			System.out.println("Supplier not added");
		}
		sup=supDao.getSupplier("S102");
		if(supDao.deleteSup(sup)==true)
		{
			System.out.println("Supplier Deleted");
		}
		else
		{
			System.out.println("Supplier Not Deleted");
		}
		sup=supDao.getSupplier("S101");
		if(sup==null)
		{
			System.out.println("Supplier is empty");
		}
		else
		{
			System.out.println("Supplier Info");
			System.out.println(sup.getSupId());
			System.out.println(sup.getSupName());
			System.out.println(sup.getAddr());
			System.out.println(sup.getPh_no());
		}
		List<Supplier> slist=supDao.list();
		for(Supplier s:slist)
		{
			System.out.println(s.getSupId());
			System.out.println(s.getSupName());
			System.out.println(s.getAddr());
			System.out.println(s.getPh_no());
		}
	}

}
