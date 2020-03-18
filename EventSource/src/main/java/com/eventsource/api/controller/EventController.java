package com.eventsource.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eventsource.api.model.Event;
import com.eventsource.api.repository.EventSourceRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@Api(value = "API-REST")
@RestController
@RequestMapping(value = "/event")
public class EventController {
	
	@Autowired
	private EventSourceRepository er;

	Map<String, String> errors;
	
	@ApiOperation(value = "Return List EventSource")
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Event> list() {
		Iterable<Event> listEvent = er.findAll();
		ArrayList<Event> events = new ArrayList<>();
		
		for (Event event : listEvent) {
			long code = event.getId();
			event.add(linkTo(methodOn(EventController.class).eventTo(code)).withSelfRel());
			events.add(event);
		}
		return listEvent;
	}
	
	@ApiOperation(value = "Return List EventSource")
	@GetMapping(value = "{id}", produces = "application/json")
	public @ResponseBody Event eventTo(@PathVariable("id") long id) {
		Event es = er.findById(id);
		es.add(linkTo(methodOn(EventController.class).list()).withRel("Lista de Eventos"));
		return es;
	}
	
	@ApiOperation(value = "Save EventSource")
	@PostMapping
	public ResponseEntity<?> create(@RequestBody @Valid Event e, BindingResult resul) {
		if (resul.hasErrors()) {
			errors = new HashMap<>();
			for (FieldError i : resul.getFieldErrors()) {
				errors.put(i.getField(), i.getDefaultMessage());
			}
			return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
		}
		if (e == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(er.save(e), HttpStatus.OK);
	}

	
//	@DeleteMapping
//	public boolean deleteId(Integer id) {
//		boolean flag = false;
//		if (id  != null) {
//			er.deleteById(id);
//			flag = true;
//		}
//		return flag;
//	}
	
	@ApiOperation(value = "Delete EventSource")
	@DeleteMapping()
	public Event delete(@RequestBody Event e) {
		er.delete(e);
		return e;
	}
}
