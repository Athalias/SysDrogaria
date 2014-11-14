package br.com.Drogaria.Repository;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.Drogaria.Domain.ProdutoDM;
import br.com.Drogaria.Factory.JPAutil;

public abstract class GenericRepo<T> {
	
	private Class<T> entityClass;
	
	@PostConstruct
	private void inicializar() {
		entityClass = ((Class) ((java.lang.reflect.ParameterizedType) this
				.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	EntityManager em = JPAutil.getConnection();

	public T Insert(T entity){
		
		em.getTransaction().begin();
		em.persist(entity);
		T entityInsert = entity;
		em.getTransaction().commit();
		em.close();
		return entityInsert; 
	}
	
	public T Update(T entity) {
		em.getTransaction().begin();
		T entityUpdate = em.merge(entity);
		em.getTransaction().commit();
		em.close();
		return entityUpdate;
	}	
	
	public void Delete(T entity) {
		em.getTransaction().begin();
		T entityDelete = em.merge(entity);
		em.remove(entityDelete);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<T> Select() {
		Query query = em.createQuery("FROM " + entityClass.getName());
		return query.getResultList();
	}
}
