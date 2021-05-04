package br.com.projetogestao.models;

import br.com.projetogestao.interfaces.iDocumento;

public class DocumentoCnpj implements iDocumento{

	private String numero;
	
	@Override
	public void setNumero(String numero) {
		if ( (numero == null) || (!numero.matches("[0-9]{14}")) ) {
			
			throw new IllegalArgumentException("O CNPJ Inv�lido!");
		}
		
		this.numero = numero;
	}

	@Override
	public String getNumero() {
		return this.numero;
	}

}
