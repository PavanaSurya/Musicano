package com.niit.MusicanoBackEnd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MusicanoBackEnd.dao.OrderItemsDao;
import com.niit.MusicanoBackEnd.model.OrderItems;

@Transactional
@Repository ("orderItemsDao")
@EnableTransactionManagement
public class OrderItemsDaoImpl implements OrderItemsDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public OrderItemsDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean saveorupdateOrditem(OrderItems orderitems) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(orderitems);
		return true;
	}

	@Override
	public boolean deleteOrditem(OrderItems orderitems) {
		
		sessionFactory.getCurrentSession().delete(orderitems);
		return true;
	}

	@Override
	public OrderItems getOrderItems(String orderItem_Id) {
		
		String oi="From OrderItems where orderItem_Id='"+orderItem_Id+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(oi);
		List<OrderItems> lcrt=(List<OrderItems>)q.list();
		if(lcrt==null||lcrt.isEmpty())
		{
			System.out.println("OrderItems list not found");
			return null;
		}
		else
		{
			System.out.println("OrderItems list");
			return lcrt.get(0);
		}
	}

	@Override
	public List<OrderItems> list() {
		
		List<OrderItems> orderitems=(List<OrderItems>)sessionFactory.getCurrentSession().createCriteria(OrderItems.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return orderitems;
	}

}
