package com.br.finances.service;

import com.br.finances.adapter.DozerConverter;
import com.br.finances.dto.PersonDTO;
import com.br.finances.exceptions.ControllerNotFoundException;
import com.br.finances.models.Person;
import com.br.finances.repository.PersonRespository;
import com.br.finances.utils.converter.PersonConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


  @Autowired
  private PersonRespository repository;

  @Autowired
  private PersonConverter converte;

  public PersonDTO personById(Long id) {
    Person person = repository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Person Not Found"));
    return converte.converterPersonToPersonDTO(person);
    // return DozerConverter.parseObject(person, PersonDTO.class);
  }

  public Iterable<PersonDTO> personList() {
    return DozerConverter.parseObject(repository.findAll(), PersonDTO.class);
  }

  public PersonDTO personCreate(PersonDTO person) {
    Person entity = DozerConverter.parseObject(person, Person.class);
    PersonDTO dto = DozerConverter.parseObject(repository.save(entity), PersonDTO.class);
    return dto;
  }

  public PersonDTO personUpdate(PersonDTO person) {
    Person psn = repository.findById(person.getId()).orElseThrow(() -> new ControllerNotFoundException("Person Not Found"));
    PersonDTO dto = DozerConverter.parseObject(repository.save(psn), PersonDTO.class);
    return dto;
  }

  public void personDelete(Long id) {
    repository.deleteById(id);
  }

}