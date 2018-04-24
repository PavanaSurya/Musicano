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
import com.niit.MusicanoBackEnd.dao.ProductDao;

@Transactional
@Repository
@EnableTransactionManagement
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;

	public ProductDaoImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean saveorupdatePro(Product product) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
	}

	@Override
	public boolean deletePro(Product product) {
		
		sessionFactory.getCurrentSession().delete(product);
		return true;
	}

	@Override
	public Product getProduct(String proId) {
		
		String s="From Product where proId='"+proId+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		List<Product> lcrt=(List<Product>)q.list();
		if(lcrt==null||lcrt.isEmpty())
		{
			System.out.println("Product list not found");
			return null;
		}
		else
		{
			System.out.println("Product list");
			return lcrt.get(0);
		}
	}

	@Override
	public List<Product> list() {
		List<Product> Products=(List<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return Products;
	}

}
