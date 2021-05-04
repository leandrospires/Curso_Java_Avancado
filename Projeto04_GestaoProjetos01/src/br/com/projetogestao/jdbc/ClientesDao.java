package br.com.projetogestao.jdbc;

import java.util.ArrayList;
import java.util.Collection;

import br.com.projetogestao.models.Cliente;

public class ClientesDao extends Dao<Cliente>{

	@Override
	public void incluir(Cliente item) throws Exception {
		try {
			abrirConexao();
			String sql = "INSERT INTO clientes (USUARIO, NOME, EMAIL, TELEFONE) VALUES (?, ?, ?, ?)";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, item.getUsuario().getNome());
			stmt.setString(2, item.getNome());
			stmt.setNString(3, item.getEmail());
			stmt.setNString(4, item.getTelefone());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
	}

	@Override
	public Collection<Cliente> listar() throws Exception {
		
		Collection<Cliente> clientes = new ArrayList<>();
		
		try {
			abrirConexao();
			String sql = "SELECT * FROM clientes";
			stmt = cn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getInt("IDCLIENTE"));
				c.setNome(rs.getString("NOME"));
				c.setEmail(rs.getNString("EMAIL"));
				c.setTelefone(rs.getString("TELEFONE"));
				clientes.add(c);
			}
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			fecharConexao();
		}
		
		return clientes;
	}

	@Override
	public Cliente buscar(Object chave) throws Exception {
		return null;
	}

	@Override
	public void excluir(String id) throws Exception {
		try {
			abrirConexao();
			
			String sql = "DELETE FROM clientes WHERE IDCLIENTE = ?";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, id);
			
			stmt.executeUpdate();			
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
	}

}
