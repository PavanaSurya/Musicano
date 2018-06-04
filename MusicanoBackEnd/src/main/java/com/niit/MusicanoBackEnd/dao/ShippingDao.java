package com.niit.MusicanoBackEnd.dao;

import java.util.List;

import com.niit.MusicanoBackEnd.model.Shipping;

public interface ShippingDao 
{
	public boolean saveorupdateShip(Shipping shipping);
	public boolean deleteShip(Shipping shipping);
	public Shipping getShipping(String shipId);
	public List<Shipping> list();
	public List<Shipping> getaddbyuser(String userId);

}
