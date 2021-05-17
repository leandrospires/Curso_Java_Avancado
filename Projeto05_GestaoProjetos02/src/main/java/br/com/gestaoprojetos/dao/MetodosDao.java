package br.com.gestaoprojetos.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gestaoprojetos.entities.Pagamento;
import br.com.gestaoprojetos.entities.Projeto;
import br.com.gestaoprojetos.viewmodels.ClientesProjetosVM;

public class MetodosDao {

	private EntityManager em;
	
	//métodos especificos de cada entidade
	//1. métodos para buscar os projetos por cliente, por ID
	public List<Projeto> listarProjetosPorCliente(int idCliente) {
		em = JpaUtil.getEntityManager();
		
		TypedQuery<Projeto> query = em.createQuery("Select p from Projeto p where p.cliente.id = :id", 
													Projeto.class);
		query.setParameter("id", idCliente);
		
		return query.getResultList();
	}
	
	public List<Pagamento> listarPagamentosPorPrestador(String doc) {
		em = JpaUtil.getEntityManager();
		
		TypedQuery<Pagamento> query = em.createQuery("Select p from Pagamento p where p.prestador.documento = :doc", 
													Pagamento.class);
		query.setParameter("doc", doc);
		
		return query.getResultList();
	}		
	
	
	// usando group by
	@SuppressWarnings("unchecked")
	public List<ClientesProjetosVM> listarQuantProjetos() {
		
		List<ClientesProjetosVM> lista = new ArrayList<>();
		
		em = JpaUtil.getEntityManager();
		
		List<Object[]> query = em.createQuery(
				"Select c.nome, c.telefone, count(p.descricao) as quantidade "
				+ "from Cliente c, Projeto p "
				+ "where c.id = p.cliente.id "
				+ "group by c.nome, c.telefone").getResultList();
		
		for (Object[] obj : query) {
			ClientesProjetosVM vm = new ClientesProjetosVM();
			vm.setNomeCliente(obj[0].toString());
			vm.setTelefoneCliente(obj[1].toString());
			vm.setQuantidade( (long) obj[2]);
			
			lista.add(vm);
			
		}
		
		return lista;
	}
}
