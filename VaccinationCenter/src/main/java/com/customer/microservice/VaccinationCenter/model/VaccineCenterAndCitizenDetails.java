package com.customer.microservice.VaccinationCenter.model;

import java.util.List;

import com.customer.microservice.VaccinationCenter.entity.VaccinationCenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineCenterAndCitizenDetails {
	private List<Citizen> citizens;
	private VaccinationCenter vaccinationCenter;
	public List<Citizen> getCitizens() {
		return citizens;
	}
	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}
	public VaccinationCenter getVaccinationCenter() {
		return vaccinationCenter;
	}
	public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
		this.vaccinationCenter = vaccinationCenter;
	}
	
	

}
