package br.com.gestaovendas.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class Cliente {
	
	@CPF(message = "CPF Inválido")
	@Size(min=11, max=14, message="Documento deve ter entre 11 e 14 dígitos")
	private String documento;
	
	@NotEmpty(message="O nome deve ser informado")
	@Size(max=45, message="Nome deve ter até 45 caracteres")
	private String nome;
	
	@Email(message = "E-mail inválido")
	@Size(min=5, max=60, message="E-mail deve ter entre 5 e 60 caracteres")
	private String email;
	
	@Size(min=6, max=20, message="Telefone informado incorretamente")
	private String telefone;
	

	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
