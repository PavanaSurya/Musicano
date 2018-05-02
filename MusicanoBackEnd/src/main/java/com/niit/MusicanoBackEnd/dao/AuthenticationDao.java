package com.niit.MusicanoBackEnd.dao;

import java.util.List;

import com.niit.MusicanoBackEnd.model.Authentication;

public interface AuthenticationDao 
{
	public boolean saveorupdateAuth(Authentication authentication);
	public boolean deleteAuth(Authentication authentication);
	public Authentication getAuthentication(String roleId);
	public List<Authentication> list();
}
