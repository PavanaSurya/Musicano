package com.niit.MusicanoBackEnd.dao;

import java.util.List;

import com.niit.MusicanoBackEnd.config.User;

public interface UserDao {
	
	public boolean saveorupdateUs(User user);
	public boolean delete(User user);
	public User getUser(String userId);
	public List<User> list();

}
