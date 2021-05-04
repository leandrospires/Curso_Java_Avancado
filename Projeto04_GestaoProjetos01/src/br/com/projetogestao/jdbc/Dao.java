package br.com.projetogestao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;

public abstract class Dao<T> {

	//Objetos de Acesso a Dados
	protected Connection cn;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	
	//String de conexão: servidor/banco_de_dado
	String url = "jdbc:mysql://localhost:3306/db_projetos";
		
	//métodos para abrir e fechar a conexão
	protected void abrirConexao() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url, "root", "admin");
	}
	
	
	protected void fecharConexao() throws Exception {

		if ( cn != null && !cn.isClosed() ) {
			cn.close();
		}
		
	}
	
	public abstract void incluir(T item) throws Exception;
	
	public abstract void excluir(String id) throws Exception;
	
	public abstract Collection<T> listar() throws Exception;
	
	public abstract T buscar(Object chave) throws Exception;
}
