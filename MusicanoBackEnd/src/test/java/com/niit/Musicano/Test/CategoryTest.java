package com.niit.Musicano.Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MusicanoBackEnd.dao.CategoryDao;
import com.niit.MusicanoBackEnd.model.Category;

public class CategoryTest 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Category cat=(Category)ctx.getBean("category");
		CategoryDao catDao=(CategoryDao)ctx.getBean("categoryDao");
		cat.setCatId("C101");
		cat.setCatName("Category1");
		if(catDao.saveorupdateCat(cat)==true)
		{
			System.out.println("Category is added successfully");
		}
		else
		{
			System.out.println("Category Not Added");
		}
		cat.setCatId("C102");
		cat.setCatName("Category2");
		if(catDao.saveorupdateCat(cat)==true)
		{
			System.out.println("Category is add successfully");
		}
		else
		{
			System.out.println("Category Not Added");
		}
		cat=catDao.getCategory("C102");
		if(catDao.deleteCat(cat)==true)
		{
			System.out.println("Category Deleted");
		}
		else
		{
			System.out.println("Category Not Deleted");
		}
		cat=catDao.getCategory("C101");
		if(cat==null)
		{
			System.out.println("Category is empty");
		}
		else
		{
			System.out.println("Category Info");
			System.out.println(cat.getCatId());
			System.out.println(cat.getCatName());
		}
		List<Category> clist=catDao.list();
		for(Category c:clist)
		{
			System.out.println(c.getCatId());
			System.out.println(c.getCatName());
		}
	}
}
