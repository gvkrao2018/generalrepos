package com.customer.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;

import com.customer.dto.CustomerDTO;
import com.customer.model.CustomerEntity;
import com.customer.repo.CustomerRepository;
import com.customer.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepo;

	@Override
	public void customerSave(CustomerDTO customer) {
	
	CustomerEntity custEnity=transformCustDToToEntity(customer);
	customerRepo.save(custEnity);
		
	}

	private CustomerEntity transformCustDToToEntity(CustomerDTO customer) {
		CustomerEntity cusEntity=new CustomerEntity();
		cusEntity.setCustomerName(customer.getName()!=null ? customer.getName():"");
		cusEntity.setDOB(customer.getDOB()!=null ? customer.getDOB():null);
		cusEntity.setAddress(customer.getAddress()!=null ? customer.getAddress():"");
		if(customer.getDOB()!=null) {
			LocalDate curDate = LocalDate.now();  
		LocalDate dob=customer.getDOB().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int age=Period.between(dob, curDate).getYears();
		cusEntity.setAge(age);
			
		}
		return cusEntity;
	}

}
