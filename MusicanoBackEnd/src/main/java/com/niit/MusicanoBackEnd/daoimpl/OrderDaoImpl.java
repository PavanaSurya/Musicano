package com.niit.MusicanoBackEnd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MusicanoBackEnd.dao.OrderDao;
import com.niit.MusicanoBackEnd.model.Order;

@Transactional
@Repository("orderDao")
@EnableTransactionManagement
public class OrderDaoImpl implements OrderDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public OrderDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean saveorupdateOrd(Order order) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		return true;
	}

	@Override
	public boolean deleteOrd(Order order) {
		
		sessionFactory.getCurrentSession().delete(order);
		return true;
	}

	@Override
	public Order getOrder(String orderId) {
		
		String o="From Order where orderId='"+orderId+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(o);
		List<Order> lcrt=(List<Order>)q.list();
		if(lcrt==null||lcrt.isEmpty())
		{
			System.out.println("Order list not found");
			return null;
		}
		else
		{
			System.out.println("Order list");
			return lcrt.get(0);
		}
	}

	@Override
	public List<Order> list() {
		
		List<Order> Orders=(List<Order>)sessionFactory.getCurrentSession().createCriteria(Order.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return Orders;
	}

}
