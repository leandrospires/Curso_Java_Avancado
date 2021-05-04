package br.com.projetogestao.models;

import br.com.projetogestao.interfaces.iDocumento;

public class DocumentoCpf implements iDocumento{
	
	private String numero;

	@Override
	public void setNumero(String numero) {
		//if (numero == null || numero.trim().length() != 11) {
		//	throw new IllegalArgumentException("O CPF deve ter 11 dígitos!");
		//}
		
		/* Regex (Expressões Regulares) */
		if ( (numero == null) || (!numero.matches("[0-9]{11}")) ) {
			
			throw new IllegalArgumentException("O CPF inválido!");
		}
		
		this.numero = numero;
		
	}

	@Override
	public String getNumero() {
		return this.numero;
	}

}
