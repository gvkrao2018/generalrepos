package com.customer.repo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.JpaRepository;


import com.customer.model.CustomerEntity;


public interface CustomerRepository extends JpaRepository<CustomerEntity,Long>{

	 Optional<CustomerEntity> findById(Long id);
	 List<CustomerEntity> findAll();
     Optional<CustomerEntity> findByName(String name);
		
	
    @Override
    default List<CustomerEntity> findAll(Sort sort) {
    	CustomerEntity [] customersArr = null;
    List<Order> customers=sort.descending().toList();
    List<CustomerEntity> customersOrdered=Arrays.asList(customers.toArray(customersArr));
    	return customersOrdered;
    }
}
