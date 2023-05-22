package com.customer.microservice.VaccinationCenter.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.customer.microservice.VaccinationCenter.entity.VaccinationCenter;
import com.customer.microservice.VaccinationCenter.model.Citizen;
import com.customer.microservice.VaccinationCenter.model.VaccineCenterAndCitizenDetails;
import com.customer.microservice.VaccinationCenter.repo.VaccineCenterRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



@RestController
@RequestMapping("/vaccinationcenters")
public class VaccinationCenterController {
	
	@Autowired
	VaccineCenterRepo vaccineCenterRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/add-vaccine-center")
	public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter vaccinationCenter) {
		UUID uuid=UUID.randomUUID();
		vaccinationCenter.setVaccineCenterId(uuid.toString());
		VaccinationCenter vaccinationCenterAdd = vaccineCenterRepo.save(vaccinationCenter);
		return new ResponseEntity<>(vaccinationCenterAdd,HttpStatus.CREATED);
	}
	
	@GetMapping("/{vaccineCenterId}")
	@CircuitBreaker(name = "circuitbreakactivity", fallbackMethod = "recoverFailure" )
	public ResponseEntity<VaccineCenterAndCitizenDetails> vacCenterDetails(@PathVariable String vaccineCenterId) {
		VaccinationCenter vaccinationCenterAdd = vaccineCenterRepo.findByVaccineCenterId(vaccineCenterId);
		VaccineCenterAndCitizenDetails vaccineCenterAndCitizenDetails=new VaccineCenterAndCitizenDetails();
		vaccineCenterAndCitizenDetails.setVaccinationCenter(vaccinationCenterAdd);
		vaccineCenterAndCitizenDetails.setCitizens(restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/citizens-by-vcenter/"+vaccineCenterId, List.class));
		return new ResponseEntity<>(vaccineCenterAndCitizenDetails,HttpStatus.OK);
	}
	
	public ResponseEntity<VaccineCenterAndCitizenDetails> vacCenterDetails(@PathVariable String vaccineCenterId, Throwable throwable) {
		
		VaccinationCenter vaccinationCenterAdd = vaccineCenterRepo.findByVaccineCenterId(vaccineCenterId);
		VaccineCenterAndCitizenDetails vaccineCenterAndCitizenDetails=new VaccineCenterAndCitizenDetails();
		vaccineCenterAndCitizenDetails.setVaccinationCenter(vaccinationCenterAdd);
		return new ResponseEntity<>(vaccineCenterAndCitizenDetails,HttpStatus.OK);
	}

}
