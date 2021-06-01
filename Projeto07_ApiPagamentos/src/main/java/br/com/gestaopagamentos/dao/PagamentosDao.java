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
		manager.persist(pagamento);
	}
	
	public List<Pagamento> list() {
		TypedQuery<Pagamento> query = manager.createQuery("select p from Pagamento p", Pagamento.class);
		
		return query.getResultList();
		
	}
	
	public Pagamento get(int id) {
		TypedQuery<Pagamento> query = manager
				.createQuery("Select p from Pagamento p where p.id = :id", Pagamento.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	public Pagamento getByOrder(String id) {
		
		System.out.println("id: " + id);
		
		TypedQuery<Pagamento> query = manager
				.createQuery("Select p from Pagamento p where p.numeropedido = :id", 
						Pagamento.class);
		query.setParameter("id", id);
		return query.getSingleResult();
		
	}
		
	
	public Pagamento get(String numeropedido) {
		Pagamento pg = new Pagamento();
		
		try {
			TypedQuery<Pagamento> query = manager.createQuery("select p from Pagamento p where p.numeropedido = :numeropedido", Pagamento.class);
			
			query.setParameter("numeropedido", numeropedido);
			pg = query.getSingleResult();
			return pg;
			
		} catch (Exception e) {
			
			return pg;
			
		}
		
		

		
		
	}	
}
