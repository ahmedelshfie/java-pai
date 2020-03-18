package com.br.finances.repository;

import com.br.finances.models.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRespository extends JpaRepository<Person, Long>{

}