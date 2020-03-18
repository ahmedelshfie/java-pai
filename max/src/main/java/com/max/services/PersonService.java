package com.max.services;

import com.max.converter.Converter;
import com.max.dto.PersonDTO;
import com.max.exception.PersonException;
import com.max.model.Person;
import com.max.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  @Autowired
  private PersonRepository repository;

  public Iterable<PersonDTO> findAll() {
    return Converter.parseListObject(repository.findAll(), PersonDTO.class);
  }

  public PersonDTO findById(Long id) {
    var entity = repository.findById(id).orElseThrow(() -> new PersonException("Não encontrado"));
    return Converter.parseObject(entity, PersonDTO.class);
  }

  public PersonDTO create(PersonDTO person) {
    var entity = Converter.parseObject(person, Person.class);
    var dto = Converter.parseObject(repository.save(entity), PersonDTO.class);
    return dto;
  }

  public PersonDTO update(PersonDTO person) {
    Person entity = repository.findById(person.getId()).orElseThrow(() -> new PersonException("Não encontrado"));
    PersonDTO dto = Converter.parseObject(repository.save(entity), PersonDTO.class);
    return dto;
  }

  public void delete(Long id) {
    Person requestPerson = repository.findById(id).orElseThrow(() -> new PersonException("Não encontrado"));
    repository.delete(requestPerson);
//    Converter.parseObject((requestPerson, PersonDTO.class);
  }

  
}