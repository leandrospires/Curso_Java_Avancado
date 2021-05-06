	package br.com.projetogestao.jdbc;

import java.util.ArrayList;
import java.util.Collection;

import br.com.projetogestao.models.Usuario;
import br.com.projetogestao.utilities.Utils;

public class UsuariosDao extends Dao<Usuario> {

	public Usuario validar(String nome, String senha) throws Exception {
		Usuario usuario = null;
		
		try {

			abrirConexao();
			String sql = "SELECT * FROM usuarios WHERE NOME = ? AND SENHA = ?";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, nome );
			stmt.setString(2, Utils.verificarMD5(senha) );
			
			rs = stmt.executeQuery();
			
			if ( rs.next() ) {
				usuario = new Usuario();
				usuario.setNome(rs.getString("NOME"));
				usuario.setSenha(rs.getString("SENHA"));
				usuario.setNivel(Utils.buscarNivel(rs.getString("NIVEL")));				
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		
		return usuario;
	}
	
	@Override
	public void incluir(Usuario item) throws Exception {
		try {
			abrirConexao();
			
			String sql = "INSERT INTO usuarios (NOME, SENHA, NIVEL) VALUES (?, ?, ?)";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, item.getNome());
			stmt.setString(2, Utils.verificarMD5(item.getSenha()) );
			stmt.setString(3, item.getNivel().toString());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			
			fecharConexao();
		}
		
	}

	@Override
	public Collection<Usuario> listar() throws Exception {
		Collection<Usuario> usuarios = new ArrayList<>();
		
		try {
			abrirConexao();
			String sql = "SELECT * FROM usuarios";
			stmt = cn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Usuario u = new Usuario();
				u.setNome(rs.getString("NOME"));
				u.setSenha(rs.getString("SENHA"));
				u.setNivel(Utils.buscarNivel(rs.getString("NIVEL")));
				
				usuarios.add(u);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		
		
		return usuarios;
	}

	@Override
	public Usuario buscar(Object chave) throws Exception {
		Usuario usuario = null;
		
		try {
			if ( !(chave instanceof String) ) {
				throw new Exception("Tipo de parâmetro inválido: deve ser uma String");
			}

			abrirConexao();
			String sql = "SELECT * FROM usuarios WHERE NOME = ?";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, (String)chave ); //typecast
			
			rs = stmt.executeQuery();
			
			if ( rs.next() ) {
				usuario = new Usuario();
				usuario.setNome(rs.getString("NOME"));
				usuario.setSenha(rs.getString("SENHA"));
				usuario.setNivel(Utils.buscarNivel(rs.getString("NIVEL")));				
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		
		return usuario;
	}

	@Override
	public void excluir(String id) throws Exception {
		
	}

}
