package br.com.gestaovendas.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.gestaovendas.mapper.ClientePedidosMapper;
import br.com.gestaovendas.mapper.ProdutosItensMapper;
import br.com.gestaovendas.models.Pedido;
import br.com.gestaovendas.viewmodels.ClientePedidosVM;
import br.com.gestaovendas.viewmodels.ProdutosItensVM;

public class PedidosDao implements Dao<Pedido>{

	private JdbcTemplate jdbcTemplate;
	
	public PedidosDao(DataSource ds ) {
		jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public void incluir(Pedido item) throws Exception {
		try {
			String sql = "insert into pedidos (numeropedido, datapedido, doccliente) "
					+ "value (?, ?, ?)";
			
					jdbcTemplate.update(sql, 
										item.getNumeroPedido(),
										new java.sql.Date(item.getDataPedido().getTime()),
										item.getDocumentoCliente());
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public void remover(Object key) throws Exception {
		
		try {
			String sql = "delete from itens where id = ?";
			
			jdbcTemplate.update(sql, key.toString());									
			
		} catch (Exception e) {
			throw e;
		}
	}	
	
	public Collection<ClientePedidosVM> listarPedidos(String documento) throws Exception {
		
		Collection<ClientePedidosVM> pedidos = new ArrayList<>();		
		try {
			String sql = "select p.id as id,"
					+ " p.numeropedido as pedido,"
					+ " p.datapedido as data,"
					+ " c.documento  as documento,"
					+ " c.nome as cliente"
					+ " from pedidos p , clientes c"
					+ " where p.DOCCLIENTE = c.DOCUMENTO"
					+ " and c.documento = ?";
			pedidos = jdbcTemplate.query(	sql, 
											new String[] {documento}, 
											new ClientePedidosMapper()
										);
		} catch (Exception e) {
			throw e;
		}
		
		return pedidos;
	}
	
	public ClientePedidosVM buscarPedido (int idPedido) throws Exception {

		ClientePedidosVM pedidosVM = new ClientePedidosVM();
		try {
			String sql = "select p.id as id,"
						+ " p.numeropedido as pedido,"
						+ " p.datapedido as data,"
						+ " c.documento  as documento,"
						+ " c.nome as cliente"
						+ " from pedidos p , clientes c"
						+ " where p.DOCCLIENTE = c.DOCUMENTO"
					  	+ " and p.ID = ?";
			
			pedidosVM = jdbcTemplate.queryForObject(sql,
													new Integer[] {idPedido},
													new ClientePedidosMapper()
													);
		} catch (Exception e) {
			throw e;
		}
		
		return pedidosVM;
	}
	
	public Collection<ProdutosItensVM> buscarItensPorPedido (int idPedido) throws Exception {
		
		Collection<ProdutosItensVM> produtosVM = new ArrayList<>();
		
		try {
			String sql = "select i.id as idItens,"
					+ " i.IDPEDIDO as idPedido,"
					+ " p.descricao as descricao,"
					+ " p.preco as precoUnitario,"
					+ " i.quantidade as quantidade,"
					+ " (p.preco * i.quantidade) as valorTotal"
					+ " from  produtos p , itens i"
					+ " where p.ID = i.IDPRODUTO"
					+ " and i.IDPEDIDO = ?";
			
			produtosVM = jdbcTemplate.query(	sql, 
												new Integer[] {idPedido}, 
												new ProdutosItensMapper()
											);					
					
		} catch (Exception e) {
			throw e;
		}
		
		return produtosVM;
	}
	
	public double retornarValorTotalPorPredido (int idPedido) throws Exception {
		
		double valorTotalPedido = 0; 
		
		try {
			
			
			String sql = "select ifnull(sum((p.preco * i.quantidade)), 0) as valorTotal"
					+ " from  produtos p , itens i"
					+ " where p.ID = i.IDPRODUTO"
					+ " and i.IDPEDIDO = ?";
			
			valorTotalPedido = (Double) jdbcTemplate.queryForObject(	sql,
																		new Integer[] {idPedido},
																		Double.class);
			return valorTotalPedido;
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public Collection<Pedido> listar() throws Exception {
		return null;
	}

	@Override
	public void alterar(Pedido item) throws Exception {
	}

	@Override
	public Pedido buscar(Object key) throws Exception {
		return null;
	}

}
