package com.customer.microservice.VaccinationCenter.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.microservice.VaccinationCenter.entity.VaccinationCenter;

public interface VaccineCenterRepo extends JpaRepository<VaccinationCenter, String>{

public VaccinationCenter findByVaccineCenterId(String vaccineCenterId);
}
