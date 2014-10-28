package br.com.Drogaria.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.Drogaria.Domain.UsuarioDM;
import br.com.Drogaria.Factory.JPAutil;

public class UsuarioSelect {

	EntityManager em = JPAutil.getConnection();

	public List<UsuarioDM> listarLogin(String login, String senha) {
		Query q = em
				.createQuery("select a from UsuarioDM a where a.login = :login and a.senha = :senha");
		q.setParameter("login", login);
		q.setParameter("senha", senha);
		List<UsuarioDM> listUsu = q.getResultList();
		return listUsu;
	}
}
