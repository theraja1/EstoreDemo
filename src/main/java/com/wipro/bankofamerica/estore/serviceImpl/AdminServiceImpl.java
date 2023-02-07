package com.wipro.bankofamerica.estore.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.bankofamerica.estore.model.Admin;
import com.wipro.bankofamerica.estore.repository.AdminRepository;
import com.wipro.bankofamerica.estore.service.AdminService;


//**** @author Rajesh

@Service
public class AdminServiceImpl implements AdminService{
	
	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Autowired
	private AdminRepository adminRepository;


	@Override
	public Admin saveAdmin(Admin admin) {
		System.out.println("3.. In Admin service  impl method");
		logger.info("Admin Service Implementation : saveAdmin() method");
		
		
		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdmins() {
		System.out.println("3.. In Admin service  impl method");
		
		logger.info("Admin Service Implementation : getAllAdmins() method");
		return (List<Admin>) adminRepository.findAll();
	}

	@Override
	public <optional> Admin getAdminById(Integer Id) {
		logger.info("Admin Service Implementation : getAdminById() method");
		Admin admin =  adminRepository.findById(Id);
		
		if(admin == null) {
			throw new NullPointerException("Admin id "+Id+" incorrect..");
		}
		
		return admin;
	}

	@Override
	public void deleteAdmin(Integer id) {
		System.out.println("In Admin service  impl: deleteAdmin() method");
		logger.info("Admin Service Implementation : deleteAdmin() method");
		adminRepository.deleteById(id);
	}

}
