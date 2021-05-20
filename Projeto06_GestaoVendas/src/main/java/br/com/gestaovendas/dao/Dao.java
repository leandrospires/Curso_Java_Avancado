package br.com.gestaovendas.dao;

import java.util.Collection;

public interface Dao<T> {

	void incluir(T item) throws Exception;
	
	Collection<T> listar() throws Exception;
	
	void alterar(T item) throws Exception;
	
	T buscar(Object key)  throws Exception;
	
	void remover(Object key) throws Exception;
}
