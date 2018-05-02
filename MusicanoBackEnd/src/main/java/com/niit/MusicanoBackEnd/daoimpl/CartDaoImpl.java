package com.niit.MusicanoBackEnd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MusicanoBackEnd.dao.CartDao;
import com.niit.MusicanoBackEnd.model.Cart;

@Transactional
@Repository("cartDao")
@EnableTransactionManagement
public class CartDaoImpl implements CartDao{
	@Autowired
	SessionFactory sessionFactory;

	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean saveorupdateCart(Cart cart) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
	}

	@Override
	public boolean deleteCart(Cart cart) {
		
		sessionFactory.getCurrentSession().delete(cart);
		return true;
	}

	@Override
	public Cart getCart(String cart_Id) {
		
		String cr="From Cart where cart_Id='"+cart_Id+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(cr);
		List<Cart> lcrt=(List<Cart>)q.list();
		if(lcrt==null||lcrt.isEmpty())
		{
			System.out.println("Cart list not found");
			return null;
		}
		else
		{
			System.out.println("Cart list");
			return lcrt.get(0);
		}
	}

	@Override
	public List<Cart> list() {
		
		List<Cart> Carts=(List<Cart>)sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return Carts;
	}

}
