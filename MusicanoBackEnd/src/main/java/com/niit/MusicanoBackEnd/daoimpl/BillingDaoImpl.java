package com.niit.MusicanoBackEnd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MusicanoBackEnd.dao.BillingDao;
import com.niit.MusicanoBackEnd.model.Billing;

@Transactional
@Repository("billingDao")
@EnableTransactionManagement
public class BillingDaoImpl implements BillingDao{
	@Autowired
	SessionFactory sessionFactory;
	
public BillingDaoImpl(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
	// TODO Auto-generated constructor stub
}

	@Override
	public boolean saveorupdateBill(Billing billing) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(billing);
		return true;
	}

	@Override
	public boolean deleteBill(Billing billing) {
		
		sessionFactory.getCurrentSession().delete(billing);
		return true;
	}

	@Override
	public Billing getBilling(String billId) {

		String b="From Billing where userId='"+billId+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(b);
		List<Billing> lcrt=(List<Billing>)q.list();
		if(lcrt==null||lcrt.isEmpty())
		{
			System.out.println("Billing list not found");
			return null;
		}
		else
		{
			System.out.println("Billing list");
			return lcrt.get(0);
		}
	}

	@Override
	public List<Billing> list() {
		
		List<Billing> Billings=(List<Billing>)sessionFactory.getCurrentSession().createCriteria(Billing.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return Billings;
	}

}
