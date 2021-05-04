package br.com.projetogestao.models;

import br.com.projetogestao.interfaces.iDocumento;

public class Prestador {
	
	private iDocumento documento;
	private Usuario usuario;
	private String nome;
	private String telefone;
	private String email;
	
	
	public iDocumento getDocumento() {
		return documento;
	}
	public void setDocumento(iDocumento documento) {
		this.documento = documento;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
