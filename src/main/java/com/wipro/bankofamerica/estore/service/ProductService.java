package com.wipro.bankofamerica.estore.service;
import java.util.List;

import com.wipro.bankofamerica.estore.model.Product;
/**
*
* @author Jeevan
*/
public interface ProductService {
	
	//List<Product> or Iterable<Product>-CRUD Operation
	public Iterable<Product> getAllProduct();
	public Product saveProduct(Product product);
	public <optional>Product getProductById(Integer Id);
	public void deleteProduct(Integer id);
	
	public List<Product> findOnlyExProduct(Integer min, Integer max);
	
}
