package br.com.projetogestao.jdbc;

import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Collection;

import br.com.projetogestao.interfaces.iDocumento;
import br.com.projetogestao.models.DocumentoCnpj;
import br.com.projetogestao.models.DocumentoCpf;
import br.com.projetogestao.models.Prestador;
import br.com.projetogestao.utilities.Utils;

public class PrestadoresDao extends Dao<Prestador>{

	private String senha;
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public void incluir(Prestador item) throws Exception {
		
		try {
			abrirConexao();
			CallableStatement cstmt =
					cn.prepareCall("{call incluir_prestador (?, ?, ?, ?, ?, ?)}");
			
			
			
			cstmt.setString(1, item.getDocumento().getNumero());
			cstmt.setString(2, item.getDocumento().getNumero());
			cstmt.setString(3, item.getNome());
			cstmt.setString(4, item.getEmail());
			cstmt.setString(5, item.getTelefone());
			cstmt.setString(6, Utils.verificarMD5(this.senha) );
			
			cstmt.execute();
			
			cstmt.close();
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		
	}

	@Override
	public Collection<Prestador> listar() throws Exception {

		Collection<Prestador> prestadores = new ArrayList<>();
		
		try {
			abrirConexao();
			String sql = "SELECT * FROM prestadores";
			stmt = cn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Prestador p = new Prestador();
				
				String doc = rs.getString("DOCUMENTO");
				iDocumento docCpf = new DocumentoCpf();
				iDocumento docCnpj = new DocumentoCnpj();
				
				if (doc.length() == 11) {
					docCpf.setNumero(doc);
					p.setDocumento(docCpf);
				} else if (doc.length() == 14) {
					docCnpj.setNumero(doc);
					p.setDocumento(docCnpj);
				}
				
				
				p.setNome(rs.getString("NOME"));
				p.setEmail(rs.getNString("EMAIL"));
				p.setTelefone(rs.getString("TELEFONE"));
				prestadores.add(p);
			}
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			fecharConexao();
		}
		
		return prestadores;
	
	}

	@Override
	public Prestador buscar(Object chave) throws Exception {
		return null;
	}

	@Override
	public void excluir(String id) throws Exception {
		try {
			abrirConexao();
			
			String sql = "DELETE FROM prestadores WHERE DOCUMENTO = ?";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, id);
			
			stmt.executeUpdate();	
			
			sql = "DELETE FROM usuarios WHERE NOME = ?";
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
