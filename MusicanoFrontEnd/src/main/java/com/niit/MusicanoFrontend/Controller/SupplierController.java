package com.niit.MusicanoFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MusicanoBackEnd.dao.SupplierDao;
import com.niit.MusicanoBackEnd.model.Supplier;

@Controller
public class SupplierController {
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDao supplierDao;
	@RequestMapping("/Supplier")
	public ModelAndView Supplier()
	{
		ModelAndView mv=new ModelAndView("Supplier");
		List<Supplier> suplist=supplierDao.list();
		mv.addObject("supplier",new Supplier());
		mv.addObject("suppliers",suplist);
		return mv;
	}
	@RequestMapping("/addSupplier")
	public ModelAndView addsup(@ModelAttribute("supplier")Supplier supplier)
	{
		ModelAndView mv=new ModelAndView("redirect:/Supplier");
		if(supplierDao.saveorupdateSup(supplier)==true)
		{
			mv.addObject("msg1","Supplier added Successfully");
		}
		else
		{
			mv.addObject("msg1","Supplier not Added");
		}
		return mv;
	}
	@RequestMapping("/editSupplier/{supId}")
	public ModelAndView editsup(@PathVariable("supId")String supId)
	{
		ModelAndView mv=new ModelAndView("Supplier");
		supplier=supplierDao.getSupplier(supId);
		mv.addObject("supplier",supplier);
		List<Supplier>suplist=supplierDao.list();
		mv.addObject("suppliers",suplist);
		return mv;
	}
	@RequestMapping("/deleteSupplier/{supId}")
	public ModelAndView deletesup(@PathVariable("supId")String supId)
	{
		ModelAndView mv=new ModelAndView("redirect:/Supplier");
		supplier=supplierDao.getSupplier(supId);
		mv.addObject("supplier",supplier);
		List<Supplier>suplist=supplierDao.list();
		mv.addObject("suppliers",suplist);
		if(supplierDao.deleteSup(supplier)==true)
		{
			mv.addObject("msg1", "Supplier Deleted");
		}
		else
		{
			mv.addObject("msg1", "Supplier Not Deleted");
		}
		return mv;
	}

}
