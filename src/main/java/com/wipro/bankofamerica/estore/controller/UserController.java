package com.wipro.bankofamerica.estore.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.bankofamerica.estore.model.FourDigitNumber;
import com.wipro.bankofamerica.estore.model.Product;
import com.wipro.bankofamerica.estore.model.User;
import com.wipro.bankofamerica.estore.service.UserService;

/**
 *
 * @author Jeevan
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * This method is used to get all the user details
	 * 
	 */
	@GetMapping("/getAll")
	public @ResponseBody Iterable<User> getAllUsers() throws Exception {
		System.out.println("1.. In User controller");
		logger.info("User Rest Controller Implementation : getAllUsers() method");
		return userService.getAllUsers(); // here we are calling //
	}
	
	
	
	/*
	 * This method is used to store the User details for particular user.
	 */

	@PostMapping("/save")
	public ResponseEntity<User> createUser(@RequestBody User user, HttpServletRequest request) throws Exception {
		System.out.println("1... Inside user controller");
		System.out.println("1... Inside user controller");
		User createdUser = userService.saveUser(user);
		logger.info("User Rest Controller Implementation : createUser() method");
		return ResponseEntity.ok().body(createdUser);
	}

	//bookmyshow-
	@GetMapping("/getcity/{city}")
	public ResponseEntity<List<User>> getUserByCity(@PathVariable("city") String city) {
		List<User> user = userService.getListByCity(city);
		logger.info("User Rest Controller Implementation : getUserByCity() method");
		return ResponseEntity.ok().body(user);
	}

	/* API for sending OTP on phone */
	@GetMapping("/getRandomNumber/generation")
	public ResponseEntity<FourDigitNumber> getFourDigitsNumber(@RequestParam String mobileNumber) {
		Random rnd = new Random();
		int number = rnd.nextInt(9999);
		FourDigitNumber fDigitNumber = new FourDigitNumber();
		fDigitNumber.setNumbers(number);
		FourDigitNumber fourDigitNumber2 = userService.saveFourDigitNumber(fDigitNumber);
		return ResponseEntity.ok().body(fourDigitNumber2);
	}

}
