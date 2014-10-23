package br.com.Drogaria.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.Drogaria.Domain.ProdutoDM;
import br.com.Drogaria.Factory.JPAutil;

public class ProdutoSelect {
	EntityManager em = JPAutil.getConnection();
	
	public List<ProdutoDM> listar(){
		Query q = em.createQuery("select a from ProdutoDM a");
		List<ProdutoDM> listProd = q.getResultList();
		return listProd;	
	}
}
