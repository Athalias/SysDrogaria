package br.com.Drogaria.Repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.cfg.CreateKeySecondPass;
import br.com.Drogaria.Domain.FabricanteDM;
import br.com.Drogaria.Factory.JPAutil;

public class FabricanteSelect {
	
	EntityManager em = JPAutil.getConnection();
	
	public List<FabricanteDM> listar(){
		Query q = em.createQuery("select a from FabricanteDM a");
		List<FabricanteDM> listfab = q.getResultList();
		return listfab; 
	}
}
