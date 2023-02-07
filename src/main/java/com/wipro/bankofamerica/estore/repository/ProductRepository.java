package com.wipro.bankofamerica.estore.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.wipro.bankofamerica.estore.model.Product;
/**
*
* @author Jeevan-DAO Layer
*/
@Repository
//public interface ProductRepository extends CrudRepository<Product, Serializable>{
	public interface ProductRepository extends JpaRepository<Product, Serializable>{
	
	public Product findById(Integer Id);
	
	@Query(value="select * from product p where amount>?1 and amount<?2  ",nativeQuery = true )
	List<Product> findOnlyExpProduct(Integer min, Integer max);
		

}
