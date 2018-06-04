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
import com.niit.MusicanoBackEnd.model.Category;

@Controller
public class CategoryController {
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	@RequestMapping("/Category")
	public ModelAndView Category()
	{
		ModelAndView mv=new ModelAndView("Category");
		List<Category> catlist=categoryDao.list();
		mv.addObject("category",new Category());
		mv.addObject("categories",catlist);
		return mv;
	}
	@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	public ModelAndView addcat(HttpServletRequest req,@RequestParam("pimg") MultipartFile file,@ModelAttribute("category")Category category)
	{
		ModelAndView mv=new ModelAndView("redirect:/Category");
		String filepath=req.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		category.setImageName(filename);
		if(categoryDao.saveorupdateCat(category)==true)
		{
			mv.addObject("msg1","Category added Successfully");
		}
		else
		{
			mv.addObject("msg1","Category not added");
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
	@RequestMapping("/editCategory/{catId}")
	public ModelAndView editcat(@PathVariable("catId")String catId)
	{
		ModelAndView mv=new ModelAndView("Category");
		category=categoryDao.getCategory(catId);
		mv.addObject("category",category);
		List<Category>catlist=categoryDao.list();
		mv.addObject("categories",catlist);
		return mv;
	}

	@RequestMapping("/deleteCategory/{catId}")
	public ModelAndView deletecat(@PathVariable("catId")String catId)
	{
		ModelAndView mv=new ModelAndView("redirect:/Category");
		category=categoryDao.getCategory(catId);
		List<Category>catlist=categoryDao.list();
		mv.addObject("categories",catlist);
		if(categoryDao.deleteCat(category)==true)
		{
			mv.addObject("msg1", "Category Deleted");
		}
		else
		{
			mv.addObject("msg1", "Category Not Deleted");
		}
		
		return mv;
	}

}
