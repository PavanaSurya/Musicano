package com.niit.MusicanoBackEnd.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.MusicanoBackEnd.dao.CategoryDao;
import com.niit.MusicanoBackEnd.dao.ProductDao;
import com.niit.MusicanoBackEnd.dao.SupplierDao;
import com.niit.MusicanoBackEnd.dao.UserDao;
import com.niit.MusicanoBackEnd.daoimpl.CategoryDaoImpl;
import com.niit.MusicanoBackEnd.daoimpl.ProductDaoImpl;
import com.niit.MusicanoBackEnd.daoimpl.SupplierDaoImpl;
import com.niit.MusicanoBackEnd.daoimpl.UserDaoImpl;
import com.niit.MusicanoBackEnd.model.Category;
import com.niit.MusicanoBackEnd.model.Product;
import com.niit.MusicanoBackEnd.model.Supplier;
import com.niit.MusicanoBackEnd.model.User;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement

public class ApplicationContext {
	@Bean("dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test/Musicano");
		dataSource.setUsername("Pavana");
		dataSource.setPassword("suju");
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.connection.pool_size", "10");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}

	@Autowired
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(User.class);

		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean("transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	@Autowired
	@Bean("categoryDao")
	public CategoryDao getCategoryDao(SessionFactory sessionFactory) {
		return new CategoryDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("productDao")
	public ProductDao getProductDao(SessionFactory sessionFactory) {
		return new ProductDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("supplierDao")
	public SupplierDao getSupplierDao(SessionFactory sessionFactory) {
		return new SupplierDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("userDao")
	public UserDao getUserDao(SessionFactory sessionFactory) {
		return new UserDaoImpl(sessionFactory);
	}

}