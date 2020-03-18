package com.br.finances.exceptions;

import java.io.Serializable;
import java.util.Date;

/**
 * ExceptionResponse
 */
public class ExceptionResponse implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private Date timesTamp;
  private String message;
  private String details;

  public ExceptionResponse(Date timesTamp, String message, String details) {
    this.timesTamp = timesTamp;
    this.message = message;
    this.details = details;
  }


  /**
   * @return the timesTamp
   */
  public Date getTimesTamp() {
    return timesTamp;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @return the details
   */
  public String getDetails() {
    return details;
  }

  /**
   * @param timesTamp the timesTamp to set
   */
  public void setTimesTamp(Date timesTamp) {
    this.timesTamp = timesTamp;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * @param details the details to set
   */
  public void setDetails(String details) {
    this.details = details;
  }
  
}