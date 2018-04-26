package com.niit.Musicano.Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MusicanoBackEnd.dao.ProductDao;
import com.niit.MusicanoBackEnd.model.Category;
import com.niit.MusicanoBackEnd.model.Product;

public class ProductTest 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Product pro=(Product)ctx.getBean("product");
		ProductDao proDao=(ProductDao)ctx.getBean("productDao");
		pro.setProId("P101");
		pro.setProName("Product1");
		pro.setProdescrptn("Productdescription1");
		pro.setQty(20);
		pro.setPrice(18.98);
		if(proDao.saveorupdatePro(pro)==true)
		{
			System.out.println("Product is added successfully");
		}
		else
		{
			System.out.println("Product Not Added");
		}
		pro.setProId("P102");
		pro.setProName("Product2");
		pro.setProdescrptn("Productdescription2");
		pro.setQty(10);
		pro.setPrice(20.19);
		if(proDao.saveorupdatePro(pro)==true)
		{
			System.out.println("Product is added successfully");
		}
		else
		{
			System.out.println("Product Not Added");
		}
		pro=proDao.getProduct("P102");
		if(proDao.deletePro(pro)==true)
		{
			System.out.println("Product Deleted");
		}
		else
		{
			System.out.println("Product Info");
			System.out.println(pro.getProId());
			System.out.println(pro.getProName());
			System.out.println(pro.getProdescrptn());
			System.out.println(pro.getQty());
			System.out.println(pro.getPrice());
		}
		List<Product> plist=proDao.list();
		for(Product p:plist)
		{
			System.out.println(p.getProId());
			System.out.println(p.getProName());
			System.out.println(p.getProdescrptn());
			System.out.println(p.getQty());
			System.out.println(p.getPrice());
		}
	}

}
