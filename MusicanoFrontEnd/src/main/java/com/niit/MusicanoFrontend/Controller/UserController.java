package com.niit.MusicanoFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MusicanoBackEnd.dao.UserDao;
import com.niit.MusicanoBackEnd.model.Cart;
import com.niit.MusicanoBackEnd.model.User;

@Controller
public class UserController {
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	@RequestMapping("/User")
	public ModelAndView User()
	{
		ModelAndView mv=new ModelAndView("LoginandSignup");
		List<User> uslist=userDao.list();
		mv.addObject("user",new User());
		mv.addObject("users",uslist);
		return mv;
	}
	@RequestMapping("/addUser")
	public ModelAndView addus(@ModelAttribute("user")User user)
	{
		ModelAndView mv=new ModelAndView("redirect:/User");
		Cart c= new Cart();
		user.setCart(c);
		if(userDao.saveorupdateUs(user)==true)
		{
			mv.addObject("msg1","User added Successfully");
		}
		else
		{
			mv.addObject("msg1","User not added");
		}
		return mv;
	}
//	@RequestMapping("/editUser/{userId}")
//	public ModelAndView editus(@PathVariable("userId")String userId)
//	{
//		ModelAndView mv=new ModelAndView("user");
//		user=userDao.getUser(userId);
//		mv.addObject("user",user);
//		List<User>uslist=userDao.list();
//		mv.addObject("users",uslist);
//		return mv;
//	}

}
