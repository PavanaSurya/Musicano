package com.niit.MusicanoFrontend.Controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MusicanoBackEnd.dao.CategoryDao;
import com.niit.MusicanoBackEnd.dao.ProductDao;
import com.niit.MusicanoBackEnd.dao.SupplierDao;
import com.niit.MusicanoBackEnd.model.Category;
import com.niit.MusicanoBackEnd.model.Product;
import com.niit.MusicanoBackEnd.model.Supplier;

@Controller
public class ProductController {
	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping("/Product")
	public ModelAndView Product()
	{
		ModelAndView mv=new ModelAndView("Product");
		List<Product> prolist=productDao.list();
		List<Category> catlist=categoryDao.list();
		List<Supplier> suplist=supplierDao.list();
		mv.addObject("categories",catlist);
		mv.addObject("suppliers",suplist);
		mv.addObject("product",new Product());
		mv.addObject("products",prolist);
		return mv;
	}
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public ModelAndView addpro(HttpServletRequest req,@RequestParam("pimg") MultipartFile file, @ModelAttribute("product")Product product)
	{
		ModelAndView mv = new ModelAndView("redirect:/Product");
		String filepath=req.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		product.setImageName(filename);
		if(productDao.saveorupdatePro(product)==true)
		{
			mv.addObject("msg1","Product added Successfully");
		}
		else
		{
			mv.addObject("msg1","Product not added");
		}
		try
		{
			byte[] imagebyte=file.getBytes();
			BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream(filepath+"/Resources/"+filename));
			fos.write(imagebyte);
			fos.close();
		}
		catch(Exception e)
		{
			
		}
		return mv;
	}
	@RequestMapping("/editProduct/{proId}")
	public ModelAndView editpro(@PathVariable("proId")String proId)
	{
		ModelAndView mv=new ModelAndView("Product");
		product=productDao.getProduct(proId);
		mv.addObject("product",product);
		List<Product>prolist=productDao.list();
		List<Category> catlist=categoryDao.list();
		List<Supplier> suplist=supplierDao.list();
		mv.addObject("categories",catlist);
		mv.addObject("suppliers",suplist);
		mv.addObject("products",prolist);
		return mv;
	}
	@RequestMapping("/deleteProduct/{proId}")
	public ModelAndView deletepro(@PathVariable("proId") String proId)
	{
		ModelAndView mv=new ModelAndView("redirect:/Product");
		product=productDao.getProduct(proId);
		mv.addObject("product",product);
		List<Product>prolist=productDao.list();
		mv.addObject("products",prolist);
		List<Category> catlist=categoryDao.list();
		List<Supplier> suplist=supplierDao.list();
		mv.addObject("categories",catlist);
		mv.addObject("suppliers",suplist);
		
		if(productDao.deletePro(product)==true)
		{
			mv.addObject("msg1", "Product Deleted");
		}
		else
		{
			mv.addObject("msg1", "Product Not Deleted");
		}
		return mv;
	}
}
