package br.com.gestaovendas.dao;

import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.gestaovendas.models.Item;

public class ItensDao implements Dao<Item>{

	private JdbcTemplate jdbcTemplate;
	
	public ItensDao(DataSource ds ) {
		jdbcTemplate = new JdbcTemplate(ds);
	}	
	
	@Override
	public void incluir(Item item) throws Exception {
		
		try {
			String sql = "insert into itens (idpedido, idproduto, quantidade) "
					+ "values (?, ?, ?)";
			
			jdbcTemplate.update(sql,
								item.getIdPedido(),
								item.getIdProduto(),
								item.getQuantidade()
								);
			
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public Collection<Item> listar() throws Exception {
		return null;
	}

	@Override
	public void alterar(Item item) throws Exception {
	}

	@Override
	public Item buscar(Object key) throws Exception {
		return null;
	}

	@Override
	public void remover(Object key) throws Exception {
	}

}
