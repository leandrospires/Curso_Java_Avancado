package br.com.gestaoprojetos.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.gestaoprojetos.entities.Cliente;

public class ClientesHelper {
	
	//variável usada para acessar o BD por meio das entidades
	private EntityManager em;
	
	//construtor
	public ClientesHelper (EntityManager em) {
		this.em = em;
	}

	//Método para listar os clientes - usando JPQL
	public List<Cliente> listarClientes() {
		
		// deve ser usado o nome da entidade (classe)
		TypedQuery<Cliente> query = em.createQuery("select c from Cliente c", Cliente.class); 
		
		return query.getResultList();
	}
}
