package com.omc.api.entity;

import javax.persistence.Entity;

import com.omc.api.enums.PaymentTypes;

@Entity
public class PaymentWithCard extends Payment {

	private static final long serialVersionUID = 1L;
	
	private Integer numberParce;
	
	public PaymentWithCard() {}

	public PaymentWithCard(Integer id, PaymentTypes paymentType, ApiRequest apiRequest, Integer number) {
		super(id, paymentType, apiRequest);
		this.numberParce = number;
	}

	public Integer getNumberParce() {
		return numberParce;
	}

	public void setNumberParce(Integer numberParce) {
		this.numberParce = numberParce;
	}
	
	
	
}
