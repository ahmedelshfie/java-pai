package com.br.finances.controller;
import java.net.URI;

import com.br.finances.dto.PersonDTO;
import com.br.finances.service.PersonService;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

  @Autowired
  private PersonService service;
  
  @GetMapping
  public ResponseEntity<Iterable<PersonDTO>> personControllerListAll() {
    Iterable<PersonDTO> person = service.personList();
    return ResponseEntity.ok().body(person);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<PersonDTO> personControllerById(@PathVariable("id") Long id) {
    PersonDTO person = service.personById(id);
    return ResponseEntity.ok().body(person);
  }

  @PostMapping
  public ResponseEntity<Void> personControllerCreate(@RequestBody PersonDTO person) {
    PersonDTO personObj = service.personCreate(person);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(personObj.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping
  public ResponseEntity<PersonDTO> personControllerUpdate(@RequestBody PersonDTO person) {
    service.personUpdate(person);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> personControllerDelete(@PathVariable("id") Long id) {
    service.personDelete(id);
    return ResponseEntity.noContent().build();
  }
  
}