package com.niit.MusicanoBackEnd.dao;

import java.util.List;

import com.niit.MusicanoBackEnd.model.Pay;

public interface PayDao {
	
	public boolean saveorupdatePay(Pay pay);
	public boolean deletePay(Pay pay);
	public Pay getPay(String paymentId);
	public List<Pay> list();

}
