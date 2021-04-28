package br.com.projetogestao.jdbc;

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
		return null;
	}

	@Override
	public Cliente buscar(Object chave) throws Exception {
		return null;
	}

}
