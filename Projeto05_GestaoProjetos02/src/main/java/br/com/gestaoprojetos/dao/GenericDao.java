package br.com.gestaoprojetos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class GenericDao<T> implements Dao<T> {

	private final Class<T> classe;
	protected EntityManager em;
	
	public GenericDao(Class<T> classe) {
		this.classe = classe;
	}
	
	@Override
	public void adicionar(T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<T> listar() {
		em = JpaUtil.getEntityManager();
		//From + nome da Classe
		TypedQuery<T> query = em.createQuery("From " + classe.getSimpleName(), classe);
		
		return query.getResultList();
	}

	@Override
	public T buscar(Object id) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		T item = em.find(classe, id);
		em.getTransaction().commit();
		return item;
	}
	

}
