package com.omc.api.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemRequestPk implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "request_id")
	private ApiRequest request;
	
	@ManyToOne
	@JoinColumn(name = "productor_id")
	private Productor productor;
	
	public ApiRequest getRequest() {
		return request;
	}
	
	public void setRequest(ApiRequest request) {
		this.request = request;
	}
	
	public Productor getProductor() {
		return productor;
	}
	
	public void setProductor(Productor productor) {
		this.productor = productor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productor == null) ? 0 : productor.hashCode());
		result = prime * result + ((request == null) ? 0 : request.hashCode());
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
		ItemRequestPk other = (ItemRequestPk) obj;
		if (productor == null) {
			if (other.productor != null)
				return false;
		} else if (!productor.equals(other.productor))
			return false;
		if (request == null) {
			if (other.request != null)
				return false;
		} else if (!request.equals(other.request))
			return false;
		return true;
	}
	
	
	
	
}
