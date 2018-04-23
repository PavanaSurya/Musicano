package com.niit.MusicanoBackEnd.dao;

import java.util.List;

import com.niit.MusicanoBackEnd.config.Category;

public interface CategoryDao {
	
	public boolean saveorupdateCat(Category category);
	public boolean deleteCat(Category category);
	public Category getCategory(String catId);
	public List<Category> list();
}
