package com.omc.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.omc.api.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
