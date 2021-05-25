package br.com.gestaovendas.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.gestaovendas.mapper.ClientePedidosMapper;
import br.com.gestaovendas.models.Pedido;
import br.com.gestaovendas.viewmodels.ClientePedidosVM;

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
	
	public Collection<ClientePedidosVM> listarPedidos(String documento) throws Exception {
		
		Collection<ClientePedidosVM> pedidos = new ArrayList<>();		
		try {
			String sql = "select p.id as idPedido,"
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
			String sql = "select p.numeropedido as pedido,"
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

	@Override
	public void remover(Object key) throws Exception {
	}

}
