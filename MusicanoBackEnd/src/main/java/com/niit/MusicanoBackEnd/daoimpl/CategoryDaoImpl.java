package com.niit.MusicanoBackEnd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MusicanoBackEnd.model.Category;
import com.niit.MusicanoBackEnd.model.Product;
import com.niit.MusicanoBackEnd.dao.CategoryDao;

@Repository("categoryDao")
@Transactional
@EnableTransactionManagement

public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	SessionFactory sessionFactory;

	public CategoryDaoImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean saveorupdateCat(Category category) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
		
	}

	@Override
	public boolean deleteCat(Category category) {
		
		sessionFactory.getCurrentSession().delete(category);
		return true;
	}

	@Override
	public Category getCategory(String catId) {
		
		String s="From Category where catId='"+catId+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		List<Category> lcrt=(List<Category>)q.list();
		if(lcrt==null||lcrt.isEmpty())
		{
			System.out.println("Category list not found");
			return null;
		}
		else
		{
			System.out.println("Category list");
			return lcrt.get(0);
		}
	}

	@Override
	public List<Category> list() {
		
		List<Category> Categories=(List<Category>)sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return Categories;
	}
	
	public List<Product> getProductByCategory(Category category)
	{
		String category1=category.getCatId();
		String c1="from Product where catId='"+category1+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(c1);
		List<Product> list=(List<Product>) q1.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		else
		{
			return list;
		}
	}

}
