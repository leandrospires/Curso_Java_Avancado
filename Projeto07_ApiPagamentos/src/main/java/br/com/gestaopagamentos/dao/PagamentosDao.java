package br.com.gestaopagamentos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.gestaopagamentos.models.Pagamento;

@Repository
public class PagamentosDao {

	@PersistenceContext
	private EntityManager manager;
	
	public void save(Pagamento pagamento) {
		
		//manager.getTransaction().begin();
		manager.persist(pagamento);
		//manager.getTransaction().commit();
		
	}
	
	public List<Pagamento> list() {
		TypedQuery<Pagamento> query = manager.createQuery("select p from Pagamento p", Pagamento.class);
		
		return query.getResultList();
		
	}
	
	public Pagamento get(int id) {
		TypedQuery<Pagamento> query = manager.createQuery("select p from Pagamento p where p.id = :id", Pagamento.class);
		
		query.setParameter("id", id);
		
		return query.getSingleResult();
	}
}
