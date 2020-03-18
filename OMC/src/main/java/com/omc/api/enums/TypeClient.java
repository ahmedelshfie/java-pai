package com.omc.api.enums;

public enum TypeClient {
	
	PESSOAFISICA(1, "Pessoa Fisica"),
	PESSOAJURIDICA(2, "Pessoa Juridica");
	
	
	private int code;
	private String description;
	
	private TypeClient(int cod, String description) {
		this.code = cod;
		this.description = description;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static TypeClient toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for(TypeClient x : TypeClient.values()) {
			if (cod.equals(x.getCode())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: "+ cod);
	}

}
