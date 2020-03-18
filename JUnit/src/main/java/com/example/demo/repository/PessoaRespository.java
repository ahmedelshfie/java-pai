package com.example.demo.repository;

import com.example.demo.modelo.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRespository extends JpaRepository<Pessoa, Integer> {
}
