package com.example.demo.PessoaService.implement;

import com.example.demo.PessoaService.IPessoaService;
import com.example.demo.repository.PessoaRespository;

public class PessoaService implements IPessoaService {

    private PessoaRespository pessoaRespository;

    public PessoaService(PessoaRespository pessoaRespository) {
        this.pessoaRespository = pessoaRespository;
    }
}
