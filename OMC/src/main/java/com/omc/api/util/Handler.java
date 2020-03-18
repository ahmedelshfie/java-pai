package com.omc.api.util;

import javax.servlet.http.HttpServlet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.omc.api.entity.TypeErrors;

@ControllerAdvice
public class Handler {
	
	@ExceptionHandler(Errors.class)
	public ResponseEntity<TypeErrors> notFound(Errors e, HttpServlet request) {
		TypeErrors te = new TypeErrors(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(te);
	}

}
