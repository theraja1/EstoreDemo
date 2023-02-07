package com.wipro.bankofamerica.estore.serviceImpl;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.bankofamerica.estore.exception.EStoreException;
import com.wipro.bankofamerica.estore.model.Product;
import com.wipro.bankofamerica.estore.model.User;
import com.wipro.bankofamerica.estore.repository.ProductRepository;
import com.wipro.bankofamerica.estore.service.ProductService;

/**
*
* @author Jeevan
*/
@Service
public class ProductServiceImpl implements ProductService{

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private ProductRepository repo; //injecting repo object into productserviceimpl class

	@Override
	public Iterable<Product> getAllProduct() {
		System.out.println("3.. In product service  impl method");
		logger.info("Product Service Implementation : getAllProduct() method");
		List<Product> ls = (List<Product>) repo.findAll();
		Collections.sort(ls);
//		return repo.findAll(); //to get the all list
		return ls; //to get the all list
	}

	@Override
	@Transactional
	public Product saveProduct(Product product) {
		System.out.println("3.. In product service  save impl method");
		
		logger.info("Product Service Implementation : saveProduct() method");
		return repo.save(product); //repo---db --//press f8 --back to api
	}

	@Override
	public Product getProductById(Integer Id) {
		logger.info("Product Service Implementation : getProductById() method");
		Product product=repo.findById(Id);//null
		if(product==null) {  //null==null, 4==null-
			throw new EStoreException("Product id "+Id+" incorrect.."); //calling the constructor
		}
		return product;
	}

	@Override
	public void deleteProduct(Integer id) {
		logger.info("Product Service Implementation : deleteProduct() method");
		repo.deleteById(id);
	}
	
	@Override
	public List<Product> findOnlyExProduct(Integer min, Integer max){
		List<Product> products = repo.findOnlyExpProduct(min, max);
		logger.info("Producr Service Implementation : findOnlyExProduct() method");
		return products;
	}


}
