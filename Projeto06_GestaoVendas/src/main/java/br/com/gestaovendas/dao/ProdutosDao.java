package br.com.gestaovendas.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.gestaovendas.mapper.CategoriaMapper;
import br.com.gestaovendas.mapper.ProdutoMapper;
import br.com.gestaovendas.models.Categoria;
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
					+ " (?, ?, ?, ?, ?)";
			
			jdbcTemplate.update(sql,
								item.getDescricao(),
								item.getUnidade(),
								item.getPreco(),
								item.getCategoria(),
								item.getImagem()
								);
			
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Collection<Produto> listar() throws Exception {
		Collection<Produto> produtos = new ArrayList<>();
		
		try {

			produtos = jdbcTemplate.query("select * from produtos", new ProdutoMapper());
			
		} catch (Exception e) {
			throw e;
		}
		
		return produtos;
	}

	@Override
	public void alterar(Produto item) throws Exception {
		
	}

	@Override
	public Produto buscar(Object key) throws Exception {
		Produto pro = null;
		try {
			pro = jdbcTemplate.queryForObject("select * from produtos where id = ?", new Integer[] {(int) key} , new ProdutoMapper());
			
			
		} catch (Exception e) {
			throw e;
		}
		
		return pro;
	}

	@Override
	public void remover(Object key) throws Exception {
		
	}
	
	//Métodos para lista e buscar uma Categoria
	public List<Categoria> listarCategorias() throws Exception{
		
		List<Categoria> categorias = new ArrayList<>();
		try {

			categorias = jdbcTemplate.query("select * from categorias", new CategoriaMapper());
			
		} catch (Exception e) {
			throw e;
		}
		
		return categorias;
	}
	
	public Categoria buscarCategoria(int id) throws Exception {
		
		Categoria cat = null;
		try {
			
			cat = jdbcTemplate.queryForObject("select * from categorias where id = ?", 
												new Integer[] {id},
												new CategoriaMapper()
												);
			
		} catch (Exception e) {
			throw e;
		}
		
		return cat;
	}

}
