package com.omc.api.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Productor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Double pay;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "PRODUCTOR_CATEORY",
			joinColumns = @JoinColumn(name = "productor_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id")
			)
	private List<Category> categoroies = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "pk.request")
	private Set<ItemsRequest> itens = new HashSet<>();
	
	public Productor() {}

	public Productor(Integer id, String name, Double pay) {
		super();
		this.id = id;
		this.name = name;
		this.pay = pay;
	}
	
	public Set<ItemsRequest> getItens() {
		return itens;
	}

	public void setItens(Set<ItemsRequest> itens) {
		this.itens = itens;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPay() {
		return pay;
	}

	public void setPay(Double pay) {
		this.pay = pay;
	}

	public List<Category> getCategoroies() {
		return categoroies;
	}

	public void setCategoroies(List<Category> categoroies) {
		this.categoroies = categoroies;
	}
	
	@JsonIgnore
	public List<ApiRequest> getRequest() {
		List<ApiRequest> list = new ArrayList<>();
		for (ItemsRequest x : itens) {
//			list.add(x.get());
		}
		return list;
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
		Productor other = (Productor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
