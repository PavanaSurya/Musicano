package com.niit.MusicanoBackEnd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MusicanoBackEnd.model.Authentication;
import com.niit.MusicanoBackEnd.model.Category;
import com.niit.MusicanoBackEnd.model.User;
import com.niit.MusicanoBackEnd.dao.UserDao;

@Transactional
@Repository("userDao")
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
		Authentication auth=new Authentication();
		auth.setUserName(user.getEmail_Id());
		user.getBilling().setUser(user);
		user.getBilling().setPh_no(user.getPh_no());
		user.getBilling().setAddr(user.getAddr());
		sessionFactory.getCurrentSession().saveOrUpdate(user.getCart());
		sessionFactory.getCurrentSession().saveOrUpdate(user.getBilling());
		sessionFactory.getCurrentSession().saveOrUpdate(auth);
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

	@Override
	public User isValid(String umail, String pwd) {
		String s="From User where email_Id='"+umail+"' and pwd='"+pwd+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		List<User> lcrt=(List<User>)q.list();
		if(lcrt==null||lcrt.isEmpty())
		{
			return null;
		}
		else
		{
			return lcrt.get(0);
		}
	}

	@Override
	public User getEmail(String currusername) {
		String s="From User where email_Id='"+currusername+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(s);
		List<User> lcrt=(List<User>)q.list();
		if(lcrt==null||lcrt.isEmpty())
		{
			System.out.println("User List Not Found");
			return null;
		}
		else
		{
			System.out.println("User List");
			return lcrt.get(0);
		}
	}

	}

