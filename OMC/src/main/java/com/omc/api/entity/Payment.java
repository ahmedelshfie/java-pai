package com.omc.api.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.omc.api.enums.PaymentTypes;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer paymentType;

	@OneToOne
	@JoinColumn(name = "request_id")
	@MapsId
	private ApiRequest apiRequest;
	
	public Payment() { }

	public Payment(Integer id, PaymentTypes paymentType, ApiRequest apiRequest) {
		super();
		this.id = id;
		this.paymentType = paymentType.getCod();
		this.apiRequest = apiRequest;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PaymentTypes getPaymentType() {
		return PaymentTypes.toEnum(paymentType);
	}

	public void setPaymentType(PaymentTypes paymentType) {
		this.paymentType = paymentType.getCod();
	}

	public ApiRequest getApiRequest() {
		return apiRequest;
	}

	public void setApiRequest(ApiRequest apiRequest) {
		this.apiRequest = apiRequest;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
