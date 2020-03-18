package com.omc.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omc.api.entity.Client;
import com.omc.api.repository.ClientRepository;
import com.omc.api.util.Errors;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clRepo;
	
	public Client findClientId(Integer id) {
		Optional<Client> cat = clRepo.findById(id);
		if (cat == null) {
			throw new Errors("Erro no id: "+ id + " do tipo : " + Client.class.getName());
		}
		return cat.orElse(null);
	}
}
