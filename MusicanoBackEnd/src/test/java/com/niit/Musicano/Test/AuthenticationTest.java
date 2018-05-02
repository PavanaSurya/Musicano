package com.niit.Musicano.Test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MusicanoBackEnd.dao.AuthenticationDao;
import com.niit.MusicanoBackEnd.model.Authentication;

public class AuthenticationTest 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		Authentication auth=(Authentication)ctx.getBean("authentication");
		AuthenticationDao authDao=(AuthenticationDao)ctx.getBean("authenticationDao");
		auth.setRoleId("A101");
		auth.setRoleName("ROLE_NAME");
		auth.setUserName("Username1");
		if(authDao.saveorupdateAuth(auth)==true)
		{
			System.out.println("Authentication is added successfully");
		}
		else
		{
			System.out.println("Authentication Not Added");
		}
		auth.setRoleId("A102");
		auth.setRoleName("ROLE_NAME2");
		auth.setUserName("Username2");
		if(authDao.saveorupdateAuth(auth)==true)
		{
			System.out.println("Authentication is added successfully");
		}
		else
		{
			System.out.println("Authentication Not Added");
		}
		auth=authDao.getAuthentication("A102");
		if(authDao.deleteAuth(auth)==true)
		{
			System.out.println("Authentication Deleted");
		}
		else
		{
			System.out.println("Authenticatin Not Deleted");
		}
		auth=authDao.getAuthentication("A101");
		if(auth==null)
		{
			System.out.println("Authentication is empty");
		}
		else
		{
			System.out.println("Authentication Info");
			System.out.println(auth.getRoleId());
			System.out.println(auth.getRoleName());
			System.out.println(auth.getUserName());
		}
		List<Authentication> clist=authDao.list();
		for(Authentication a:clist)
		{
			System.out.println(a.getRoleId());
			System.out.println(a.getRoleName());
			System.out.println(a.getUserName());
		}
		
	}

}
