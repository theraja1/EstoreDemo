package com.wipro.bankofamerica.estore.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.bankofamerica.estore.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Serializable>{

	public Admin findById(Integer id);
}
