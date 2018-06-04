package com.niit.MusicanoFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MusicanoBackEnd.dao.CategoryDao;
import com.niit.MusicanoBackEnd.dao.ProductDao;
import com.niit.MusicanoBackEnd.model.Category;
import com.niit.MusicanoBackEnd.model.Product;

@Controller
public class HomeController {

	@Autowired
	Product product;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;
	
	
	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView mv= new ModelAndView("Homepg");
		List<Product>prolist=productDao.list();
		mv.addObject("products",prolist);
		return mv;
	}
	@RequestMapping("/admin")
	public String admin()
	{
		return "Admin";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping("/header")
	public String header()
	{
		return "Header";
	}
	
	@RequestMapping("/footer")
	public String footer()
	{
		return "Foot";
	}
	@RequestMapping("/fot")
	public String fot()
	{
		return "fot";
	}
	@RequestMapping("/shophere")
	public String shophere(Model model)
	{
		List<Category> catlist=categoryDao.list();
		model.addAttribute("categories", catlist);
		return "ShopHere";
	}
	
	@RequestMapping("/Cart1")
	public String Cart1()
	{
		return "Cart1";
	}
	@RequestMapping("/instruments")
	public String instruments()
	{
		return "Instruments";
	}
	@RequestMapping("/billship")
	public String billship()
	{
		return "BillShip";
	}
//	@RequestMapping("/payment")
//	public String payment()
//	{
//		return "Payment";
//	}
	@RequestMapping("/thankyou")
	public String thankyou()
	{
		return "Thankyou";
	}
	@RequestMapping("/aboutus")
	public String aboutus()
	{
		return"Aboutus";
	}
	@RequestMapping("/classicalinst/{catId}")
	public String classicalinst(Model model, @PathVariable("catId")String catId)
	{
		category=categoryDao.getCategory(catId);
		List<Product> prolist=categoryDao.getProductByCategory(category);
		model.addAttribute("products",prolist);
		List<Category> catlist=categoryDao.list();
		model.addAttribute("categories", catlist);
		return "ClassicalInstruments";
	}
	@RequestMapping("/electricalinst")
	public String electricalinst()
	{
		return "ElectricalInstruments";
	}
}
