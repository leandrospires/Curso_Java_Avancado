package br.com.gestaovendas.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.gestaovendas.mapper.ClienteMapper;
import br.com.gestaovendas.models.Cliente;

public class ClientesDao implements Dao<Cliente>{

	private JdbcTemplate jdbcTemplate;
	
	public ClientesDao(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public void incluir(Cliente item) throws Exception {
		try {
			String sql = "insert into clientes (documento, nome, email, telefone) values (?, ?, ?, ?)";
			
			this.jdbcTemplate.update(sql,
									item.getDocumento(),
									item.getNome(),
									item.getEmail(),
									item.getTelefone()
									);
			
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Collection<Cliente> listar() throws Exception {
		
		List<Cliente> cli = new ArrayList<>();
		try {
			
			cli = jdbcTemplate.query("select * from clientes", new ClienteMapper());
			
		} catch (Exception e) {
			throw e;
		}

		return cli;
	}

	@Override
	public Cliente buscar(Object key) throws Exception {
		
		Cliente cli = null;
		
		try {
			cli = jdbcTemplate.queryForObject(	"select * from clientes where documento = ?", 
												new String[] {key.toString()},
												new ClienteMapper()
												);
			
		} catch (Exception e) {
			throw e;
		}
		return cli;
	}	
	
	@Override
	public void alterar(Cliente item) throws Exception {
		try {
			String sql = "update clientes "
						+ "set nome = ?, "
						+ "email = ?, "
						+ "telefone = ? "
						+ "where documento = ?";
			
			this.jdbcTemplate.update(	sql,
										item.getNome(), 
										item.getEmail(), 
										item.getTelefone(), 
										item.getDocumento()
										);  
			
		} catch (Exception e) {
			throw e;			
		}
	}

	@Override
	public void remover(Object key) throws Exception {
		try {

			jdbcTemplate.update("delete from clientes where documento = ?", key.toString());
			
		} catch (Exception e) {
			throw e;
		}
	}

}
