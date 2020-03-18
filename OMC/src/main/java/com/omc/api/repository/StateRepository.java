package com.omc.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.omc.api.entity.State;

@Repository
public interface StateRepository extends CrudRepository<State, Integer> {

}
