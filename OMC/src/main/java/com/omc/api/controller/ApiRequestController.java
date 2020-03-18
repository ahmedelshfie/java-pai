package com.omc.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omc.api.entity.ApiRequest;
import com.omc.api.service.RequestService;

@RestController
@RequestMapping(value = "/request")
public class ApiRequestController {
	
	
	
	@Autowired
	private RequestService reService;

	
	@GetMapping(value = "{id}")
	public ResponseEntity<ApiRequest> findById(@PathVariable("id") Integer id) {		
		ApiRequest cat = new ApiRequest();		
		cat = reService.findApiRequestId(id);		
		if (cat == null) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}		
		return ResponseEntity.ok(cat);	
		
	}

}
