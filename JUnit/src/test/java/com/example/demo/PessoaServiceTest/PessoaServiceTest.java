package com.example.demo.PessoaServiceTest;

import com.example.demo.PessoaService.implement.PessoaService;
import com.example.demo.modelo.Endereco;
import com.example.demo.modelo.Pessoa;
import com.example.demo.modelo.Telefone;
import com.example.demo.repository.PessoaRespository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
public class PessoaServiceTest {

    @MockBean
    private PessoaRespository pessoaRespository;
    private PessoaService sut;
    private Pessoa pessoa;
    private final String NOME = "Rafael Carvalho";
    private final Long CODE = 1233121L;
    private List<Endereco> AND = new ArrayList<>();
    private List<Telefone> tell = new ArrayList<>();
    private final String CPF = "11111111111";
    private final String PHONE = "123123123123123";

    @Before
    public void setUp() throws Exception {
        sut = new PessoaService(pessoaRespository);
        pessoa = new Pessoa();
        Endereco end = new Endereco();
        Telefone tel = new Telefone();
        tel.setDdd("11");
        tel.setCodigo(21l);
        tel.setNumero("1312321321");
        tel.setPessoa(pessoa);
        end.setPessoa(pessoa);
        end.setBairro("Aquii");
        end.setCidade("Faixa");
        end.setCodigo(12321312l);
        end.setComplemento("Fundos");
        end.setEstado("SP");
        end.setNumero(23);
        end.setLogradouro("ALOG");
        AND.add(end);
        tell.add(tel);
        pessoa.setNome(NOME);
        pessoa.setCpf(CPF);
        pessoa.setCodigo(CODE);
        pessoa.setEnderecos(AND);
        pessoa.setTelefones(tell);
    }

    @Test
    public void deve_salvar_pessoal_no_repository() throws Exception {

    }
}
