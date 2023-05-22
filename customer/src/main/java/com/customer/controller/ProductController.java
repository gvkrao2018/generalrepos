package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.constants.ProductConstants;
import com.customer.dto.ProductDTO;
import com.customer.service.ProductService;

@RestController
public class ProductController {
	
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/general/product/save")
	public ResponseEntity<String> createProduct(@RequestBody ProductDTO product){
		try {
		productService.saveProduct(product);
		return new ResponseEntity("product creted successfully", HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity("problem in product creation", HttpStatus.BAD_REQUEST);
		}
	}

}
