package com.br.finances.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.naming.AuthenticationException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidJwtException extends AuthenticationException {

  private static final long serialVersionUID = 1L;

  public InvalidJwtException(String message) {
    super(message);
  }

  
}