package com.omc.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.omc.api.entity.ApiRequest;

@Repository
public interface ItemRequestRepository extends CrudRepository<ApiRequest, Integer> {

}
