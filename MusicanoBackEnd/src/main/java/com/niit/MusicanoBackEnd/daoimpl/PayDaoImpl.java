package com.niit.MusicanoBackEnd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.MusicanoBackEnd.dao.PayDao;
import com.niit.MusicanoBackEnd.model.Pay;

public class PayDaoImpl implements PayDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public PayDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Override
	public boolean saveorupdatePay(Pay pay)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(pay);
		return true;
	}
	
	@Override
	public boolean deletePay(Pay pay)
	{
		sessionFactory.getCurrentSession().delete(pay);
		return true;
	}
	
	@Override
	public Pay getPay(String paymentId)
	{
		String s="From Pay where paymentId='"+paymentId+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		List<Pay> lcrt=(List<Pay>)q.list();
		if(lcrt==null||lcrt.isEmpty())
		{
			System.out.println("Payment list not found");
			return null;
		}
		else
		{
			System.out.println("Payment list");
			return lcrt.get(0);
		}
	}
	@Override
	public List<Pay> list()
	{
		List<Pay> Pays=(List<Pay>)sessionFactory.getCurrentSession().createCriteria(Pay.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return Pays;
	}
}
