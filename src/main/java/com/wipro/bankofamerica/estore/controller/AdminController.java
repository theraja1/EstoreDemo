package com.wipro.bankofamerica.estore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.bankofamerica.estore.model.Admin;
import com.wipro.bankofamerica.estore.service.AdminService;

/**
 *
 * @author Rajesh
 */

@RestController
@RequestMapping("/admin")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private  AdminService adminService;

// CREATE
	@PostMapping("/save")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin, HttpServletRequest req){
		logger.info("Admin Rest Controller Implementation : createAdmin() method");
		System.out.println("1... Inside Admin controller");
		Admin adminNew =  adminService.saveAdmin(admin);
//		return ResponseEntity.ok().body(adminNew);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(adminNew);
	}
	
//	READ
	@GetMapping("/getAll")
	public @ResponseBody List<Admin> getAllAdminss(){
		System.out.println("1.. In Admin controller");
		logger.info("Admin Rest Controller Implementation : getAllAdminss() method");
		
		return adminService.getAllAdmins();
		
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Admin> getAdmin(@PathVariable("id") Integer id){
		Admin admin = adminService.getAdminById(id);
		logger.info("Admin Rest Controller Implementation : getAdmin() method");
		System.out.println("Admin Rest Controller Implementation : getAdmin() method");
		
		return ResponseEntity.ok().body(admin);
	}
	
	
	
//	UPDATE
	@PutMapping(value = "/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable("id") Integer id, @RequestBody Admin admin){
		
		Admin admin2 = adminService.getAdminById(id);
		logger.info("Admin Rest Controller Implementation : updateAdmin() method");

		admin2.setFirstName(admin.getFirstName());
		admin2.setLastName(admin.getLastName());
		admin2.setCity(admin.getCity());
		
		Admin admin3 = adminService.saveAdmin(admin2);
		return ResponseEntity.ok().body(admin3);
	}
	
//	DELETE
	@DeleteMapping("/delete/{id}")
	public void deleteAdmin(@PathVariable("id") Integer id ) {
		logger.info("Product Rest Controller Implementation : deleteAdmin() method");
		adminService.deleteAdmin(id);

	}

}
