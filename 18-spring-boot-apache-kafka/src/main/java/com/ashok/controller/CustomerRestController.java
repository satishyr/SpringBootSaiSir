package com.ashok.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.model.Customer;
import com.ashok.service.CustomerService;

/**
 * This class is used to handle user requests
 * 
 * @author Ashok
 *
 */
@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	/**
	 * This method is used to get Customer Records in json format
	 * 
	 * @return
	 */
	@GetMapping(value = "/getAllCustomer", produces = MediaType.APPLICATION_JSON)
	public List<Customer> getAll() {
		Customer c1 = new Customer(101, "Ashok", "ashok@gmail.com");
		Customer c2 = new Customer(102, "Raj", "raj@gmail.com");
		Customer c3 = new Customer(102, "John", "john@gmail.com");

		List<Customer> list = new ArrayList();
		list.add(c1);
		list.add(c2);
		list.add(c3);

		return list;
	}

	/**
	 * This method is used to Customer records in post request
	 * 
	 * @param customers
	 * @return
	 */
	@PostMapping(value = "/addCustomers", consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String addCustomers(@RequestBody List<Customer> customers) {
		Customer c = new Customer(101, "Ashok", "ashok@gmail.com");
		System.out.println("In Controller---> Customer:::" + c);
		return customerService.addAll(customers);
	}

	@PostMapping(value = "/addCustomer", consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String addCustomer(@RequestBody Customer c) {
		System.out.println("In Controller---> Customer:::" + c);
		return customerService.add(c);
	}
}
