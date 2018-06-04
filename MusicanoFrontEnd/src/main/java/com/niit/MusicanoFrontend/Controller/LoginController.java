package com.niit.MusicanoFrontend.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.MusicanoBackEnd.dao.UserDao;
import com.niit.MusicanoBackEnd.model.User;

@Controller
public class LoginController 
{
	@Autowired 
	User user;
	@Autowired 
	UserDao userDao;
	
	@RequestMapping("/Login")
	public String login(@RequestParam(value="error",required=false)String error,@RequestParam(value="logout",required=false)String logout,Model model, @ModelAttribute("user")User user)
	{
		model.addAttribute("user", user);
		if(error!=null)
		{
			model.addAttribute("error","Invalid username and password");
		}
		if(logout!=null)
		{
			model.addAttribute("logout", "Login successful");
		}
		return "LoginandSignup";
	}


@RequestMapping(value="/j_spring_security_check")
public String login(@RequestParam("j_username")String umail,@RequestParam("j_password")String pwd,HttpSession session, Model model)
{
	User u=userDao.isValid(umail,pwd);
	if(u==null)
	{
		model.addAttribute("msg","Invalid username and password");
		return "redirect:/";
	}
	else
	{
		session.setAttribute("user",u);
		session.setAttribute("name",u.getUserName());
		session.setAttribute("items",u.getCart().getTotalItems());
		return "redirect:/";
	}
}

@RequestMapping("/j_spring_security_logout")
public String logout(HttpServletRequest request,HttpSession session,Model model)
{
	session.invalidate();
	session=request.getSession(true);
	model.addAttribute("logout","Logged out successfully");
	return "redirect:/";
}
}