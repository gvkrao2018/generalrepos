package com.customer.service.impl;

import org.springframework.stereotype.Service;

import com.customer.dto.ProductDTO;
import com.customer.model.ProductEntity;
import com.customer.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Override
	public void saveProduct(ProductDTO product) {
		
		if(null!=product) {
		ProductEntity prdEnt=convertDTO2Entity(product);
		}
		
		
	}

	private ProductEntity convertDTO2Entity(ProductDTO product) {
		ProductEntity prdEn=new ProductEntity();
		prdEn.setProductName(product.getProductname());
		return null;
	}

	@Override
	public ProductDTO productDetails(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
