package com.omc.api.util;

import java.io.Serializable;

public class Errors extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Errors(String msg) {
		super(msg);
	}	
	
	public Errors(String msg, Throwable cause) {
		super(msg, cause);
	}

}
