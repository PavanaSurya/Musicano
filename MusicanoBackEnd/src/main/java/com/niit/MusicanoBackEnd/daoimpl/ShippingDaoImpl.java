package com.niit.MusicanoBackEnd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MusicanoBackEnd.dao.ShippingDao;
import com.niit.MusicanoBackEnd.model.Shipping;

@Transactional
@Repository ("shippingDao")
@EnableTransactionManagement
public class ShippingDaoImpl implements ShippingDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public ShippingDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean saveorupdateShip(Shipping shipping) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(shipping);
		return true;
	}

	@Override
	public boolean deleteShip(Shipping shipping) {
		
		sessionFactory.getCurrentSession().delete(shipping);
		return true;
	}

	@Override
	public Shipping getShipping(String shipId) {
		
		String shp="From Shipping where shipId='"+shipId+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(shp);
		List<Shipping> lcrt=(List<Shipping>)q.list();
		if(lcrt==null||lcrt.isEmpty())
		{
			System.out.println("Shipping list not found");
			return null;
		}
		else
		{
			System.out.println("Shipping list");
			return lcrt.get(0);
		}
	}

	@Override
	public List<Shipping> list() {
		
		List<Shipping> Shippings=(List<Shipping>)sessionFactory.getCurrentSession().createCriteria(Shipping.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return Shippings;
	}

	@Override
	public List<Shipping> getaddbyuser(String userId) {
		// TODO Auto-generated method stub



		String s="From Shipping where userId='"+userId+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		List<Shipping> list=(List<Shipping>)q.list();
		if(list==null||list.isEmpty())
		{
			System.out.println("Shipping is Empty");
			
		}
		return list;
	}
	
}