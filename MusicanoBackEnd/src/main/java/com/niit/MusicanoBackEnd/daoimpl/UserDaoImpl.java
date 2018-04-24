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
import com.niit.MusicanoBackEnd.model.User;
import com.niit.MusicanoBackEnd.dao.UserDao;

@Transactional
@Repository
@EnableTransactionManagement
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean saveorupdateUs(User user) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}

	@Override
	public boolean delete(User user) {
		
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	@Override
	public User getUser(String userId) {
		
		String s="From User where userId='"+userId+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		List<User> lcrt=(List<User>)q.list();
		if(lcrt==null||lcrt.isEmpty())
		{
			System.out.println("User list not found");
			return null;
		}
		else
		{
			System.out.println("User list");
			return lcrt.get(0);
		}
	}

	@Override
	public List<User> list() {
		
		List<User> Users=(List<User>)sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return Users;
	}

}
