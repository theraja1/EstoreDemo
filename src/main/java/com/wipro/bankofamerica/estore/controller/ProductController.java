package com.wipro.bankofamerica.estore.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.bankofamerica.estore.model.Product;
import com.wipro.bankofamerica.estore.model.User;
import com.wipro.bankofamerica.estore.service.ProductService;

/**
 *
 * @author Jeevan -API Layer
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	/**
	 * This method is used to get all the product details
	 * 
	 */
	@GetMapping("/getAll")
	public @ResponseBody Iterable<Product> getAllProduct() throws Exception {
		System.out.println("1.. In product controller");
		logger.info("Product Rest Controller Implementation : getAllProduct() method");
		return productService.getAllProduct(); // here we are calling //

	}

	/*
	 * This method is used to store the product details for particular user.
	 */

	@PostMapping("/save")
	public ResponseEntity<Product> createProduct(@RequestBody Product product, HttpServletRequest request)
			throws Exception {
		System.out.println("1.. In product controller /save");
		Product createdProduct = this.productService.saveProduct(product); //press fn+f6
		logger.info("Product Rest Controller Implementation : createProduct() method");
		System.out.println("-----------------");
		return ResponseEntity.ok().body(createdProduct);

	}
	
	@GetMapping("/getproduct{min}/{max}")
	public ResponseEntity<List<Product>> getFilteredProduct(@PathVariable("min") Integer min, @PathVariable("max")  Integer max){
		List<Product> product = productService.findOnlyExProduct(min,max);
		logger.info("Product Rest Controller Implementation : getFilteredProduct() method");
		return ResponseEntity.ok().body(product);
	}

	/*
	 * This method is used to get the product details by using id
	 */
	@GetMapping("/get/{id}")   //1
	public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
		Product product = productService.getProductById(id); //id should be same
		logger.info("Product Rest Controller Implementation : getProductById() method");
//		return ResponseEntity.ok().body(product);
		return new ResponseEntity(HttpStatus.CONFLICT);

	}

	/*
	 * This method is used to delete the product details of user by using id.
	 */

	@DeleteMapping("/delete/{id}")
	public Map<String, String> deleteProductById(@PathVariable("id") Integer id) throws Exception {
		Product product = productService.getProductById(id); //9
		logger.info("Product Rest Controller Implementation : deleteProductById() method");
		if (product != null) { //9!=null
			productService.deleteProduct(id); //9
			return Collections.singletonMap("success", "Record Deleted Successfully");
		} else {
			return Collections.singletonMap("fail", "Something is wrong");
		}

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Product> updateProductById(@PathVariable("id") Integer id, @RequestBody Product product) {
		Product products = productService.getProductById(id);
		products.setProductId(product.getProductId());
		products.setAmount(product.getAmount());
		products.setProductDescription(product.getProductDescription());
		products.setProductName(product.getProductName());
		products.setQuantity(product.getQuantity());
		products.setStatus(product.getStatus());
		Product products2 = productService.saveProduct(products);
		return ResponseEntity.ok().body(products2);
	}

}
