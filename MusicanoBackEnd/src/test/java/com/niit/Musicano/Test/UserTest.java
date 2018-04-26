package com.niit.Musicano.Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MusicanoBackEnd.dao.UserDao;
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
		us.setUserId("U101");
		us.setUserName("Username1");
		us.setAddr("addr1");
		us.setPh_no(8378939923l);
		us.setEmail_Id("adc@gmail.com");
		us.setPwd("abc");
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
		us.setPh_no(7389398233l);
		us.setEmail_Id("dca@gmail.com");
		us.setPwd("cba");
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
			System.out.println("User Info");
			System.out.println(us.getUserId());
			System.out.println(us.getUserName());
			System.out.println(us.getAddr());
			System.out.println(us.getPh_no());
			System.out.println(us.getPwd());
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
		}
	}

}
