package com.omc.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.omc.api.entity.Productor;

@Repository
public interface ProductorRepository extends CrudRepository<Productor, Integer>{

}
