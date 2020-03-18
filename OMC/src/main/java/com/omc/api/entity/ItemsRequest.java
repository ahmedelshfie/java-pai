package com.omc.api.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemsRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemRequestPk pk = new ItemRequestPk();
	
	private Double desc;
	private Integer quant;
	private Double pay;
	
	public ItemsRequest() {	}

	public ItemsRequest(ApiRequest req, Productor prod, Double desc, Integer quant, Double pay) {
		super();
		this.pk.setRequest(req);
		this.pk.setProductor(prod);
		this.desc = desc;
		this.quant = quant;
		this.pay = pay;
	}

	public ItemRequestPk getPk() {
		return pk;
	}

	public void setPk(ItemRequestPk pk) {
		this.pk = pk;
	}

	public Double getDesc() {
		return desc;
	}

	public void setDesc(Double desc) {
		this.desc = desc;
	}

	public Integer getQuant() {
		return quant;
	}

	public void setQuant(Integer quant) {
		this.quant = quant;
	}

	public Double getPay() {
		return pay;
	}
	
	@JsonIgnore
	public Productor getProductor() {
		return pk.getProductor();
	}
	
	@JsonIgnore
	public ApiRequest getApiRequest() {
		return pk.getRequest();
	}

	public void setPay(Double pay) {
		this.pay = pay;
	}


	
	
	
	

}
