package com.omc.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.omc.api.entity.ApiRequest;

public interface RequestRepository extends CrudRepository<ApiRequest, Integer> {

}
