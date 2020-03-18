package com.omc.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.omc.api.entity.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {

}
