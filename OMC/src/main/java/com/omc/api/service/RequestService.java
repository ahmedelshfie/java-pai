package com.omc.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omc.api.entity.ApiRequest;
import com.omc.api.repository.RequestRepository;
import com.omc.api.util.Errors;

@Service
public class RequestService {
	
	
	@Autowired
	private RequestRepository reqRepo;
	
	public ApiRequest findApiRequestId(Integer id) {
		Optional<ApiRequest> cat = reqRepo.findById(id);
		if (cat == null) {
			throw new Errors("Erro no id: "+ id + " do tipo : " + ApiRequest.class.getName());
		}
		return cat.orElse(null);
	}

}
