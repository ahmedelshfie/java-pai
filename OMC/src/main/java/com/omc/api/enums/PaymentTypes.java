package com.omc.api.enums;

public enum PaymentTypes {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String description;
	
	private PaymentTypes(int code, String description) {
		this.cod = code;
		this.description = description;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static PaymentTypes toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for(PaymentTypes x : PaymentTypes.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
