package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.dto.CustomerDTO;
import com.customer.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/customer/save-customer")
	public ResponseEntity<String> saveCustomer(@RequestBody CustomerDTO customer) {
		
		if(null!=customer) {
			customerService.customerSave(customer);
		}
		return new ResponseEntity("customer is saved",HttpStatus.OK);
	}

}
