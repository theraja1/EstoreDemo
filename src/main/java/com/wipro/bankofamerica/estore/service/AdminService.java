package com.wipro.bankofamerica.estore.service;

import java.util.List;

import com.wipro.bankofamerica.estore.model.Admin;

public interface AdminService {
	
//	CRUD Operation
	//List<> or Iterable<> any can be used
	
//	CREATE
	public Admin saveAdmin(Admin admin);

//	READ
	public List<Admin> getAllAdmins();
	public <optional>Admin getAdminById(Integer Id);
	
//	UPDATE****
	
//	DELETE
	public void deleteAdmin(Integer id);
	
//	public List<Product> findOnlyExProduct(Integer min, Integer max);


}
