package com.niit.MusicanoBackEnd.dao;

import java.util.List;

import com.niit.MusicanoBackEnd.model.Billing;

public interface BillingDao 
{
	public boolean saveorupdateBill(Billing billing);
	public boolean deleteBill(Billing billing);
	public Billing getBilling(String billId);
	public List<Billing> list();

}
