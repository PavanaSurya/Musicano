package com.niit.MusicanoBackEnd.dao;

import java.util.List;

import com.niit.MusicanoBackEnd.model.Supplier;

public interface SupplierDao {

	public boolean saveorupdateSup(Supplier supplier);

	public boolean deleteSup(Supplier supplier);

	public Supplier getSupplier(String supId);

	public List<Supplier> list();

}
