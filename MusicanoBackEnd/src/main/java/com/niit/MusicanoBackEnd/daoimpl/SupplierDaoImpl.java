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
import com.niit.MusicanoBackEnd.model.Supplier;
import com.niit.MusicanoBackEnd.dao.SupplierDao;

@Transactional
@Repository("supplierDao")
@EnableTransactionManagement
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	SessionFactory sessionFactory;

	public SupplierDaoImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean saveorupdateSup(Supplier supplier) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;
	}

	@Override
	public boolean deleteSup(Supplier supplier) {
		
		sessionFactory.getCurrentSession().delete(supplier);
		return true;
	}

	@Override
	public Supplier getSupplier(String supId) {
		
		String s="From Supplier where supId='"+supId+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		List<Supplier> lcrt=(List<Supplier>)q.list();
		if(lcrt==null||lcrt.isEmpty())
		{
			System.out.println("Supplier list not found");
			return null;
		}
		else
		{
			System.out.println("Supplier list");
			return lcrt.get(0);
		}
	}

	@Override
	public List<Supplier> list() {
		
		List<Supplier> Suppliers=(List<Supplier>)sessionFactory.getCurrentSession().createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return Suppliers;
	}
	

}
