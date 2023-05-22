package com.customer.microservice.VaccinationCenter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Citizen {

	private String id;
	private String name;
	private String vacinationCenterId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVacinationCenterId() {
		return vacinationCenterId;
	}
	public void setVacinationCenterId(String vacinationCenterId) {
		this.vacinationCenterId = vacinationCenterId;
	}
	
}
