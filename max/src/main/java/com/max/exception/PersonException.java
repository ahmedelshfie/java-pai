package com.max.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public PersonException(String exception) {
    super(exception);
  }
  
}