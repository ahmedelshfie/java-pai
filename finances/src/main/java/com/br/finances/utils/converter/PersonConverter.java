package com.br.finances.utils.converter;

import com.br.finances.dto.PersonDTO;
import com.br.finances.models.Person;

import org.springframework.stereotype.Service;

@Service
public class PersonConverter {

  public PersonDTO converterPersonToPersonDTO(Person p) {
    PersonDTO dto = new PersonDTO();
    dto.setId(p.getId());
    dto.setAddress(p.getAddress());
    dto.setFirstName(p.getFirstName());
    dto.setLastName(p.getLastName());
    dto.setGender(p.getGender());
    return dto;
  }
  
  public Person converterPersonDTOToPerson(PersonDTO p) {
    Person person = new Person();
    person.setId(p.getId());
    person.setAddress(p.getAddress());
    person.setFirstName(p.getFirstName());
    person.setLastName(p.getLastName());
    person.setGender(p.getGender());
    return person;
  }
}