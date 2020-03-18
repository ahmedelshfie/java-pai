package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Pessoas;



public class Main {
	
	public static void main(String[] args) {
		
		
		/*
		Pessoas p1 = new Pessoas(null, "Rafael-001", "a@gmail.com");
		Pessoas p2 = new Pessoas(null, "Rafael-002", "b@gmail.com");
		Pessoas p3 = new Pessoas(null, "Rafael-003", "c@gmail.com");
		Pessoas p4 = new Pessoas(null, "Rafael-004", "d@gmail.com");
		*/
		
		EntityManagerFactory enf = Persistence.createEntityManagerFactory("jpa-hard");
		EntityManager emp = enf.createEntityManager();
		
		/*
	    // create new peaple
		emp.getTransaction().begin();
		emp.persist(p1);
		emp.persist(p2);
		emp.persist(p3);
		emp.persist(p4);
		//emp.getTransaction().commit();
		*/
		
		// buscando
		Pessoas p = emp.find(Pessoas.class, 1);

		// DELETE busca e depois remove
		emp.getTransaction().begin();
		emp.remove(p);
		emp.getTransaction().commit();
		
		System.out.println(p);
		emp.close();
		enf.close();
		
	}

}
