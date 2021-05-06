package br.com.projetogestao.repository;

import br.com.projetogestao.jdbc.ClientesDao;
import br.com.projetogestao.jdbc.PrestadoresDao;
import br.com.projetogestao.jdbc.UsuariosDao;

public class Repositorio {
	
	static UsuariosDao usuarioDao;
	static ClientesDao clientesDao;
	static PrestadoresDao prestadoresDao;
	
	public static UsuariosDao getUsuariosDao() {
		
		if (usuarioDao == null) {
			usuarioDao = new UsuariosDao();
		}
		
		return usuarioDao;
	}
	
	public static ClientesDao getClientesDao() {
		
		if (clientesDao == null) {
			clientesDao = new ClientesDao();
		}
		
		return clientesDao;
	}	

	public static PrestadoresDao getPrestadoresDao() {
		
		if (prestadoresDao == null) {
			prestadoresDao = new PrestadoresDao();
		}
		
		return prestadoresDao;
	}	
	
}
