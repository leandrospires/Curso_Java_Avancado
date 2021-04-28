package br.com.projetogestao.repository;

import br.com.projetogestao.jdbc.ClientesDao;
import br.com.projetogestao.jdbc.UsuariosDao;

public class Repositorio {
	
	static UsuariosDao usuarioDao;
	static ClientesDao clientesDao;
	
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

}
