package com.omc.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omc.api.entity.Client;
import com.omc.api.service.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;

	
	@GetMapping(value = "{id}")
	public ResponseEntity<Client> findById(@PathVariable("id") Integer id) {		
		Client cat = new Client();		
		cat = clientService.findClientId(id);		
		if (cat == null) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}		
		return ResponseEntity.ok(cat);	
		
	}

}
