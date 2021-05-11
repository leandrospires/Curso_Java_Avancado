package br.com.gestaoprojetos.aplicacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.gestaoprojetos.entities.Cliente;
import br.com.gestaoprojetos.helper.ClientesHelper;

public class AppClientes {

	public static void main(String[] args) {
		listarTodosClientes();
	}
	
	// persistence-unit name="jpaPU" do persistence.xml
	private static void listarTodosClientes () {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em = emf.createEntityManager();
		
		ClientesHelper helper = new ClientesHelper(em);
		
		List<Cliente> clientes = helper.listarClientes();
		
		for (Cliente cliente : clientes) {
			System.out.println("Id......: " + cliente.getId());
			System.out.println("Nome....: " + cliente.getNome());
			System.out.println("E-mail..: " + cliente.getEmail());
			System.out.println("Usuario.: " + cliente.getUsuario());
			System.out.println("Telefone: " + cliente.getTelefone());
			System.out.println("--------------------");
		}
		
	}
}
