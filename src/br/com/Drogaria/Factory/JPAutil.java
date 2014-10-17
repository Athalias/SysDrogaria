package br.com.Drogaria.Factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAutil {

	public static EntityManagerFactory emf;

	public static EntityManager getConnection() {

		if (emf == null) {

			emf = Persistence.createEntityManagerFactory("DbDrogaria");
		}
		return emf.createEntityManager();
	}

	public static void close() {

		emf.close();
	}
}
