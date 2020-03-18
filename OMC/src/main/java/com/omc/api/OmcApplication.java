package com.omc.api;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.omc.api.entity.Address;
import com.omc.api.entity.Category;
import com.omc.api.entity.City;
import com.omc.api.entity.Client;
import com.omc.api.entity.Productor;
import com.omc.api.entity.State;
import com.omc.api.enums.TypeClient;
import com.omc.api.repository.CityRepository;
import com.omc.api.repository.ClientRepository;
import com.omc.api.repository.AddressRepository;
import com.omc.api.repository.CategoryRepository;
import com.omc.api.repository.ProductorRepository;
import com.omc.api.repository.StateRepository;

@SpringBootApplication
public class OmcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository ctr;
	
	@Autowired
	private ProductorRepository pr;
	
	@Autowired
	private StateRepository sr;
	
	@Autowired
	private CityRepository cr;
	
	
	@Autowired
	private AddressRepository ar;
	
	@Autowired
	private ClientRepository clientRepo;
	

	public static void main(String[] args) {
		SpringApplication.run(OmcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		Category c1 = new Category(null, "DELL001");
//		Category c2 = new Category(null, "DELL002");
//		Category c3 = new Category(null, "DELL003");
//		Category c4 = new Category(null, "DELL004");
//		Category c5 = new Category(null, "DELL005");
//		
//		Productor p1 = new Productor(null, "Comp.", 4200.00);
//		Productor p2 = new Productor(null, "Mouse", 10.00);
//		Productor p3 = new Productor(null, "DELL", 5200.00);
//		
//		c1.getProductors().addAll(Arrays.asList(p1, p2, p3));
//		c2.getProductors().addAll(Arrays.asList(p2));
//		
//		p1.getCategoroies().add(c1);
//		p2.getCategoroies().addAll(Arrays.asList(c1, c2));
//		p3.getCategoroies().add(c1);
//		
//		ctr.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
//		pr.saveAll(Arrays.asList(p1, p2, p3));
//		
//		State s1 = new State(null, "Minas Gerais");
//		State s2 = new State(null, "São Paulo");
//		
//		City ct1 = new City(null, "Uber", s1);
//		City ct2 = new City(null, "Caracas", s2);
//		City ct3 = new City(null, "Osasco", s2);
//		
//		s1.getCities().add(ct1);
//		s2.getCities().addAll(Arrays.asList(ct2, ct3));
//		
//		sr.saveAll(Arrays.asList(s1, s2));
//		cr.saveAll(Arrays.asList(ct1, ct2, ct3));
//		
//		
//		Client client = new Client(null, "Rafael", "a@gmail.com", "111.222.333-44", TypeClient.PESSOAFISICA);
//		Client client1 = new Client(null, "Rafael Carvalho", "ra@gmail.com", "333.777.123-22", TypeClient.PESSOAJURIDICA);
//		
//		client.getPhones().addAll(Arrays.asList("91111-2222", "94444-2222"));
//		
//		Address a1 = new Address(null, "Rua 001", "001", "Fundos", "NV", "08760-988", client, ct1);
//		Address a2 = new Address(null, "Rua 001", "001", "Fundos", "NV", "08760-988", client1, ct3);
//		
//		client.getAddress().addAll(Arrays.asList(a1, a2));
//		
//		clientRepo.saveAll(Arrays.asList(client, client1));
//		ar.saveAll(Arrays.asList(a1, a2));
		
	}

}
