package com.br.finances.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
  "id",
  "address",
  "first_name",
  "last_name",
  "gender"
})
public class PersonDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long key;

  @JsonProperty("first_name")
  private String firstName;

  @JsonProperty("last_name")
  private String lastName;
  private String address;

  @JsonIgnore
  private String gender;


  public PersonDTO() {
  }

  public PersonDTO(Long id, String firstName, String lastName, String address, String gender) {
    this.key = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.gender = gender;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Long getId() {
    return key;
  }

  public void setId(Long id) {
    this.key = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((key == null) ? 0 : key.hashCode());
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
      PersonDTO other = (PersonDTO) obj;
    if (key == null) {
      if (other.key != null)
        return false;
    } else if (!key.equals(other.key))
      return false;
    return true;
  }

  
  
}