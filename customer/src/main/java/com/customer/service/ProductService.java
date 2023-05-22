package com.customer.service;

import com.customer.dto.ProductDTO;

public interface ProductService {
	
	public void saveProduct(ProductDTO product);
	
	public ProductDTO productDetails(int productId);

}
