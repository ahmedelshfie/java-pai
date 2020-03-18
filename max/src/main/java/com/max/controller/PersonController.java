package com.max.controller;

import com.max.dto.PersonDTO;
import com.max.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person/v1")
public class PersonController {

  @Autowired
  private PersonService personService;

  @GetMapping
  public Iterable<PersonDTO> listAll() {
    return personService.findAll();
  }

  @GetMapping(value = "/{id}")
  public PersonDTO personId(@PathVariable("id") Long id) {
    return personService.findById(id);
  }

  @PostMapping
  public PersonDTO personCreste(@RequestBody PersonDTO person) {
    return personService.create(person);
  }

  @PutMapping
  public PersonDTO personUpdate(@RequestBody PersonDTO person) {
    return personService.update(person);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) {
    personService.delete(id);
    return ResponseEntity.ok().build();
  }

  
}