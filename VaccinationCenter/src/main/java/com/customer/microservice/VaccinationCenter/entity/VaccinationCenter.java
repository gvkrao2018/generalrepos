package com.customer.microservice.VaccinationCenter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationCenter {
	
	@Id
	private String vaccineCenterId;
	private String centerName;
	private String centerAddress;
	public String getVaccineCenterId() {
		return vaccineCenterId;
	}
	public void setVaccineCenterId(String vaccineCenterId) {
		this.vaccineCenterId = vaccineCenterId;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterAddress() {
		return centerAddress;
	}
	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}

}
