package br.com.gestaovendas.dao;

import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.gestaovendas.models.Produto;

public class ProdutosDao implements Dao<Produto> {

	private JdbcTemplate jdbcTemplate;
	
	public ProdutosDao(DataSource ds ) {
		jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public void incluir(Produto item) throws Exception {
		try {
			String sql = "insert into produtos "
					+ "(DESCRICAO, UNIDADE, PRECO, IDCATEGORIA, IMAGEM) VALUES "
					+ " (?. ?, ?, ?, ?)";
			
			jdbcTemplate.update(sql,
								item.getDescricao(),
								item.getUnidade(),
								item.getPreco(),
								item.getCategoria().getId(),
								item.getImagem()
								);
			
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Collection<Produto> listar() throws Exception {
		return null;
	}

	@Override
	public void alterar(Produto item) throws Exception {
		
	}

	@Override
	public Produto buscar(Object key) throws Exception {
		return null;
	}

	@Override
	public void remover(Object key) throws Exception {
		
	}

}
