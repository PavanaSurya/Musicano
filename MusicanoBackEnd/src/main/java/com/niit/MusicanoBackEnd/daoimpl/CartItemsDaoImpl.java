package com.niit.MusicanoBackEnd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MusicanoBackEnd.dao.CartItemsDao;
import com.niit.MusicanoBackEnd.model.CartItems;

@Transactional
@Repository("cartItemsDao")
@EnableTransactionManagement
public class CartItemsDaoImpl implements CartItemsDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public CartItemsDaoImpl(SessionFactory seesionFactory)
	{
		this.sessionFactory=sessionFactory;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean saveorupdateCarItems(CartItems cartitems) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(cartitems);
		return true;
	}

	@Override
	public boolean deleteCartItems(CartItems cartitems) {
		
		sessionFactory.getCurrentSession().delete(cartitems);
		return true;
	}

	@Override
	public CartItems getCartItems(String cartItems_Id) {
		
		String ci="From CartItems where cartItems_Id='"+cartItems_Id+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(ci);
		List<CartItems> lcrt=(List<CartItems>)q.list();
		if(lcrt==null||lcrt.isEmpty())
		{
			System.out.println("CartItems list not found");
			return null;
		}
		else
		{
			System.out.println("CartItems list");
			return lcrt.get(0);
		}
	}

	@Override
	public List<CartItems> list() {
		
		List<CartItems> Cartitems=(List<CartItems>)sessionFactory.getCurrentSession().createCriteria(CartItems.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return Cartitems;
	}

}
