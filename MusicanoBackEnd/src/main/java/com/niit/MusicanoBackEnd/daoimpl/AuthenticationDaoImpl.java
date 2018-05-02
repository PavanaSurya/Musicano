package com.niit.MusicanoBackEnd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.MusicanoBackEnd.dao.AuthenticationDao;
import com.niit.MusicanoBackEnd.model.Authentication;

@Transactional
@Repository("authenticationDao")
@EnableTransactionManagement
public class AuthenticationDaoImpl implements AuthenticationDao {
	@Autowired
	SessionFactory sessionFactory;
	
public AuthenticationDaoImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean saveorupdateAuth(Authentication authentication) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(authentication);
		return true;
	}

	@Override
	public boolean deleteAuth(Authentication authentication) {
		
		sessionFactory.getCurrentSession().delete(authentication);
		return true;
	}

	@Override
	public Authentication getAuthentication(String roleId) {
		
		String a="From Authentication where roleId='"+roleId+"'";
		Query q=sessionFactory.getCurrentSession().createQuery(a);
		List<Authentication> lcrt=(List<Authentication>)q.list();
		if(lcrt==null||lcrt.isEmpty())
		{
			System.out.println("Authentication list not found");
			return null;
		}
		else
		{
			System.out.println("Authentication list");
			return lcrt.get(0);
		}
	}

	@Override
	public List<Authentication> list() {
		
		List<Authentication> Authentications=(List<Authentication>)sessionFactory.getCurrentSession().createCriteria(Authentication.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return Authentications;
	}

}
