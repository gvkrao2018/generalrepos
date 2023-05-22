package com.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.model.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
	

}
