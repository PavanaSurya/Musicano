package com.niit.MusicanoBackEnd.dao;

import java.util.List;

import com.niit.MusicanoBackEnd.config.Product;

public interface ProductDao {
	
	public boolean saveorupdatePro(Product product);
	public boolean deletePro(Product product);
	public Product getProduct(String proId);
	public List<Product> list();

}
